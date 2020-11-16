/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Data.*;
public class MinHeap{
    // int[][] a = new int[2][4];
    private String[][] heap;
    private int size;
    private int maxsize;



    public MinHeap(int max){
        this.size = 0;
        this.maxsize = max;
        heap = new String[this.maxsize+1][2];
        String[] maxArray = {"00/00/0000", "0"};
        heap[0] = maxArray;
    }



    // Indices
    private int parent(int i){
        return (i/2);
    }
    private int leftChild(int i){
        return (2*i);
    }
    private int rightChild(int i){
        return ((2*i)+1);
    }



    private boolean beforeThan(String i, String j){
        String[] fecha1 = i.split("/");
        String[] fecha2 = j.split("/");
        int[] date1 = new int[3];
        int[] date2 = new int[3];
        for(int h=0; h<3; h++) {
           date1[h] = Integer.parseInt(fecha1[h]);
           date2[h] = Integer.parseInt(fecha2[h]);
        }
        int c1 = date1[0] + (date1[1]*31) + (date1[2]*365);
        int c2 = date2[0] + (date2[1]*31) + (date2[2]*365);
        return (c1<c2);
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    private void swap(int i, int j){
        String[] aux;
        aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }
    private boolean isLeaf(int i){
        return i >= (size/2)  && (i <= size);
    }
    private void heapify(int pos) 
    { 
        if (!isLeaf(pos)) { 
            if (beforeThan( heap[leftChild(pos)][0], heap[pos][0] ) || beforeThan( heap[rightChild(pos)][0], heap[pos][0] )){ 
                if (beforeThan( heap[leftChild(pos)][0], heap[rightChild(pos)][0] )) {
                    swap(pos, leftChild(pos)); 
                    heapify(leftChild(pos)); 
                } 
                else { 
                    swap(pos, rightChild(pos)); 
                    heapify(rightChild(pos)); 
                } 
            } 
        } 
    } 



    public void insert(NodoDinero Nodo){
        String fecha = Nodo.getFecha();
        int element = Integer.parseInt(Nodo.getAmount());
        size = size+1;
        String e = Integer.toString(element);
        String[] aux = {fecha, e};
        heap[size] = aux;

        int actual = size;
        while (beforeThan( heap[actual][0], heap[ parent(actual) ][0] )){
            // heap[actual] > heap[ parent(actual) ]
            swap(actual, parent(actual));
            actual = parent(actual);
        }
    }
    public NodoDinero extractMin(){
        String[] minimo = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        NodoDinero nodoMin = new NodoDinero(minimo[1],"xd",minimo[0]);
        return nodoMin;
    }
    
    public NodoDinero peekMin(){
    String[] minimo = heap[1];
    NodoDinero nodoMin = new NodoDinero(minimo[1],"xd",minimo[0]);
    return nodoMin;}
    public void display(){
        for (int i = 1; i<=size/2; i++){
            System.out.print(" PARENT : " + heap[i][0] + " LEFT CHILD : " +  heap[2 * i][0] + " RIGHT CHILD :" + heap[2 * i + 1][0]); 
            System.out.println(); 
        }
    }
}
