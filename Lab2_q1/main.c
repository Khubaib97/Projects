/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Khubaib
 *
 * Created on January 23, 2018, 7:52 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    char arr[] = {'U','N','I','V','E','R','S','I','T','Y'};
    for(int i = 0; i<sizeof(arr)+1; i++){
        for(int j = 0; j<i; j++){
            printf("%c",arr[j]);
        }
        printf("\n");
    }
    for(int i = 0; i<sizeof(arr)+1; i+=2){
        for(int j = 0; j<i; j++){
            printf("%c",arr[j]);
        }
            printf("\n");
    }
    for(int i = sizeof(arr)-2; i>-1; i-=2){
        for(int j = 0; j<i; j++){
            printf("%c",arr[j]);
        }
        printf("\n");
    }
    return (EXIT_SUCCESS);
}

