/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter length of matrix: ");
        int as = inp.nextInt();
        int[][] arr = new int[as][as]; boolean flag = false; boolean flag2 = true;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                arr[i][j] = (int)Math.round(Math.random());
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        for(int i = 0;i<arr.length;i++){
            flag = false;
            for(int j = 0;j<arr[i].length-1;j++){
                if(arr[i][j]==arr[i][j+1]){
                    flag = true;
                    continue;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag==true){
                System.out.println("All "+arr[i][0]+"s on row "+(i+1));
                flag2 = false;
            }
        }
        if(flag2==true){
            System.out.println("No same numbers on any row");
        }
        flag2 = true;
        for(int j = 0;j<arr[0].length;j++){
            flag = false;
            for(int i = 0;i<arr.length-1;i++){
                if(arr[i][j]==arr[i+1][j]){
                    flag = true;
                    continue;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag==true){
                System.out.println("All "+arr[0][j]+"s on column "+(j+1));
                flag2 = false;
            }
        }
        if(flag2==true){
            System.out.println("No same numbers on any column");
        }
        flag = false; flag2 = true;
        for(int i =0,j =0;i<(arr.length-1)&&j<(arr[i].length-1);i++,j++){
            if(arr[i][j]==arr[i+1][j+1]){
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        if(flag==true){
            System.out.println("All "+arr[0][0]+"s on the diagonal");
            flag2 = false;
        }
        if(flag2==true){
            System.out.println("No same numbers on the diagonal");
        }
        flag = false; flag2 = true;
        for(int i =0,j =(arr[0].length-1);i<(arr.length-1)&&j>=0;i++,j--){
            if(arr[i][j]==arr[i+1][j-1]){
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        if(flag==true){
            System.out.println("All "+arr[0][arr[0].length-1]+"s on the sub-diagonal");
            flag2 = false;
        }
        if(flag2==true){
            System.out.println("No same numbers on the sub-diagonal");
        }
    }
    
}
