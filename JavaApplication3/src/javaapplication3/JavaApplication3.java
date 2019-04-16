/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[15]; Scanner inp = new Scanner(System.in);
        System.out.print("Enter number of values(max 15): ");
        int z = inp.nextInt();
        for(int count = 0;count<z;count++){
            System.out.print("Enter "+(count+1)+" value: ");
            arr[count] = inp.nextInt();
        }
        System.out.print("Array print: ");
        for(int count = 0;count<z;count++){
            System.out.print(arr[count]+" ");
        }
        System.out.println("");
        System.out.print("Enter value to insert: ");
        int y = inp.nextInt(); int index=-5;
        for(int count = z-1;count>=0;count--){
            if(y<arr[count]){
                index = count;
            }
            else if(y>arr[z-1])
                index = z;
        }
        System.out.println("Value will be inserted into "+index+" index");
        for(int count = z-1;count>=0;count--){
            int tmp = arr[count];
            if(y<arr[count]){
                arr[count] = y;
                arr[count+1] = tmp;
            }
            else if(y>arr[z-1])
                arr[z] = y;
        }
        System.out.print("Final: ");
        for(int count = 0;count<z+1;count++){
            System.out.print(arr[count]+" ");
        }
        System.out.println("");
    }
    
}
