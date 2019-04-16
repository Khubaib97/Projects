/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Khubaib
 *
 * Created on January 23, 2018, 8:18 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
 * 
 */
int main(int argc, char** argv) {
    char name[10];
    printf("Enter name: ");
    scanf("%s", name);
    printf("The name %s\n", name);
    palin(name);
    return (EXIT_SUCCESS);
} 
void palin(char name[]){
    int i; int j;
    for(i =0, j = strlen(name)-1; j > i; i++, j--){
        if(name[i]!=name[j]){
            printf("Is not a palindrome");
            return;
        }
    }
    printf("Is a palindrome");
    return;
}
