/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iptoint;
import java.util.Scanner;

/**
 *
 * @author Khubaib
 */
public class IPtoInt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter IP address: ");
        String str = inp.nextLine();
        String[] strarr = str.split("\\.");
        int[] oct = new int[4];
        for(int i = 0, j = 0;i<strarr.length;i++,j++){
            oct[j] = Integer.parseInt(strarr[i]);
        }
        long a = IPint(oct);
        System.out.println("Integer value is: "+a);
        String string = INTip(a);
        System.out.println("Converted back: "+string);
    }
    public static long IPint(int[] arr){
        long dec = (arr[0]*((long)Math.pow(256,3))) + (arr[1]*((long)Math.pow(256,2))) + (long)(arr[2]*256) + (long)(arr[3]);
        return dec;
    }
    public static String INTip(long a){
        long[] arr = new long[4]; int i = 3;
        while(a>0){
            arr[i] = a%256;
            a = a/256;
            i--;
        }
        String str = Long.toString(arr[0]) + "." + Long.toString(arr[1]) + "." + Long.toString(arr[2]) + "." + Long.toString(arr[3]);
        return str;
    }
}
