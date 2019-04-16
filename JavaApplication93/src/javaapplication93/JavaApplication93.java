/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication93;

/**
 *
 * @author Khubaib
 */
public class JavaApplication93 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {4, 16, 23, 420, 69, 56, 76, 23, 34};
        Babloo(arr);
    }
    public static void Babloo(int[] arr){
        System.out.println("Before:");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
        Boolean flag = true;
        int temp = 0;
        for(int i = 0; i<arr.length && flag; i++){
            flag = false;
            for(int j = 0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
        }
        System.out.println("After: ");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}
