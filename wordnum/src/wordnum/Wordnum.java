/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordnum;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class Wordnum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int z = inp.nextInt();
        String str = conversion(z);
        System.out.println(str);
    }
    public static String conversion(int z){
        String string = ""; String[] arr = {"zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};
        if(z==0){
            return string;
        }
        else{
            int rem = z%10;
            string = arr[rem];
        }
        string = conversion(z/10) + string;
        return string;
    }
}
