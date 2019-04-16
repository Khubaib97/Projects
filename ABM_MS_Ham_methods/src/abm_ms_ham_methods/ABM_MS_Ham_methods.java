/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abm_ms_ham_methods;

/**
 *
 * @author Khubaib
 */
public class ABM_MS_Ham_methods {
    static double arr[]; //array of y values
    static double a[]; //array of t values, populated inside the RK4 method
    final static double actual = 1.66939048;  //actual value at t=3, used to compute error
    static double OTE;  //error for height 1/128
    static double TFS;  //error for height 1/256
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("For Adam-Bashforth Moulton Method");
        System.out.println("height = 1/128");
        ABM(0, 3, 128, 0.0078125, 1);
        System.out.println("height = 1/256");
        ABM(0, 3, 256, 0.00390625, 1);
        System.out.println("Error ratio for ABM method: "+(OTE/TFS)); //0.9868195740480014
        OTE = 1; TFS = 1; //error catcher, if my error ratio is 1 i will know something went wrong afterwards
        System.out.println("For Milne-Simpson Method");
        System.out.println("height = 1/128");
        MS(0, 3, 128, 0.0078125, 1);
        System.out.println("height = 1/256");
        MS(0, 3, 256, 0.00390625, 1);
        System.out.println("Error ratio for MS method: "+(OTE/TFS)); //0.9971312164250827
        OTE = 1; TFS = 1; //error catcher, if my error ratio is 1 i will know something went wrong afterwards
        System.out.println("For Hamming Method");
        System.out.println("height = 1/128");
        H(0, 3, 128, 0.0078125, 1);
        System.out.println("height = 1/256");
        H(0, 3, 256, 0.00390625, 1);
        System.out.println("Error ratio for H method: "+(OTE/TFS)); //1.9938391953176775
    }
    public static void ABM(int L, int F, int height, double h, double y0){
        RK4(L, F, height, h, y0);
        double p;
        for(int i = 3; i<arr.length-1; i++){
            p = arr[i] + (h/24)*((-9*f(a[i-3],arr[i-3]))+(37*f(a[i-2],arr[i-2]))-(59*f(a[i-1],arr[i-1]))+(55*f(a[i],arr[i])));
            arr[i+1] = arr[i] + (h/24)*(f(a[i-2],arr[i-2])-(5*f(a[i-1],arr[i-1]))+(19*f(a[i],arr[i]))+(9*f(a[i+1],p)));
        }
        System.out.println("t\t\ty");
        for(int i = 0; i<arr.length; i++){
            System.out.println(a[i]+"\t\t"+arr[i]);
        }
        if(height==128){
            OTE = Math.abs(actual-arr[arr.length-1]);
        }
        else if(height==256){
            TFS = Math.abs(actual-arr[arr.length-1]);
        }
        System.out.println("error(1/"+height+"): "+Math.abs(actual-arr[arr.length-1]));
    }
    public static void MS(int L, int F, int height, double h, double y0){
        RK4(L, F, height, h, y0);
        double p;
        for(int i = 3; i<arr.length-1; i++){
            p = arr[i-3] + ((4*h)/3)*((2*f(a[i-2],arr[i-2]))-f(a[i-1],arr[i-1])+(2*f(a[i],arr[i])));
            arr[i+1] = arr[i-1] + (h/3)*(f(a[i-1],arr[i-1])+(4*f(a[i],arr[i]))+f(a[i+1],p));
        }
        System.out.println("t\t\ty");
        for(int i = 0; i<arr.length; i++){
            System.out.println(a[i]+"\t\t"+arr[i]);
        }
        if(height==128){
            OTE = Math.abs(actual-arr[arr.length-1]);
        }
        else if(height==256){
            TFS = Math.abs(actual-arr[arr.length-1]);
        }
        System.out.println("error(1/"+height+"): "+Math.abs(actual-arr[arr.length-1]));
    }
    public static void H(int L, int F, int height, double h, double y0){
        RK4(L, F, height, h, y0);
        double p;
        for(int i = 3; i<arr.length-1; i++){
            p = arr[i-3] + ((4*h)/3)*((2*f(a[i-2],arr[i-2]))-f(a[i-1],arr[i-1])+(2*f(a[i],arr[i])));
            arr[i+1] = (((-1*arr[i-2])+(9*arr[i]))/8) + ((3*h)/8)*((-1*f(a[i-1],arr[i-2]))+(2*f(a[i],arr[i]))+f(a[i+1],p));
        }
        System.out.println("t\t\ty");
        for(int i = 0; i<arr.length; i++){
            System.out.println(a[i]+"\t\t"+arr[i]);
        }
        if(height==128){
            OTE = Math.abs(actual-arr[arr.length-1]);
        }
        else if(height==256){
            TFS = Math.abs(actual-arr[arr.length-1]);
        }
        System.out.println("error(1/"+height+"): "+Math.abs(actual-arr[arr.length-1]));
    }
    public static double f(double t, double y){
        return ((t-y)/2);
    }
    public static void RK4(int L, int F, int height, double h, double y0){
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
    }
    
}
