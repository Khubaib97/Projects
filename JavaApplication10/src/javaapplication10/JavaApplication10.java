/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

/**
 *
 * @author Khubaib
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] m1 = {{1,2,3},{3,2,1},{3,1,2}};
        int[][] m2 = {{2,4,1},{1,4,2},{4,1,2}};
        int[][] m3 = new int[m1.length][m2[0].length];
        for(int i = 0;i<m3.length;i++){
            for(int j = 0;j<m3[i].length;j++){
                for(int k = 0;k<m2.length;k++){
                    m3[i][j] += (m1[i][k]*m2[k][j]);
                }
            }
        }
        for(int i = 0;i<m3.length;i++){
            for(int j = 0;j<m3[i].length;j++){
                System.out.print(m3[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
}
