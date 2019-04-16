/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rk45;

/**
 *
 * @author Khubaib
 */
public class RK45 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RKF(0,3,50,1,1);
    }
    public static void RKF(double L, double F, int iterations, double h0, double y0){
        System.out.println("i\tt\tapproximation\t\terror");
        double t = L;
        double y = y0;
        double h = h0;
        int i = 0;
        double rk4; double rk5; double error;
        double hmax = 64*h;
        double hmin = h/64;
        double tol = 0.00001;
        while(i<iterations && t<=F){
            if(h<hmin){ h = hmin; }
            if(h>hmax){ h= hmax; }
            double k1 = h*f(t,y);
            double k2 = h*f((t+(h/4)),(y+(k1/4)));
            double k3 = h*f((t+((3*h)/8)),(y+((3*k1)/32)+((9*k2)/32)));
            double k4 = h*f((t+((12*h)/13)),(y+((1932*k1)/2197)-((7200*k2)/2197)+((7296*k3)/2197)));
            double k5 = h*f((t+h),(y+((439*k1)/216)-(8*k2)+((3680*k3)/513)-((845*k4)/4104)));
            double k6 = h*f((t+(h/2)),(y-((8*k1)/27)+(2*k2)-((3544*k3)/2565)+((1859*k4)/4104)-((11*k5)/40)));
            rk4 = y + ((25*k1)/216) + ((1408*k3)/2565) + ((2197*k4)/4104) - (k5/5);
            rk5 = y + ((16*k1)/135) + ((6656*k3)/12825) + ((28561*k4)/56430) - ((9*k5)/50) + ((2*k6)/55);
            error = Math.abs(rk4-rk5);
            if(error>tol && h>hmin){
                h = h/2;
            }
            else{
                i++;
                System.out.println(i+"\t"+t+"\t"+rk5+"\t"+error);
                t = t+h;
                y = rk5;
            }
            if(error<tol){
                h = h*2;
            }
        }
    }
    public static double f(double t, double y){
        return ((t-y)/2);
    }
}
