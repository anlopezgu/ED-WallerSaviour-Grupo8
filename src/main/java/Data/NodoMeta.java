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
public class NodoMeta {
    String amount;
    String name;
    NodoMeta previous = null;
    NodoMeta next = null;

    public String getAmount() {
        return amount;
    }
    
    public String getName() {
        return name;
    }

    public NodoMeta getNext() {
        return next;
    }

    public NodoMeta getPrevious() {
        return previous;
    }
    

    public NodoMeta(String amount,String name) {
        this.amount=amount;
        this.name = name;
    }
    
    
}
