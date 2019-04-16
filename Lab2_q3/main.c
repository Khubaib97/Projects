/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Khubaib
 *
 * Created on January 23, 2018, 8:53 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int arr[] = {2, 8, 4, 1, 6, 3};
    printf("%d", sizeof(arr));
    int i, j;
    for(i = 0; i<sizeof(arr)-1; i++){
        for(j = 0; j<sizeof(arr)-i-1; j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    printf("Sorted array: ");
    for(i = 0; i<sizeof(arr); i++){
        printf("%d ", arr[i]);
    }
    return (EXIT_SUCCESS);
}

