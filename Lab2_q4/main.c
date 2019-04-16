/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Khubaib
 *
 * Created on January 23, 2018, 9:39 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    for(int i = 1; i<=5; i++){
        for(int j = 1; j<=i; j++){
            printf("*");
        }
        printf("\n");
    }
    for(int i = 4; i>0; i--){
        for(int j = 1; j<=i; j++){
            printf("*");
        }
        printf("\n");
    }
    printf("NEXT PATTERN\n");
    for(int i = 1; i<=5; i++){
        for(int j = i; j<=5; j++){
            printf(" ");
        }
        for(int j = 1; j<=i; j++){
            printf("*");
        }
        printf("\n");
    }
    for(int i = 4; i>0; i--){
        for(int j = i; j<=5; j++){
            printf(" ");
        }
        for(int j = 1; j<=i; j++){
            printf("*");
        }
        printf("\n");
    }
    printf("NEXT PATTERN\n");
    for(int i = 1; i<=5; i++){
        for(int j = i; j<=5; j++){
            printf("*");
        }
        for(int j = 1; j<i; j++){
            printf(" ");
        }
        for(int j = 1; j<i; j++){
            printf(" ");
        }
        for(int j = i; j<=5; j++){
            printf("*");
        }
        printf("\n");
    }
    for(int i = 4; i>0; i--){
        for(int j = i; j<=5; j++){
            printf("*");
        }
        for(int j = 1; j<i; j++){
            printf(" ");
        }
        for(int j = 1; j<i; j++){
            printf(" ");
        }
        for(int j = i; j<=5; j++){
            printf("*");
        }
        printf("\n");
    }
    printf("NEXT PATTERN\n");
    for(int i = 0; i<5; i++){
        for(int j = 0; j<i; j++){
            printf("  ");
        }
        for(int j = 0; j<5-i; j++){
            printf("*");
        }
        printf("\n");
    }
    for(int i = 3; i>=0; i--){
        for(int j = 0; j<i; j++){
            printf("  ");
        }
        for(int j = 0; j<5-i; j++){
            printf("*");
        }
        printf("\n");
    }
    printf("NEXT PATTERN\n");
    for(int i = 0; i<5; i++){
        for(int j = 0; j<5-(i+1); j++){
            printf(" ");
        }
        for(int j = 0; j<5-i; j++){
            printf("*");
        }
        printf("\n");
    }
    for(int i = 3; i>=0; i--){
        for(int j = 0; j<4-i; j++){
            printf(" ");
        }
        for(int j = 0; j<5-i; j++){
            printf("*");
        }
        printf("\n");
    }
    return (EXIT_SUCCESS);
}

