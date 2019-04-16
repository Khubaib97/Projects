/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author Khubaib
 */
public class Mergesort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {34,56,29,37,48,19,7};
        arr = function(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] function(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        else{
            int[] part1 = new int[arr.length/2];
            for(int i = 0; i<arr.length/2; i++){
                part1[i] = arr[i];
            }
            part1 = function(part1);
            int[] part2 = new int[arr.length-(arr.length/2)];
            for(int i = 0, j = arr.length/2; i<part2.length; i++, j++){
                part2[i] = arr[j];
            }
            part2 = function(part2);
            arr = sortnmerge(part1, part2, arr);
        }
        return arr;
    }
    // ASK QUESTION ABOUT WHETHER YOU CAN USE VOID!!!!!!!!
    public static int[] sortnmerge(int[] part1, int[] part2, int[] copy){
        int i = 0, j = 0, k = 0;
        while(i<part1.length && j<part2.length){
            if(part1[i]<part2[j]){
                copy[k] = part1[i];
                k++; i++;
            }
            else{
                copy[k] = part2[j];
                k++; j++;
            }
        }
        if(i==part1.length){
            while(j<part2.length){
                copy[k] = part2[j];
                k++; j++;
            }
        }
        else if(j==part2.length){
            while(i<part1.length){
                copy[k] = part1[i];
                k++; i++;
            }
        }
        return copy;
    }
}
