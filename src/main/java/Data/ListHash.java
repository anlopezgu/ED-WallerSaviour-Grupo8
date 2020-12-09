package Data;

public class ListHash 
{ 
    NodoUser head;
  
    String deleteNode(String key) 
    { 
        NodoUser temp = head, prev = null; 
  
        if (temp != null && temp.key == key) 
        { 
            String ret = temp.value;
            head = temp.next;
            return ret; 
        } 
  
        while (temp != null && temp.key != key) 
        { 
            String ret = temp.value;
            prev = temp; 
            temp = temp.next; 
        }     
        if (temp == null) return null; 
        prev.next = temp.next; 
        return null;
    } 
  
    public void push(String new_key, String new_value,String new_name,String new_lastname,String new_address) 
    { 
        NodoUser new_node = new NodoUser(new_key, new_value,new_name,new_lastname,new_address); 
        new_node.next = head; 
        head = new_node; 
    } 
    
    public void printList() 
    { 
        NodoUser tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.value+" "); 
            tnode = tnode.next; 
        } 
    } 
} 