/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author Khubaib
 */
public class Q<T> {
    T[] arr;
    int F, R;
    public Q(){
        
    }
    public Q(int size){
        arr = (T[])new Object[size];
        F=size-1;
        R=size-1;
    }
    public void Enqueue(T data){
        if(isFull()){
            System.out.println("Queue is already full.");
            return;
        }
        R = (R+1)%(arr.length);
        arr[R] = data;
    }
    public T Dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to delete.");
            return null;
        }
        F = (F+1)%arr.length;
        return arr[F];
    }
    public boolean isEmpty(){
        return F==R;
    }
    public boolean isFull(){
        return (R+1)%arr.length==F;
    }
}
