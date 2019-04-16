/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author Khubaib
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][] arr1 = new int[3][4];
        int [][] arr2 = new int[3][4];
        int [][] arr3 = new int[3][4];
        for(int i = 0;i<arr1.length;i++){
            for(int j = 0;j<arr1[i].length;j++){
                arr1[i][j] = (int)(Math.random()*100);
                arr2[i][j] = (int)(Math.random()*100);
                System.out.print(arr1[i][j]+"/"+arr2[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("ADDITION:");
        for(int i = 0;i<arr1.length;i++){
            for(int j = 0;j<arr1[i].length;j++){
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        for(int i = 0;i<arr3.length;i++){
            for(int j = 0;j<arr3[i].length;j++){
                System.out.print(arr3[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
}
