/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucomposition;

/**
 *
 * @author Khubaib
 */
public class LUcomposition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] a = {{1, -2, 3},{2, -5, 12},{0, 2, -10}};
        double[][] b = {{1, 3, 5},{2, 4, 7},{1, 1, 0}};
        System.out.println("Original matrix:");
        PrintMatrix(b);
        LUdec(b);
        System.out.println("-----------");
        System.out.println("Original matrix:");
        PrintMatrix(a);
        LUdec(a);
    }
    public static void PrintMatrix(double[][] a){
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println("");
        }
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
    public static void LUdec(double[][] a){
        double[][] L = new double[a.length][a[0].length];
        double[][] U = new double[a.length][a[0].length];
        System.arraycopy(a, 0, U, 0, a.length);
        for(int i = 0; i<L.length; i++){
            L[i][i] = 1;
        }
        double[] row_multipliers;
        for(int z = 0; z<a[0].length; z++){
        int n = z;
        row_multipliers = new double[a.length];
        while(n!=a.length){    
            for(int i = n+1; i<a.length; i++){
                row_multipliers[i] = a[i][n]/a[n][n];
            }
            for(int i = n+1; i<a.length; i++){
                for(int j = n; j<a[i].length; j++){
                    L[i][j] += L[n][j]*row_multipliers[i];
                    U[i][j] += U[n][j]*(-1*row_multipliers[i]);
                }
            }
            n++;
        }
        }
        System.out.println("L:");
        PrintMatrix(L);
        System.out.println("U:");
        PrintMatrix(U);
        System.out.println("LU product: ");
        PrintMatrix(Matrix_Multiplication(L, U));
    }
}
