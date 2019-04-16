/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication62;
class MyAL<T extends Comparable<T>>{
    T[] def_arr;
    int def_size = 10;
    int curr_pointer;
    public MyAL(){
        def_arr = (T[])new Comparable[10];
    }
    public MyAL(int size){
        def_size = size;
        def_arr = (T[])new Comparable[size];
    }
    public void display(){
        for(int i=0;i < curr_pointer;i++){
            System.out.print(def_arr[i]+" ");
        }
    }
    public void InsertValue(T val){
        if((def_arr.length-1)==curr_pointer){
            T[] arr = (T[])new Comparable[def_size+(def_size/2)];
            for(int i=0; i<def_size; i++){
                arr[i] = def_arr[i];
            }
            def_size = arr.length;
            def_arr = arr;
        }
        def_arr[curr_pointer++] = val;
    }
    public int GetSize(){
        return (curr_pointer+1);
    }
    public int find(T val){
        int val_pointer=-69;
        for(int i=0; i<curr_pointer;i++){
            if(val.compareTo(def_arr[i])==0){
                val_pointer = i;
                break;
            }
        }
        System.out.println("Value was found at "+val_pointer+" index.");
        return val_pointer;
    }
    public void remove(T val){
        int point = find(val);
        //def_arr[point] = null;
        for(int i=point; i<curr_pointer-1; i++){
            T temp = def_arr[i];
            def_arr[i] = def_arr[i+1];
            def_arr[i+1] = temp;
        }
        T[] arr = (T[])new Comparable[curr_pointer-1];
        for(int i = 0; i<arr.length; i++){
            arr[i] = def_arr[i];
        }
        def_arr = arr;
        curr_pointer--;
    }
}
/**
 *
 * @author Khubaib
 */
public class JavaApplication62 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MyAL<String> hue = new MyAL<String>(10);
       hue.display();
        System.out.println("");
       hue.InsertValue("42525");
       hue.InsertValue("aavlkasdja");
       hue.InsertValue("onetwothree");
       hue.display();
       hue.remove("42525");
       hue.display();
        System.out.println("");
    }
    
}
