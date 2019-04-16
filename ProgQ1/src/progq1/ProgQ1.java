/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progq1;

import java.util.Scanner;

/**
 *
 * @author Khubaib
 */
public class ProgQ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //create a 6 x 6 array
        int[][] arr = new int[6][6];
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                arr[i][j] = scan.nextInt();
            }
        }
        
        //flip a random cell's value
        int x = (int) (6 * Math.random());
        int y = (int) (6 * Math.random());
        if(arr[x][y] == 0)
            arr[x][y] = 1;
        else
            arr[x][y] = 0;
        
        //find the row number where the cell value has been flipped
        int row = 0;
        for(; row < 6; row++)
        {
            int count = 0;
            for(int j = 0; j < 6; j++)
            {
                if(arr[row][j] == 1)
                    count++;
            }
            if(count % 2 == 1)
                break;
        }
        
        //find the column number where the cell value has been flipped
        int column = 0;
        for(; column < 6; column++)
        {
            int count = 0;
            for(int i = 0; i < 6; i++)
            {
                if(arr[i][column] == 1)
                    count++;
            }
            if(count % 2 == 1)
                break;
        }
        
        //print the new matrix
        System.out.println("New matrix:");
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
        
        //print the changed cell's coordinates
        System.out.println("Cell change at: (" + row + ", " + column + ")");
    }
    
}
