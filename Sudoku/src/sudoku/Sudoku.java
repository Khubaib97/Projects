/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Khubaib
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] board = new int[9][9];
        Scanner inp = new Scanner(System.in);
        Generate(board);
        System.out.println("      GAME GENERATED");
        matprint(board);
        System.out.println("Fill in the 0s with your answers.");
        int z, x;
        while(true){
            System.out.println("**To terminate and check your board put the value of either row or column or both equal to 10**");
            System.out.print("Enter the row you would like to edit(1-9): ");
            z = inp.nextInt() - 1;
            System.out.print("Enter the column you would like to edit(1-9): ");
            x = inp.nextInt() - 1;
            if(z==9 || x==9){
                break;
            }
            if(board[z][x]!=0){
                System.out.println("You cannot edit that cell.");
                continue;
            }
            System.out.print("Input value for cell"+" ("+(z+1)+","+(x+1)+"): ");
            board[z][x] = inp.nextInt();
            System.out.println("Updated board: ");
            matprint(board);
        }
        boolean flag = false;
        flag = valchk(board);
        if(flag==true)
            JOptionPane.showMessageDialog(null, "Correct!");
        else
            JOptionPane.showMessageDialog(null, "Wrong!");
    }
    public static void Generate(int[][] arr){
        Random ran = new Random();
        int[][] board1 = {{4,0,0,6,0,7,0,1,5},
                          {0,9,0,5,0,0,4,7,2},
                          {0,8,7,0,2,1,6,3,9},
                          {0,1,9,8,7,5,0,6,0},
                          {2,5,0,1,4,9,0,8,7},
                          {0,4,0,3,6,2,5,9,0},
                          {9,6,4,2,1,0,7,5,0},
                          {1,3,5,0,0,4,0,2,0},
                          {8,7,0,9,0,6,0,0,3}};
        int[][] board2 = {{3,4,6,1,2,0,8,7,5},
                          {1,8,9,7,5,3,2,4,6},
                          {5,0,2,6,8,4,0,1,3},
                          {7,9,5,0,3,2,4,6,1},
                          {6,3,0,9,4,1,5,2,0},
                          {2,1,4,5,7,6,3,9,8},
                          {9,2,7,3,1,0,6,5,4},
                          {4,5,3,2,6,7,1,8,9},
                          {0,6,1,4,9,5,0,3,2}};
        int[][] board3 = {{5,3,2,9,8,0,7,4,0},
                          {4,0,0,2,1,0,3,6,9},
                          {6,9,1,4,3,7,5,0,0},
                          {0,2,5,0,7,0,8,9,0},
                          {7,6,0,0,9,0,1,2,5},
                          {8,1,0,0,6,2,0,0,7},
                          {1,5,0,8,2,3,9,7,4},
                          {0,7,8,6,4,0,0,0,3},
                          {0,4,0,0,5,0,6,1,8}};
        int val = ran.nextInt(3) + 1;
        switch(val){
            case 1:
                for(int i = 0;i<arr.length;i++){
                    for(int j = 0;j<arr[i].length;j++){
                        arr[i][j] = board1[i][j];
                    }
                }
                break;
            case 2:
                for(int i = 0;i<arr.length;i++){
                    for(int j = 0;j<arr[i].length;j++){
                        arr[i][j] = board2[i][j];
                    }
                }
                break;
            case 3:
                for(int i = 0;i<arr.length;i++){
                    for(int j = 0;j<arr[i].length;j++){
                        arr[i][j] = board3[i][j];
                    }
                }
                break;
        }
    }
    public static void matprint(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println("");
        }
    }
    public static boolean valchk(int[][] arr){
        int rsum = 0, csum = 0;
        int[] rsumc = new int[9];
        int[] csumc = new int[9];
        int[] sqsumc = new int [9];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                rsum += arr[i][j];
                csum += arr[j][i];
                }
            rsumc[i] = rsum;
            csumc[i] = csum;
            rsum = 0;
            csum = 0;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i<=2&&j<=2){
                    sqsumc[0]+=arr[i][j];
                }
                if(i<=2&&(j>=3&&j<=5)){
                    sqsumc[1]+=arr[i][j];
                }
                if(i<=2&&(j>=6&&j<=8)){
                    sqsumc[2]+=arr[i][j];
                }
                if((i>=3&&i<=5)&&(j<=2)){
                    sqsumc[3]+=arr[i][j];
                }
                if((i>=3&&i<=5)&&(j>=3&&j<=5)){
                    sqsumc[4]+=arr[i][j];
                }
                if((i>=3&&i<=5)&&(j>=6&&j<=8)){
                    sqsumc[5]+=arr[i][j];
                }
                if((i>=6)&&(j<=2)){
                    sqsumc[6]+=arr[i][j];
                }
                if((i>=6)&&(j>=3&&j<=5)){
                    sqsumc[7]+=arr[i][j];
                }
                if((i>=6)&&(j>=6)){
                    sqsumc[8]+=arr[i][j];
                }
            }
        }
        boolean flag = true;
        for(int i = 0;i<9;i++){
            if(rsumc[i]!=45 || csumc[i]!=45 || sqsumc[i]!=45)
                flag = false;
        }
        return flag;
    }    
}
