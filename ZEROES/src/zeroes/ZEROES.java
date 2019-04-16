/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeroes;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class ZEROES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int a = inp.nextInt();
        System.out.println(zer(a));
    }
    public static int zer(int b){
        int c = 0;
        if(b!=0){
            if(b%10==0){
                c += 1;
            }
            c = c + zer(b/10);
        }
        return c;
    }
}
