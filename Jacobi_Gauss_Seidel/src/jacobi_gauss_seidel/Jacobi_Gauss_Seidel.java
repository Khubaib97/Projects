/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobi_gauss_seidel;

/**
 *
 * @author Khubaib
 */
public class Jacobi_Gauss_Seidel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] a = {
                       {4, -1, 1, 7},
                       {4, -8, 1, -21},
                       {-2, 1, 5, 15}
                       };
        Jacobi_Iteration(a);
        Gauss_Seidel(a);
    }
    public static void PrintMatrix(double[][] a){
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    public static void Jacobi_Iteration(double[][] a){
        double x = (a[0][3]-a[0][1]-a[0][2])/a[0][0];
        double y = (a[1][3]-a[1][0]-a[1][2])/a[1][1];
        double z = (a[2][3]-a[2][1]-a[2][0])/a[2][2];
        double x_p = 0;
        double y_p = 0;
        double z_p = 0;
        int count = 1;
        while(Math.abs(x-x_p)>0.000001 || Math.abs(y-y_p)>0.000001 || Math.abs(z-z_p)>0.000001){
            x_p = x; y_p = y; z_p = z;
            System.out.print("x:"+x+"\ty:"+y+"\tz:"+z);
            System.out.println("");
            x = (a[0][3]-(a[0][1]*y_p)-(a[0][2]*z_p))/a[0][0];
            y = (a[1][3]-(a[1][0]*x_p)-(a[1][2]*z_p))/a[1][1];
            z = (a[2][3]-(a[2][1]*y_p)-(a[2][0]*x_p))/a[2][2];
            count++;
        }
        System.out.println("Solution: ");
        System.out.println("x:"+x+"\ty:"+y+"\tz:"+z);
        System.out.println("End of Jacobi Iteration. Steps taken: "+count);
    }
    public static void Gauss_Seidel(double[][] a){
        double x = (a[0][3]-a[0][1]-a[0][2])/a[0][0];
        double y = (a[1][3]-a[1][0]-a[1][2])/a[1][1];
        double z = (a[2][3]-a[2][1]-a[2][0])/a[2][2];
        double x_p = 0;
        double y_p = 0;
        double z_p = 0;
        int count = 1;
        while(Math.abs(x-x_p)>0.000001 || Math.abs(y-y_p)>0.000001 || Math.abs(z-z_p)>0.000001){
            x_p = x; y_p = y; z_p = z;
            System.out.print("x:"+x+"\ty:"+y+"\tz:"+z);
            System.out.println("");
            x = (a[0][3]-(a[0][1]*y)-(a[0][2]*z))/a[0][0];
            y = (a[1][3]-(a[1][0]*x)-(a[1][2]*z))/a[1][1];
            z = (a[2][3]-(a[2][0]*x)-(a[2][1]*y))/a[2][2];
            count++;
        }
        System.out.println("Solution: ");
        System.out.println("x:"+x+"\ty:"+y+"\tz:"+z);
        System.out.println("End of Gauss-Seidel Iteration. Steps taken: "+count);
    }
}
