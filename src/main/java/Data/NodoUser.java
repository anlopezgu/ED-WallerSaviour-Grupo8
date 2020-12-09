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
public class NodoUser {
    String key; 
    String value;
    String name;
    String lastname;
    String address;
    NodoUser next; 

    public String getKey() {
        return key;
    }

    public NodoUser getNext() {
        return next;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }
    
    
    
    
    public NodoUser(String k, String v,String n,String l,String a) 
    { 
        key = k; 
        value = v;
        name=n;
        lastname = l;
        address = a;
    }
}
