/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class BarCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("enter: ");
        String hue = inp.nextLine();
        System.out.println("output: ");
        System.out.println(hue);
    }    
}
