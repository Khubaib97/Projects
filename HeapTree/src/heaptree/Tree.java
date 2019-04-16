/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaptree;

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
    public String toString(){
        String str = "";
        for(int i = 0; i<arr.length; i++){
            str = str + arr[i] +" ";
        }
        return str;
    }
}
