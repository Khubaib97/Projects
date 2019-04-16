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
public class Tree<T extends Comparable<T>> {
    T[] arr;
    public Tree(){
        arr = (T[])new Comparable[10];
    }
    public void buildHeap(T[] ins){
        arr = (T[])new Comparable[ins.length];
        int rc = 0;
        for(int i = 0; i<ins.length; i++){
            if(rc==0){
                arr[rc] = ins[i];
                rc++;
            }
            else{
                int trc = rc;
                if(arr[(trc-1)/2].compareTo(ins[i])>0){
                    while(trc!=0){
                        if(arr[(trc-1)/2].compareTo(ins[i])>0){
                            T temp = arr[(trc-1)/2];
                            arr[(trc-1)/2] = ins[i];
                            arr[trc] = temp;
                        }
                        trc = (trc-1)/2;
                    }
                    rc++;
                }
                else{
                    arr[rc] = ins[i];
                    rc++;
                }
            }
        }
    }
    public void HeapSort(){
        T[] temp = (T[])new Comparable[arr.length];
        for(int i = temp.length-1; i>=0; i--){
            if(arr[0].compareTo(arr[i])<0){
                T t = arr[0];
                arr[0] = arr[i];
                arr[i] = t;
                temp[i] = arr[i];
                T[] abc = (T[])new Comparable[arr.length-1];
                for(int j = 0; j <abc.length; j++){
                    abc[j] = arr[j]; 
                }
                buildHeap(abc);
            }
            else{
                temp[i] = arr[i];
                T[] abc = (T[])new Comparable[arr.length-1];
                for(int j = 0; j <abc.length; j++){
                    abc[j] = arr[j]; 
                }
                buildHeap(abc);
            }
        }
        System.out.println("Sorted array:");
        for(int i = 0; i<arr.length; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println("");
    }
    public String toString(){
        String str = "";
        for(int i = 0; i<arr.length; i++){
            str = str + arr[i] +" ";
        }
        return str;
    }
}
