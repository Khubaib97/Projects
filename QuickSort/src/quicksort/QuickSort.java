/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author Khubaib
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {55, 44, 33, 22, 11};
        Q_S(arr, 0, arr.length-1);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public static void Q_S(int[] arr, int L, int U){
        /*if(L>arr.length-1){
            return;
        }
        if(U<0){
            return;
        }
        int mid = 0;
        int diff = Math.abs(arr[0]-((arr[L]+arr[U])/2));
        for(int i = 0; i<arr.length; i++){
            if(diff>Math.abs(arr[i]-((arr[L]+arr[U])/2))){
                mid = i;
            }
        }
        int pivot = arr[mid];
        while(L<U){
            while(L<=U && (arr[L]<=pivot)){
                L++;
            }
            while(L<=U && (arr[L]>pivot)){
                U--;
            }
            if(L<U){
                int temp = pivot;
                arr[mid] = arr[L];
                arr[L] = temp;
            }
        }
        Q_S(arr, 0, U-1);
        Q_S(arr, U+1, arr.length-1);*/
        if(L>arr.length-1){ return;}
        if(U<0){ return;}
        if(L<U){
            int mid = partition(arr, L, U);
            Q_S(arr, L, mid-1);
            Q_S(arr, mid+1, U);
        }
    }
    public static int partition(int[] arr, int L, int U){
        int pi = L;
        int pivot = arr[L];
        while(L<U){
            while(L<=U && (arr[L]<=pivot)){
                L++;
            }
            while(L<=U && (arr[L]>pivot)){
                U--;
            }
            if(L<U){
                int temp = arr[L];
                arr[L] = arr[U];
                arr[U] = temp;
            }
        }
        int temp = arr[pi];
        arr[pi] = arr[U];
        arr[U] = temp;        
        return U;
    }
}
