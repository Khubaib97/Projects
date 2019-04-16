/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryds;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Khubaib
 */
public class DictionaryDS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Dictionary.txt");
        String[][] arr = new String[GetFileLines(f)][2];
        Scanner sc = new Scanner(f);
        int in = 0;
        while(sc.hasNextLine()){
            String str = sc.nextLine().trim();
            int a = GetASCII(str);
            if(!str.equals("") && !(a>=65&&a<=90) && !(isSymbol(str.charAt(0)))){
                if(str.contains("Usage")){
                    if(str.contains("Usage  n.")){
                        arr[in] = str.split("  ", 2);
                        in++;
                    }
                }
                else{
                    arr[in] = str.split("  ", 2);
                    in++;
                }  
            }
        }
        sc.close();
        ArrayShuffle(arr);
        Scanner inp = new Scanner(System.in);
        System.out.println("Input 0 for HashTable, 1 for BST");
        int choice = inp.nextInt();
        switch(choice){
            case 0:
                HashTable h = new HashTable(arr.length);
                for(int i = 0; i<arr.length; i++){
                    h.insert(arr[i][0], arr[i][1]);
                }
                h.find("Bath");
                h.delete("Bath");
                h.find("Bath");
                h.display();
                break;
            case 1:
                BST b = new BST();
                for(int i = 0; i<arr.length; i++){
                    b.insert(arr[i][0], arr[i][1]);
                }
                b.find("Aback");
                b.delete("Aback");
                b.find("Aback");
                b.traversal();
                break;
        }
    }
    public static int GetFileLines(File f) throws FileNotFoundException{
        Scanner sc = new Scanner(f);
        int count = 0;
        while(sc.hasNextLine()){
            String str = sc.nextLine().trim();
            int a = GetASCII(str);
            if(!str.equals("") && !(a>=65&&a<=90) && !(isSymbol(str.charAt(0)))){
                if(str.contains("Usage")){
                    if(str.contains("Usage  n.")){
                        count++;
                    }
                }
                else{
                    count++;
                }    
            }
        }
        sc.close();
        return count;
    }
    public static void ArrayShuffle(String[][] arr){
        Random ran = new Random();
        for(int i = arr.length-1; i>0; i--){
            int ri = ran.nextInt(i+1);
            String[] temp = arr[ri];
            arr[ri] = arr[i];
            arr[i] = temp;
        }
    }
    public static int GetASCII(String str){
        char[] ch = str.toCharArray();
        int count = 0;
        for(int i = 0; i<ch.length; i++){
            count += (int)ch[i];
        }
        return count;
    }
    public static boolean isSymbol(char c){
        return !((c>='a'&&c<='z') || (c>='A'&&c<='Z'));
    }
}
