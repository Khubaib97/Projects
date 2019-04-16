/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprocessing;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class StringProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("How many lines? ");
        int line = inp.nextInt();
        String str = "";
        System.out.println("Enter input:");
        for(int i = 0;i<=line;i++){
            str += inp.nextLine() + "\n";
        }
        System.out.print("Enter word to be replaced(0 if none): ");
        String str1 = inp.nextLine();
        if(str1.equals("0")){}
        else{
            System.out.print("Replace it with? ");
            String str2 = inp.nextLine();
            str = str.replaceAll(str1, str2);
        }
        System.out.println(str);
        int spaces = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                spaces += 1;
            }
        }
        System.out.println("Number of spaces: "+spaces);
        String[] strarr = str.split("[ \n\\.]");
        System.out.println("Number of words: "+(strarr.length-1));
        int articles = 0;
        for(int i = 0;i<strarr.length;i++){
            if(strarr[i].equalsIgnoreCase("a") || strarr[i].equalsIgnoreCase("an") || strarr[i].equalsIgnoreCase("the")){
                articles += 1;
            }
        }
        System.out.println("Number of articles: "+articles);
        String[] strarr1 = str.split("\\.");
        System.out.println("Number of sentences: "+(strarr1.length-1));
    }    
    
}
