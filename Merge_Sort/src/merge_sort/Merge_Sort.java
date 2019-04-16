/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge_sort;

/**
 *
 * @author Khubaib
 */
public class Merge_Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        Merge_Sort(arr, 0, arr.length-1);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+", ");
        }
    }
    public static void Merge_Sort(int[] arr, int L, int U){
        if(L<U){
            int mid = (L+U)/2;
            Merge_Sort(arr, L, mid);
            Merge_Sort(arr, mid+1, U);
            Merge(arr, L, mid, U);
        }
    }
    public static void Merge(int[] arr, int L, int mid, int U){
        int tL[] = new int[mid-L+1];
        int tR[] = new int [U-mid];
        for (int i=0; i<tL.length; ++i)
            tL[i] = arr[L + i];
        for (int j=0; j<tR.length; ++j)
            tR[j] = arr[mid + 1+ j];
        int i = 0, j = 0;
        int k = L;
        while (i < tL.length && j < tR.length)
        {
            if (tL[i] <= tR[j])
            {
                arr[k] = tL[i];
                i++;
            }
            else
            {
                arr[k] = tR[j];
                j++;
            }
            k++;
        }
        while (i < tL.length)
        {
            arr[k] = tL[i];
            i++;
            k++;
        }
        while (j < tR.length)
        {
            arr[k] = tR[j];
            j++;
            k++;
        }
    }
}
