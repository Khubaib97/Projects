/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;

import java.util.ArrayList;

/**
 *
 * @author Khubaib
 */
class Stack {

    int[] arr;
    int top;

    Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    void push(int data) {

        if (top != arr.length - 1) {
            top++;
            arr[top] = data;
        }
        else {
            System.out.println("Stack is full!");
        }
    }

    int pop() {
        
        if (top == -1)
        {
            System.out.println("Stack is empty!");
            return -1;
            
        }
        else {
            int temp = arr[top];
            arr[top] = ' ';
            top--;
            return temp;
        }

    }
    
    boolean isEmpty() {
        
        return (top == -1);
        
    }
    
    boolean isFull() {
        return (top == arr.length - 1);
    }

}
class Infix {
    
    String exp;
    Stack stk;
    
    Infix(String exp)
    {
        this.exp = exp;
        stk = new Stack(exp.length());
    }
    
    int postfix() {
        
        
        int i = 0;
        
        while (i < exp.length())
        {
            char c = exp.charAt(i);
            
            if (c == ' ')
            {
                
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/')
            {
                int k = stk.pop();
                int j = stk.pop();
                
                if (c == '+')
                {
                    stk.push(k+j);
                }
                else if (c == '*')
                {
                    stk.push(k*j);
                }
                else if (c == '-')
                {
                    stk.push(j-k);
                }
                else {
                    stk.push(j/k);
                }
            }
            else {
                String s = "";
                while (exp.charAt(i) != ' ')
                {
                    s = s + exp.charAt(i);
                    i++;
                }
                stk.push(Integer.parseInt(s));
                
            }
            i++;
            
        }
        
        return stk.pop();
    }
    
}
