package Data;

/*
    add(String key, String value)
    get(String key)
    remove(String key)
    print()
*/

public class MapH
{ 
    private ListHash[] bucketArray; 
    private int numBuckets; 
    private int size; 
    private int full;
  
    public MapH() 
    { 
        numBuckets = 5; 
        bucketArray = new ListHash[numBuckets]; 
        size = 0; 
 
        for (int i = 0; i < numBuckets; i++) 
            bucketArray[i] = new ListHash(); 
    } 
  
    public int size() { return size; } 
    public boolean isEmpty() { return size() == 0; } 
  
    private int getBucketIndex(String key) 
    { 
        int index = key.hashCode(); 
        index = index % numBuckets;
        return Math.abs(index); 
    } 
  
    public void remove(String key) 
    { 
        int bucketIndex = getBucketIndex(key); 
        ListHash l = bucketArray[bucketIndex];
        String s = l.deleteNode(key);
        if (l.head == null && s!=null){
            full--;
        }
        size--; 
    } 
    public NodoUser get(String key) 
    { 
        int bucketIndex = getBucketIndex(key); 
        ListHash l = bucketArray[bucketIndex]; 
        NodoUser head = l.head;
  
        while (head != null) 
        { 
            if (head.key.equals(key)) 
                return head; 
            head = head.next; 
        } 
        
        return null; 
    } 
  
    public void add(String key, String value, String name, String lastname, String address) 
    { 
        int bucketIndex = getBucketIndex(key); 
        ListHash l = bucketArray[bucketIndex]; 
        if (l.head == null){
            full++;
        }
        NodoUser head = l.head;
   
        while (head != null) 
        { 
            if (head.key.equals(key)) 
            { 
                head.value = value; 
                return; 
            } 
            head = head.next; 
        } 
  
        size++; 
        l = bucketArray[bucketIndex];
        l.push(key, value,name,lastname,address); 
  
        if ((1.0*full)/numBuckets >= 0.8) 
        {            
            int oldSize = numBuckets;
            double f = 1.6 * numBuckets;
            numBuckets = (int) f; 
            ListHash[] temp = bucketArray; 
            bucketArray = new ListHash[numBuckets]; 
            size = 0; 
            full = 0;
            for (int i = 0; i < numBuckets; i++) 
                bucketArray[i] = new ListHash(); 
            
            for (int i = 0; i < oldSize; i++){
                l = temp[i]; 
                NodoUser headNode = l.head;
                
                while (headNode != null) 
                { 
                    add(headNode.key, headNode.value,headNode.name,headNode.lastname,headNode.address); 
                    headNode = headNode.next; 
                }
            }
        } 
    } 
    
    public void print(){
        System.out.print("\nPRINT\nLlenos: ");
        System.out.println(full);
        for (int i = 0; i < numBuckets; i++){
            ListHash l = bucketArray[i]; 
            NodoUser headNode = l.head;
                
            System.out.print(i);
            System.out.print(" : ");
            l.printList();
            System.out.println();
        }
    }
} 
