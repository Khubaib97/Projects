/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letteroccurence;

/**
 *
 * @author Khubaib
 */
public class LetterOccurence {
public static void creturn(char[] arr){
    int occur; int[] array = new int[26];
    for(int j = 0;j<26;j++){
        occur = 0;
        for(int x = 0;x<arr.length;x++){
            if(arr[x]==(char)('a'+j)){
                occur += 1;
            }
        }
        array[j] = occur;
    }
    for(int j = 0;j<array.length;j++){
        System.out.println("Number of "+(char)('a'+j)+": "+array[j]);
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] let = new char[100];
        for(int i = 0;i<let.length;i++){
            let[i] = (char)((int)(Math.random()*26) + 97);
        }
        creturn(let);    
    }
    
}
