/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rk4;

/**
 *
 * @author Khubaib
 */
public class RK4 {
    static double arr[];
    static double a[];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RKO(0, 3, 1, 1, 1);
        RKO(0, 3, 2, 0.5, 1);
        RKO(0, 3, 4, 0.25, 1);
        RKO(0, 3, 8, 0.125, 1);
    }
    public static double f(double t, double y){
        return ((t-y)/2);
    }
    public static void RKO(int L, int F, int height, double h, double y0){
        arr = new double[((L+F)*height)+1];
        arr[0] = y0;
        double f1=0; double f2=0; double f3=0; double f4=0;
        a = new double[arr.length];
        double counter = 0;
        for(int i = 0; i<arr.length; i++){
            a[i] = counter;
            counter += (h);
        }
        for(int i = 0; i<arr.length-1; i++){
            f1 = f(a[i], arr[i]);
            f2 = f((a[i]+(h/2)),(arr[i]+((h/2)*f1)));
            f3 = f((a[i]+(h/2)),(arr[i]+((h/2)*f2)));
            f4 = f((a[i]+(h)),(arr[i]+((h)*f3)));
            arr[i+1] = (arr[i]+((f1+(2*f2)+(2*f3)+f4)*(h/6)));
        }
        System.out.println("For height: "+h);
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
