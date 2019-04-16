/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inselsort;

/**
 *
 * @author Khubaib
 */
public class Sorting<T extends Comparable<T>> {
    public void selection_sort(T[] arr){
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i].compareTo(arr[j])>0){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        print(arr);
    }
    public void insertion_sort(T[] arr){
        for(int i = 1; i<arr.length; i++){
            for(int j = i-1; j>-1; j--){
                if(arr[i].compareTo(arr[j])<0){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        print(arr);
    }
    public void print(T[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}
