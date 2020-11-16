package Logic;
import Data.*;
import UI.*;
import static java.awt.image.ImageObserver.WIDTH;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDRES
 */
public class Logic {
    
    public static ListaMetas Metas(){
        NodoMeta M1 = new NodoMeta(50000,"Casa nueva");
        NodoMeta M2 = new NodoMeta(12000,"Xbox Series X");
        NodoMeta M3 = new NodoMeta(5000,"Carro nuevo");
        NodoMeta M4 = new NodoMeta(90000,"Tv");
        NodoMeta M5 = new NodoMeta(140000,"Regalo para Pedro");
        
        
        ListaMetas Metas = new ListaMetas();
        
        Metas.PushBack(M1);
        Metas.PushBack(M2);
        Metas.PushBack(M3);
        Metas.PushBack(M4);
        Metas.PushBack(M5);
        
        
        return Metas;
    }

    /*public static Pila Ingresos(){
        
        Nodo E1 = new NodoDinero(15000,"xd","11/10/2020");
        Nodo E2 = new NodoDinero(20000,"xdxd","12/10/2020");
        Nodo E3 = new NodoDinero(8000,"xdxdxd","13/10/2020");
        Nodo E4 = new NodoDinero(7500,"xdxdxdxd","14/10/2020");
        Nodo E5 = new NodoDinero(6500,"xdxdxdxdxd","15/10/2020");
        Nodo E6 = new NodoDinero(12700,"xdxdxdxdxdxd","16/10/2020");
        Nodo E7 = new NodoDinero(1000,"xdxdxdxdxdxdxd","17/10/2020");

  

        
        
        Pila Ingresos = new Pila();
        
        
        Ingresos.Push(E1);
        Ingresos.Push(E2);
        Ingresos.Push(E3);
        Ingresos.Push(E4);
        Ingresos.Push(E5);
        Ingresos.Push(E6);
        Ingresos.Push(E7);
       
        
        return Ingresos;
    }
    
    public static Fila Egresos(){
        Nodo G1 = new NodoDinero(8000,"xd","13/10/2020");
        Nodo G2 = new NodoDinero(16000,"xdxd","14/10/2020");
        Nodo G3 = new NodoDinero(2000,"xdxdxd","15/10/2020");
        Nodo G4 = new NodoDinero(9000,"xdxdxdxd","16/10/2020");
        Nodo G5 = new NodoDinero(300,"xdxdxdxdxd","17/10/2020");
        Nodo G6 = new NodoDinero(4500,"xdxdxdxdxd","18/10/2020");
        Nodo G7 = new NodoDinero(6000,"xdxdxdxdxd","19/10/2020");
        
        Fila Egresos = new Fila();
        
        Egresos.Enqueue(G1);
        Egresos.Enqueue(G2);
        Egresos.Enqueue(G3);
        Egresos.Enqueue(G4);
        Egresos.Enqueue(G5);
        Egresos.Enqueue(G6);
        Egresos.Enqueue(G7);
        return Egresos;
    }
    
    public static int IngresosInt(){
        
        Pila Ingresos = Logic.Ingresos();
        int IngresosInt=0;
        while (Ingresos.Empty()==false){
            IngresosInt=IngresosInt+(Ingresos.Pop().getAmount());
            
    }
        return IngresosInt;
    }
    
    public static int EgresosInt(){
        Fila Egresos = Logic.Egresos();
        int EgresosInt=0;
        while (Egresos.Empty()==false){
            EgresosInt=EgresosInt+(Egresos.Peek().getAmount());
            Egresos.Dequeue();
            
    }
        return EgresosInt;
    }*/
}
