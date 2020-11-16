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
        public static boolean insertarDatos(String coleccion,String ID,NodoDinero nodo){
            
            try {
            DocumentReference docref = bd.collection(coleccion).document(ID);
            ApiFuture<WriteResult> result = docref.set(nodo);
            System.out.println("Udate time : "+ result.get().getUpdateTime());
            return true;
            }catch (Exception e){
            }
            return false;
        }
        
        public static MinHeap getData() throws InterruptedException, ExecutionException{
            //asynchronously retrieve all documents
            ApiFuture<QuerySnapshot> future = bd.collection("movimientos").get();
// future.get() blocks on response
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                NodoDinero NodoIn = new NodoDinero(document.getString("amount"), document.getString("kind"), document.getString("fecha"));
                Movimientos.insert(NodoIn);
                
            }
        return Movimientos;
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
