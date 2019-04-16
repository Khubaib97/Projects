/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int r = inp.nextInt();
        System.out.print("Enter number of columns: ");
        int c = inp.nextInt();
        int[][] arr = new int[r][c]; int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum = 0;
            for(int j = 0;j<arr[i].length;j++){
                System.out.print("Enter "+(i+1)+"r "+(j+1)+"c value:");
                arr[i][j] = inp.nextInt();
                sum += arr[i][j];
            }
        }
        System.out.println("Array print: ");
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        int[] rsum = new int[r];
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                rsum[i] += arr[i][j];
            }
        }
        boolean flag1 = false;
        for(int i = 0;i<rsum.length;i++){
            if(rsum[i]==sum)
                flag1 = true;
            else{
                flag1 = false;
                break;
            }        
        }
        int[] csum = new int[c];
        for(int j = 0;j<arr[0].length;j++){
            for(int i = 0;i<arr.length;i++){
                csum[i] += arr[i][j];
            }
        }
        boolean flag2 = false;
        for(int i = 0;i<csum.length;i++){
            if(csum[i]==sum)
                flag2 = true;
            else{
                flag2 = false;
                break;
            }        
        }
        int diagsum = 0;
        for(int i=0,j=0;i<arr.length&&j<arr[0].length;i++,j++){
            diagsum += arr[i][j];
        }
        boolean flag3 = false;
        if(diagsum==sum){
            flag3 = true;
        }
        int subdiagsum = 0;
        for(int i=0,j=arr[0].length-1;i<arr.length&&j>=0;i++,j--){
            subdiagsum += arr[i][j];
        }
        boolean flag4 = false;
        if(subdiagsum==sum){
            flag4 = true;
        }
        if(r==c && flag1==true && flag2==true && flag3==true && flag4==true){
            System.out.println("TRUE");
        }
        else{
            System.out.println("FALSE");
        }
    }
    
}
