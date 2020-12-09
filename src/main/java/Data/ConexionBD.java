/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author ANDRES
 */
public class ConexionBD {
    public static Firestore bd;
    public static MinHeap Movimientos = new MinHeap(100);
    public static MapH User = new MapH();
    public static ListaMetas Metas = new ListaMetas();
    
    public static void conectar() throws IOException{

        FileInputStream serviceAccount
                = new FileInputStream("BDkey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://bdws-2340b.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        bd = FirestoreClient.getFirestore();
        
}
        public static boolean insertarDatos(String user,String coleccion,String ID,NodoDinero nodo){
            
            try {
            DocumentReference docref = bd.collection("users").document(user).collection(coleccion).document(ID);
            ApiFuture<WriteResult> result = docref.set(nodo);
            System.out.println("Udate time : "+ result.get().getUpdateTime());
            return true;
            }catch (Exception e){
            }
            return false;
        }
        public static boolean nuevaMeta(String user,String coleccion,String ID,NodoMeta nodo){
            
            try {
            DocumentReference docref = bd.collection("users").document(user).collection(coleccion).document(ID);
            ApiFuture<WriteResult> result = docref.set(nodo);
            System.out.println("Udate time : "+ result.get().getUpdateTime());
            return true;
            }catch (Exception e){
            }
            return false;
        }
        public static boolean eliminarMeta(String user,String coleccion,String ID){
            
            try {
            DocumentReference docref = bd.collection("users").document(user).collection(coleccion).document(ID);
            ApiFuture<WriteResult> result = docref.delete();
            System.out.println("Udate ttime : "+ result.get().getUpdateTime());
            return true;
            }catch (Exception e){
            }
            return false;
        }
        public static boolean nuevoUsuario(String ID,NodoUser nodo){
            
            try {
            DocumentReference docref = bd.collection("users").document(ID);
            ApiFuture<WriteResult> result = docref.set(nodo);
            for(int i = 0;i<3;i++){
                String uuid = java.util.UUID.randomUUID().toString();
                NodoDinero newN = new NodoDinero("0", "registro", "1/11/1111");
                insertarDatos(ID, "movimientos",uuid ,newN );
            }
            System.out.println("Udate time : "+ result.get().getUpdateTime());
            return true;
            }catch (Exception e){
            }
            return false;
        }
        
        public static MinHeap getData(String user) throws InterruptedException, ExecutionException{
            //asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> future = bd.collection("users").document(user).collection("movimientos").get();
// future.get() blocks on response
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                NodoDinero NodoIn = new NodoDinero(document.getString("amount"), document.getString("kind"), document.getString("fecha"));
                Movimientos.insert(NodoIn);
                
            }
        return Movimientos;
        }
        public static ListaMetas getMetas(String user) throws InterruptedException, ExecutionException{
            //asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> future = bd.collection("users").document(user).collection("metas").get();
// future.get() blocks on response
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                NodoMeta NodoIn = new NodoMeta(document.getString("amount"), document.getString("name"));
                Metas.PushFront(NodoIn);
                
            }
        return Metas;
        }
        public static MapH getUsers() throws InterruptedException, ExecutionException{
            //asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> future = bd.collection("users").get();
// future.get() blocks on response
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                User.add(document.getId(), document.getString("value"),document.getString("name"),document.getString("lastname"),document.getString("address"));
                
                
            }
        return User;
        }
        /*
        public static Pila getIngresos() throws InterruptedException, ExecutionException{
            //asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> future = bd.collection("ingresos").get();
// future.get() blocks on response
            
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            System.out.println("mesirve");
            for (QueryDocumentSnapshot document : documents) {
                System.out.println("mesirve2");
                System.out.println(document.getString("kind"));
                NodoDinero NodoIn = new NodoDinero(document.getString("amount"), document.getString("kind"), document.getString("fecha"));
                Ingresos.Push(NodoIn);
            }
        return Ingresos;
        }*/

   
    
}
