/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtest;

import java.util.Scanner;

/**
 *
 * @author Khubaib
 */
public class BinarySearchTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int first, last, middle;
    Scanner in = new Scanner(System.in);
    System.out.println("How many elements?");
    int n = in.nextInt(); 
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++){
        arr[i] = (int)(Math.random()*100);
    }
    for(int i = 0; i < arr.length; i++){
        int small = i;
      for (int j = i+1; j < arr.length; j++){
            if (arr[j] < arr[small]){ 
                small = j;
            }
      }
      int temp = arr[i];
      arr[i] = arr[small];
      arr[small] = temp;
    }
    for(int i = 0; i <arr.length; i++){
        System.out.println(arr[i]);
    }
    System.out.println("Enter value to find");
    int value = in.nextInt();
 
    first  = 0;
    last   = arr.length - 1;
    middle = (first + last)/2;
    long start = System.currentTimeMillis();
    while( first <= last )
    {
      if ( arr[middle] < value )
        first = middle + 1;    
      else if ( arr[middle] == value ) 
      {
        System.out.println(value + " found at location " + (middle + 1) + ".");
        break;
      }
      else
         last = middle - 1;
 
      middle = (first + last)/2;
   }
   if ( first > last )
      System.out.println(value + " is not present in the list.\n");
    long end = System.currentTimeMillis();
        System.out.println("Binary search took "+(end - start)+" milliseconds.");
    }
    
}
