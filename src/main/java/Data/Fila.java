/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author ANDRES
 */
public class Fila{
  private NodoDinero front = null;
  private NodoDinero back = null;

  public Boolean Empty(){
    if (front == null){
      return true;
    }
    else {
      return false;
    } 
  }

  public void Enqueue(NodoDinero Nodo){
    if (front==null){
      front = Nodo;
      back = Nodo;
    }
    else{
      back.next=Nodo;
      back=Nodo;
    }
  }

  public void Dequeue(){
    front=front.next;
    try{front.previous=null;}
    catch (Exception e){front= null;}
  }

  public NodoDinero Peek(){
    return front;
  }

  public void makeEmpty(){
    while(front!=null){
      if(front.previous!=null){
        front = front.previous;
        front.next=null;
    }
      else{
        front=null;
    }
    }
  }

}
