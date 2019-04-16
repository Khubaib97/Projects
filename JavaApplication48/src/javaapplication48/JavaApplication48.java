/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication48;

/**
 *
 * @author Khubaib
 */
public class JavaApplication48 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 2; i < 200; i++) {
            if ((34*i)%89==1) {
                System.out.println(i);
                break;
            }
        }
    }
    
}
