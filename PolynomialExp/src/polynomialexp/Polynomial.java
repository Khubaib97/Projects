/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialexp;

/**
 *
 * @author Khubaib
 */
public class Polynomial {
    Node head;
    public Polynomial(){
        head = null;
    }
    public void Insert(int coeff, int power){
        Node temp = head;
        Node ins = new Node(coeff, power, null);
        if(head==null){
            head = ins;
            return;
        }
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = ins;
    }
    public void add(Polynomial p1, Polynomial p2){
        Node t1 = p1.head;
        Node t2 = p2.head;
        int count = 1;
        while(t1.next!=null || t2.next!=null){
            if(t1.next!=null){
                t1 = t1.next;
            }
            if(t2.next!=null){
                t2 = t2.next;
            }
            count++;
        }
        t1 = p1.head;
        t2 = p2.head;
        for(int i =count-1; i>-1; i--){
            int co = 0;
            if(t1.power==i){
                co += t1.coeff;
                t1 = t1.next;
            }
            if(t2.power==i){
                co += t2.coeff;
                t2 = t2.next;
            }
            Insert(co, i);
        }
    }
    public void display(){
        Node temp = head;
        int count = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        temp = head;
        for(int i =0; i<count; i++){
            System.out.print(temp.coeff);
            if(temp.power!=0){
                System.out.print("x^"+temp.power+"+");
            }
            temp = temp.next;
        }
        System.out.println("");
    }
}
class Node{
    int coeff;
    int power;
    Node next;
    public Node(){
        coeff = 0;
        power = 0;
        next = null;
    }
    public Node(int coeff, int power, Node n){
        this.coeff = coeff;
        this.power = power;
        this.next = n;
    }
}