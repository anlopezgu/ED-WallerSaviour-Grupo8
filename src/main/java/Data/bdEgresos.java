/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Data.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author ANDRES
 */
public class bdEgresos {
    Fila Egresos = new Fila();

   /* public void tomarEgresos() throws InterruptedException, ExecutionException {
        CollectionReference salidas = ConexionBD.bd.collection("egresos");
        ApiFuture<QuerySnapshot> querySnapshot = salidas.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            NodoDinero NodoIn = new NodoDinero(Integer.parseInt(document.getString("amount")), document.getString("kind"), document.getString("fecha"));
            Egresos.Enqueue(NodoIn);
        }

    }*/
    

    public Fila getEgresos() {
        return Egresos;
    }
    
}
