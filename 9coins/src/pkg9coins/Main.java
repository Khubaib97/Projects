/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9coins;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class Main {
public static void DecToBinIntoArr(int a,int[][] aray){
    for(int i = 0;i<aray.length;i++){
        for(int j = 0;j<aray[i].length;j++){
            aray[i][j] = a%2;
            a = a/2;
        }
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number between 0 and 511: ");
        int a = inp.nextInt();
        int[][] array = new int[3][3];
        DecToBinIntoArr(a, array);
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i].length;j++){
                if(array[i][j]==1){
                    array[i][j] = 'T';
                }
                else{
                    array[i][j] = 'H';
                }
            }
        }
        char[][] arra = new char[3][3];
        for(int i = arra.length-1;i>=0;i--){
            for(int j = arra[i].length-1;j>=0;j--){
                arra[i][j] = (char)array[i][j];
                System.out.print(arra[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
}
