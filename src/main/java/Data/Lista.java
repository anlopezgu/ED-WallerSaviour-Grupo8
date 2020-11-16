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
public class Lista {
  private NodoDinero head = null;
  private NodoDinero tail = null;

    public NodoDinero getHead() {
        return head;
    }

    public NodoDinero getTail() {
        return tail;
    }
  

  public Boolean Empty(){
    if (head == null){
      return true;
    }
    else {
      return false;
    } 
  }
  public void PushFront(NodoDinero Nodo){
    if (head == null){
      head = Nodo;
      tail = head;
    }
    else{
      //
      NodoDinero nextNode = head;

      head.previous=Nodo;
      head=Nodo;
      
      //
      head.next = nextNode;
    }
  }

  public void PushBack(NodoDinero Nodo){
    if (head == null){
      head = Nodo;
      tail = head;
    }
    else{
      NodoDinero previousNode = tail;
      
      tail.next = Nodo;
      tail=Nodo;
      tail.previous = previousNode;
    }
  }

  public NodoDinero TopFront(){
    if (head == null){
      return null;
    }
    else{
      return head;
    }
  }

  public void PopFront(){
    head=head.next;
    head.previous = null;
  }

  public NodoDinero TopBack(){
    if (head == null){
      return null;
    }
    else{
      return tail;
    }
  }

  public void PopBack(){
    tail=tail.previous;
    tail.next=null;
  }


  public Boolean Find(String find){
    NodoDinero Findkey = head;
    Boolean answer;
    while (Findkey.next != null){
      if(Findkey.amount== find){
        answer = true;
        break;
      }
      else{
        Findkey=Findkey.next;
      }
    }
    if(tail.amount== find){
      answer = true;
    }
    else{
      answer = false;
    }
  return answer;
  }

  public void Erase(String erase){
    NodoDinero Erasekey = head;
    while (Erasekey.next != null){
      if(Erasekey.amount== erase){
        NodoDinero nextNode = Erasekey.next;
        NodoDinero previousNode = Erasekey.previous;
        Erasekey=null;
        previousNode.next=nextNode;
        nextNode.previous=previousNode;
        break;
      }
      else{
        Erasekey=Erasekey.next;
      }
    }
  }

  public void AddBefore(NodoDinero Nodo,String x){
    NodoDinero FindNodo =head;
    NodoDinero FindPrevious;
    Boolean match=false;
    while (FindNodo.next != null){
      if((FindNodo==head)&&(FindNodo.amount== x)){

        head.previous=Nodo;
        Nodo.next=head;
        head=Nodo;
        match=true;
        break;
      }
      else if(FindNodo.amount== x){
        FindPrevious = FindNodo.previous;

        FindPrevious.next=Nodo;
        Nodo.previous=FindPrevious;
        Nodo.next=FindNodo;
        FindNodo.previous=Nodo;
      match=true;

        break;
      }
      else{
        FindNodo=FindNodo.next;
      }
    }
    if (match==false){
      if(tail.amount== x){
        FindPrevious = FindNodo.previous;

        FindPrevious.next=Nodo;
        Nodo.previous=FindPrevious;
        Nodo.next=FindNodo;
        FindNodo.previous=Nodo;
      match=true;
      }
      else{
        System.out.println("No existe el dato "+x);
      }
    }
  }



public void AddAfter(NodoDinero Nodo,String x){
    NodoDinero FindNodo =head;
    NodoDinero FindNext,FindPrevious;
    Boolean match=false;
    while (FindNodo.next != null){
      if((FindNodo==head)&&(FindNodo.amount== x)){
        NodoDinero nextNodo = head.next;

        head.next=Nodo;
        Nodo.next=nextNodo;
        Nodo.previous=head;
        nextNodo.previous=Nodo;    
      
        
        match=true;
        break;
      }
      else if(FindNodo.amount== x){
        FindNext = FindNodo.next;

        FindNext.previous=Nodo;
        Nodo.previous=FindNodo;
        Nodo.next=FindNext;
        FindNodo.next=Nodo;
        match=true;

        break;
      }
      else{
        FindNodo=FindNodo.next;
      }
    }
    if (match==false){
      if(tail.amount== x){
        tail.next=Nodo;
        Nodo.previous=tail;
        tail=Nodo;
      }
      else{
        System.out.println("No existe el dato "+x);
      }
    }
  }
  
  public void String(){
    NodoDinero nodo = head;
    while (nodo!=tail){
      System.out.println(nodo.amount);
      nodo=nodo.next;}
    System.out.println(nodo.amount);
    System.out.println("");
  }  
}
