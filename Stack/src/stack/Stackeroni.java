/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Khubaib
 */
public class Stackeroni {
    char[] stackList;
    int top;
    public Stackeroni(int size){
        stackList = new char[size];
        top = 0;
    }
    public void push(char c){
        if(isFilled()==true){
            System.out.println("Stack is full.");
            return;
        }
        stackList[top] = c;
        top++;
    }
    public char pop(){
        if(isEmpty()==true){
            return '\u0000';
        }
        char c;
        c = stackList[top];
        top--;
        return c;
    }
    public boolean isEmpty(){
        if(top==0){
            return true;
        }
        return false;
    }
    public boolean isFilled(){
        if(top==stackList.length-1){
            return true;
        }
        return false;
    }
    public void seek(char c){
        boolean flag = false;
        int index = 0;
        for(int i = 0; i<stackList.length; i++){
            if(stackList[i]==c){
                flag = true;
                index = i;
                break;
            }
        }
        if(flag==true){
            System.out.println("Found at "+index+"."); 
        }
        else{
            System.out.println("Not found.");
        }
    }
}
