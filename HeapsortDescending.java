/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsortdescending;

import java.util.Arrays;

/**
 *
 * @author toledo
 */
public class HeapsortDescending {

    /**
     * @param args the command line arguments
     */
    int size;
    public static void main(String[] args) {
        int [] heap = {0, 2, 5, 7, 9, 6, 100, 10, 15, 1};
        heap[0] = Integer.MIN_VALUE; //infinite variable
        HeapsortDescending a = new HeapsortDescending();
        for(int i=1; i<heap.length;i++){
            a.minHeap(heap[i],heap); //create the minHeap of the array
        }
        for(int i=heap.length-1;i>=1;i--){
            heap[i] = a.HeapSort(heap); //sort the array in mode descending
        }
        System.out.println("heapsort:  " + Arrays.toString(heap)); // print the sorted array
    }
    
    //this function makes the minHeap of the array
    public void minHeap(int number,int heap[]){
        size++;
        int son = size;
        int root = son/2;
        while(heap[root] > number){
            heap[son]=heap[root];
            son = root;
            root = son/2;
        }
        heap[son]=number;
    }
    
    //this function makes the heapSort of the array
    public int HeapSort(int heap[]){
        int returnValue = heap[1];
        heap[1] = heap[size];
        size--;
        int root = 1;
        int leftSon = 2*root;
        int rightSon = leftSon + 1;
        int aux;
        while(leftSon <= size){
            if(heap[leftSon] > heap[rightSon]){
                leftSon = rightSon;
            }
            if(heap[leftSon] < heap[root]){
                aux = heap[root];
                heap[root] = heap[leftSon];
                heap[leftSon] = aux; 
            }else{
                break;
            }
            root = leftSon;
            leftSon = 2*root;
            rightSon = leftSon + 1;
        }
        return returnValue;
    }
}
