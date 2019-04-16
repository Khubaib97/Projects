/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progq3;

import java.util.Scanner;

/**
 *
 * @author Khubaib
 */
public class ProgQ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter rows");
        int rows = scan.nextInt();
        System.out.println("Enter columns");
        int columns = scan.nextInt();
        int[][] arr = new int[rows][columns];
        if(rows != columns)
        {
            System.out.println("false");
            System.exit(0);
        }
        System.out.println("Enter array elements");
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
               arr[i][j] = scan.nextInt();
            }
            
        }
        
        //taking the first row's sum as the standard sum
        int sum = 0;
        for(int x : arr[0])
        {
            sum += x;
        }
        
        //checking all rows against the standard sum
        for(int i = 1; i < arr.length; i++)
        {
            int chksum = 0;
            for(int j = 0; j < arr[i].length; j++)
            {
                chksum += arr[i][j];
            }
            if(sum != chksum)
            {
                System.out.println("false");
                System.exit(0);
            }
        }
        
        //checking all columns against the standard sum
        for(int j = 0; j < arr.length; j++)
        {
            int chksum = 0;
            for(int i = 0; i < arr.length; i++)
            {
                chksum += arr[i][j];
            }
            if(sum != chksum)
            {
                System.out.println("false");
                System.exit(0);
            }
        }
        
        //checking the main diagonal's sum against the standard sum
        int chksum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            chksum += arr[i][i];
        }
        if(sum != chksum)
        {
            System.out.println("false");
            System.exit(0);
        }
        
        //checking the other diagonal's sum against the standard sum
        chksum = 0;
        for(int i = 0, j = arr.length - 1; i < arr.length; i++, j--)
        {
            chksum += arr[i][j];
        }
        if(sum != chksum)
        {
            System.out.println("false");
            System.exit(0);
        }
        System.out.println("true");
    }
    
}
