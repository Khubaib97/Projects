/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author Khubaib
 */
public class PQ<T extends Comparable<T>> {
    T[] Q;
    int F;
    public PQ(){
        
    }
    public PQ(int size){
        Q = (T[])new Comparable[size];
        F = -1;
    }
    public void enqueue(T data){
        if(isFull()){
            System.out.println("Queue is full.");
            return;
        }
        if(isEmpty()){
            F = 0;
            Q[F] = data;
        }
        else{
            for(int i = F; i>-1; i--){
                if(data.compareTo(Q[i])>0){
                    Q[i+1] = Q[i];
                    Q[i] = data;
                }
                else{
                    Q[++i] = data;
                    break;
                }
            }
        F++;
        }
    }
    public T dequeue(){
        return Q[F--];
    }
    public boolean isEmpty(){
        return F==-1;
    }
    public boolean isFull(){
        return F==Q.length-1;
    }
    public String toString(){
        String str = "";
        for(int i =0; i<F+1; i++){
            str = str+Q[i];
        }
        return str;
    }
}
