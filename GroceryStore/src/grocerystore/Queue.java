/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

/**
 *
 * @author Khubaib
 */
public class Queue {
    Customer[] Q;
    int front;
    int curr_id;
    public Queue(int size){
        Q = new Customer[size];
        front = 0;
        curr_id = 0;
    }
    public boolean isEmpty(){
        return front==curr_id;
    }
    public boolean isFull(){
        return front==(Q.length-1);
    }
    public void CancelAll(){
        Q = new Customer[Q.length];
        front = 0;
        curr_id = 0;
    }
    public void HomeDelivery(){
        if(isEmpty()){
            System.out.println("Provide home delivery.");
        }
        else{
            System.out.println("Customers waiting. No delivery possible.");
        }
    }
    public void ShowAll(){
        int count = curr_id;
        System.out.println("List of current customers: ");
        while(Q[count]!=null && count<Q.length){
            System.out.println(Q[count].id);
            count++;
        }
    }
    public void CustomerEnter(){
        Q[front] = new Customer(front);
        front++;
    }
    public void ServeCustomer(){
        System.out.println("Customer "+curr_id+" served.");
        Q[curr_id] = null;
        curr_id++;
    }
}
class Customer{
    int id;
    Customer(int id){
        this.id = id;
    }
}
