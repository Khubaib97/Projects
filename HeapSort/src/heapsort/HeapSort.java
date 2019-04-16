/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

/**
 *
 * @author Khubaib
 */
public class HeapSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] arr = new Integer[6];
        arr[0] = 70;
        arr[1] = 90;
        arr[2] = 80;
        arr[3] = 40;
        arr[4] = 60;
        arr[5] = 50;
        Tree t = new Tree();
        t.buildHeap(arr);
        System.out.println(t.toString());
        t.HeapSort();
    }
    
}
