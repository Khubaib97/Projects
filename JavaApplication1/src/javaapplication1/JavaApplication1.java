/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Khubaib
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {22,4,18,7,30,29,23,14,29,9}; int tmp;
        for(int count = 1;count<arr.length;count++){
            tmp = arr[count];
            int counter = count - 1;
            while(counter>=0){
                if(tmp>arr[counter]){
                    arr[counter+1] = arr[counter];
                    arr[counter] = tmp;
                }
                counter--;
            }
        }
        for(int count=0;count<arr.length;count++){
            System.out.print(arr[count]+" ");
        }
    }
    
}
