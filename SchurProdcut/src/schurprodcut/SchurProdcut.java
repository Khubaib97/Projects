/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schurprodcut;

/**
 *
 * @author Khubaib
 */
public class SchurProdcut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] a = {{1, 3, 5},{5, 4, 3}};
        double[][] b = {{4, 7, 2},{9, 8, 3}};
        PrintMatrix(Schur_Product(a, b));
    }
    public static double[][] Schur_Product(double[][] a, double[][] b){
        double[][] sp = new double[a.length][a[0].length];
        if(a.length==b.length && a[0].length==b[0].length){
            for(int i = 0; i<sp.length; i++){
                for(int j = 0; j<sp[i].length; j++){
                    sp[i][j] = a[i][j]*b[i][j];
                }
            }
            return sp;
        }
        else{
            System.out.println("Schur product not possible. Matrices are not of same dimensions.");
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
