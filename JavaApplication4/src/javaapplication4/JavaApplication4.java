/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author Khubaib
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {3,9,4,8,1,6,5};
        for(int i = arr.length-1;i>=0;i--){
            for(int j = 0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int count = 0;count<arr.length;count++){
            System.out.print(arr[count]+" ");
        }
    }
    
}
