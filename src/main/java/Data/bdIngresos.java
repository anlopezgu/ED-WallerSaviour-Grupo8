/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author ANDRES
 */
public class bdIngresos {
    /*
    Pila Ingresos = new Pila();
    
    public void tomarIngresos() throws InterruptedException, ExecutionException {
        CollectionReference entradas = ConexionBD.bd.collection("ingresos");
        ApiFuture<QuerySnapshot> querySnapshot = entradas.get();

        
        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            
            NodoDinero NodoIn = new NodoDinero(document.getString("amount"), document.getString("kind"), document.getString("fecha"));
            Ingresos.Push(NodoIn);
        }

    }

    public Pila getIngresos() {
        return Ingresos;
    }*/
    
}
