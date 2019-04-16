/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetanus;

/**
 *
 * @author Khubaib
 */
public class Tetanus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] a = {{1, 0, -3},{-3, 1, 6},{2, 2, -1}};
        double[][] b = {{5/11},{-6/11},{9/11}};
        PrintMatrix(Matrix_Multiplication(a, b));
    }
    public static double[][] Matrix_Multiplication(double[][] a, double[][] b){
        double[][] prod = new double[a.length][b[0].length];
        double sum = 0;
        if(a[0].length!=b.length){
            System.out.println("Multiplication not possible");
        }
        else{
            for(int i = 0; i<prod.length; i++){
                for(int j = 0; j<a.length; j++){
                    for(int k = 0; k<b[j].length; k++){
                        sum = sum + (a[i][k]*b[k][j]);
                    }
                    prod[i][j] = sum;
                    sum = 0;
                }
            }
            return prod;
        }
        return null;
    }
    public static void PrintMatrix(double[][] a){
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
