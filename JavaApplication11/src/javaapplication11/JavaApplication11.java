/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

/**
 *
 * @author Khubaib
 */
public class JavaApplication11 {

    
    public static int sumint(int i1, int i2) {
        int sum = 0;
        for(int i=i1;i<=i2;i++)
            sum+=i;
        return sum;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sumint(1, 10));
        System.out.println(sumint(20, 30));
        System.out.println(sumint(35, 45));
    }
    
}
