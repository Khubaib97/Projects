/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abmmethod;

/**
 *
 * @author Khubaib
 */
public class ABMmethod {
    static double arr[];
    static double a[];
    final static double actual = 1.66939048;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("height = 0.5");
        ABM(0, 3, 2, 0.5, 1);
        System.out.println("height = 0.25");
        ABM(0, 3, 4, 0.25, 1);
        System.out.println("height = 0.125");
        ABM(0, 3, 8, 0.125, 1);
        System.out.println("height = 1/64");
        ABM(0, 3, 64, 0.015625, 1);
    }
    public static void ABM(int L, int F, int height, double h, double y0){
        RKO(L, F, height, h, y0);
        double p;
        for(int i = 3; i<arr.length-1; i++){
            p = arr[i] + (h/24)*((-9*f(a[i-3],arr[i-3]))+(37*f(a[i-2],arr[i-2]))-(59*f(a[i-1],arr[i-1]))+(55*f(a[i],arr[i])));
            arr[i+1] = arr[i] + (h/24)*(f(a[i-2],arr[i-2])-(5*f(a[i-1],arr[i-1]))+(19*f(a[i],arr[i]))+(9*f(a[i+1],p)));
        }
        System.out.println("t\t\ty");
        for(int i = 0; i<arr.length; i++){
            System.out.println(a[i]+"\t\t"+arr[i]);
        }
        System.out.println("error: "+Math.abs(actual-arr[arr.length-1]));
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
        /*System.out.println("For height: "+h);
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }*/
    }
}
