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
public class Pila{
  private NodoDinero top = null;

  public Boolean Empty(){
    if(top==null){
      return true;
    }
    else{
      return false;
    }
  }
  public void Push(NodoDinero Nodo){
    if (top==null){
      top=Nodo;
    }
    else{
      Nodo.previous=top;
      top.next=Nodo;
      top=Nodo;
    }
  }

  public NodoDinero Top(){
    return top;
  }

  public NodoDinero Pop(){
    NodoDinero pop,topPrevious,topNext;
    pop=top;
    if(top.previous!=null){
      topNext=top.next;
      topPrevious=top.previous;
      
      top = topPrevious;
      topNext=null;
    }
    else{
      top=null;
    }
    return pop;
  }

  public void makeEmpty(){
    while(top!=null){
      if(top.previous!=null){
        top = top.previous;
        top.next=null;
    }
      else{
        top=null;
    }
    }
  }

public void String(){
    NodoDinero nodo = top;
    while (nodo!=null){
      System.out.println(nodo.amount);
      nodo=nodo.previous;}
    System.out.println(nodo.amount);
    System.out.println("");
  }
  
}
