/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitsumstring;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class DigitSumString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String str = inp.nextLine();
        int sum = digitsum(str, 0);
        System.out.println(sum);
    }
    public static int digitsum(String str, int idx){
        int sum = 0;
        if(idx<str.length()){
            if(str.charAt(idx)=='1'||str.charAt(idx)=='2'||str.charAt(idx)=='3'||str.charAt(idx)=='4'||str.charAt(idx)=='5'||str.charAt(idx)=='6'||str.charAt(idx)=='7'||str.charAt(idx)=='8'||str.charAt(idx)=='9'){
                sum = sum + ((int)str.charAt(idx)-48);
                sum = sum + digitsum(str, (idx+1));
            }
            else{
                sum = sum + digitsum(str, (idx+1));
            }
        }
        return sum;
    }
}
