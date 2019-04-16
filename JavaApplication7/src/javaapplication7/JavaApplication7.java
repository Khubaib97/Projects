/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;
import java.util.Scanner;

/**
 *
 * @author Khubaib
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[][] arr = new int[6][6]; int ones = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print("Enter "+(i+1)+"r "+(j+1)+"c value:");
                arr[i][j] = inp.nextInt();
            }
        }
        System.out.println("Original Array: ");
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        for(int i = 0;i<arr.length;i++){
            ones = 0;
            for(int j = 0;j<arr[i].length;j++){
                if(arr[i][j]==1)
                    ones += 1;
            }
            if(ones%2==1){
                System.out.println("Even number of 1s not present in row "+(i+1));
                break;
            }
        }
        for(int j = 0;j<arr[0].length;j++){
            ones = 0;
            for(int i = 0;i<arr.length;i++){
                if(arr[i][j]==1)
                    ones += 1;
            }
            if(ones%2==1){
                System.out.println("Even number of 1s not present in column "+(j+1));
                break;
            }
        }   
        int ranrow = 0; int rancolumn = 0;
        ranrow = (int)(Math.random() * 6);
        rancolumn = (int)(Math.random() * 6);
        if(arr[ranrow][rancolumn]==1)
            arr[ranrow][rancolumn] = 0;
        else if(arr[ranrow][rancolumn]==0)
            arr[ranrow][rancolumn] = 1;
        System.out.println("Array after random flip: ");
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("The cell that was flipped was: ("+(ranrow+1)+","+(rancolumn+1)+")");
    }
    
}
