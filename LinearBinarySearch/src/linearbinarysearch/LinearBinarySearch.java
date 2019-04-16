/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearbinarysearch;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class LinearBinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int meow;
        int[] arr = new int[25];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
        while(true){
            System.out.println("Binary(0) Linear(1)");
            meow = input.nextInt();
            input.nextLine();
            switch(meow){
            case 1:
                LinearSearch(arr);
                break;
            case 0:
                BinarySearch(arr);
                break;
            case 5:
                System.exit(0);
            }
        }
    }
    public static boolean LinearSearch(int[] arr){
            long start = System.currentTimeMillis();
            Scanner input = new Scanner(System.in);
            System.out.println("Input value to find:");
            int choice = input.nextInt();
            for(int i=0; i<arr.length; i++){
                if(arr[i]==choice){
                    long end = System.currentTimeMillis();
                    System.out.println("Value "+arr[i]+" was found at index "+i+".");
                    System.out.println("It took "+(end-start)+" miliseconds.");
                    return true;
                }
            }
            System.out.println("Not found.");
            return false;
    }
    public static boolean BinarySearch(int[] arr){
            long start = System.currentTimeMillis();
            Arrays.sort(arr);
            Scanner input = new Scanner(System.in);
            System.out.println("Input value to find:");
            int choice = input.nextInt();
            int first = 0;
            int last = arr.length;
            int middle = (first + last)/2;
            while (first <= last){
                if(arr[middle] < choice){
                    first = middle +1;
                }
                else if(arr[middle] == choice){
                    long end = System.currentTimeMillis();
                    System.out.println("Value "+choice+" was found at index "+middle+".");
                    System.out.println("It took "+(end-start)+" miliseconds.");
                    return true;
                }
                else{
                    last = middle - 1;
                }
                middle = (first+last)/2;
                if(first > last){
                    long end = System.currentTimeMillis();
                    System.out.println("Value was not found");
                    System.out.println("It took "+(end-start)+" miliseconds.");
                    return false;
                }
            }
            return false;
    }
    
}
