/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progq2;

import java.util.Scanner;

/**
 *
 * @author Khubaib
 */
public class ProgQ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size");
        int size = scan.nextInt();
        int[][] arr = new int[size][size];
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                arr[i][j] = (int)  (2 * Math.random());
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        for(int row = 0; row < size; row++)
        {
            for(int column = 1; column < size; column++)
            {
                if(arr[row][column] != arr[row][column - 1])
                {
                    break;
                }
                else if(column == size - 1)
                {
                    flag = false;
                    System.out.println("All " + arr[row][column] + "'s in row " + row);
                }
            }
        }
        if(flag)
            System.out.println("No same numbers in a row.");
        flag = true;
        for(int column = 0; column < size; column++)
        {
            for(int row = 1; row < size; row++)
            {
                if(arr[row][column] != arr[row - 1][column])
                {
                    break;
                }
                else if(row == size - 1)
                {
                    flag = false;
                    System.out.println("All " + arr[row][column] + "'s in column " + column);
                }
            }
        }
        if(flag)
            System.out.println("No same numbers in a column.");
        
        flag = true;
        for(int i = 1, j = 1; i < size; i++,j++)
        {
            if(arr[i][j] != arr[i - 1][j - 1])
            {
                break;
            }
            else if(i == size - 1)
            {
                flag = false;
                System.out.println("All " + arr[i][j] + "'s" + " in main diagonal.");
            }
        }
        if(flag)
            System.out.println("No same numbers in main diagonal.");
        
        flag = true;
        for(int i = 1, j = size - 2; i < size; i++, j--)
        {
            if(arr[i][j] != arr[i - 1][j + 1])
                break;
            else if(i == size - 1)
            {
                flag = false;
                System.out.println("All " + arr[i][j] + "'s " + "in sub-diagonal.");
            }
        }
        if(flag)
            System.out.println("No same numbers in sub-diagonal.");
    }
    
}
