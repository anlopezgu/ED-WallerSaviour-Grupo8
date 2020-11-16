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
public abstract class Nodo{
  int amount;
  Nodo previous = null;
  Nodo next = null;

    public int getAmount() {
        return amount;
    }
  
  

  public Nodo(int amount){
    this.amount = amount;
  }
}
