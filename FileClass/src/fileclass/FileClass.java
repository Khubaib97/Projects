/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileclass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Khubaib
 */
class ReplaceText{
    ReplaceText(){}
    ReplaceText(File f1, File f2, String s1, String s2) throws FileNotFoundException{
        Scanner sc1 = new Scanner(f1);
        String str = "";
        while(sc1.hasNext()){
            str += sc1.next() + " ";
        }
        sc1.close();
        str = str.replace(s1, s2);
        PrintWriter pw1 = new PrintWriter(f2);
        pw1.print(str);
        pw1.close();;
    }
}
public class FileClass {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        File file1 = new File("f:\\one.txt");
        File file2 = new File("f:\\two.txt");
        new ReplaceText(file1, file2, "potato", "tomato");
        BufferedReader br = new BufferedReader(new FileReader(file2));
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}
