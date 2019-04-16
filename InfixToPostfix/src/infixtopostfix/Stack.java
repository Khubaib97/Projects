/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infixtopostfix;

import java.util.ArrayList;

/**
 *
 * @author Khubaib
 */
public class Stack<T> {
    ArrayList<T> stack = new ArrayList<T> ();
    int top = 0;
    public boolean isEmpty(){
        return top==0;
    } 
    public int size() { 
        return top; 
    }
    public void push(T item) {
        stack.add (top++, item);
    }
    public T pop() {
        return stack.remove (--top);
    }
    public T peek(){
        return stack.get(top-1);
    }
}
