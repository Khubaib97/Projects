/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leb3;

/**
 *
 * @author Khubaib
 */
public class LinkedList{
    Node head;
    public LinkedList(int d){
        head = new Node(d);
    }
    public void Insert(int d){
        Node in = new Node(d);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = in;
    }
    public void find(int d){
        Node temp = head;
        int count = 0;
        boolean found = false;
        while(temp.next!=null){
            count++;
            if(temp.data==d){
                found = true;
                break;
            }
            else{
                temp = temp.next;
            }
        }
        if(found==false){
            System.out.println("Value not found.");
        }
        else{
            System.out.println("Value found at :"+count);
        }
    }
    public void clear(){
        head = null;
    }
    public String toString(){
        String str = "";
        Node temp = head;
        int count = 0;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        temp = head;
        for(int i = 0; i<count+1; i++){
            str = str+","+temp.data;
            temp = temp.next;
        }
        return str;
    }
}
class Node{
    int data;
    Node next;
    public Node(){
        data = 0;
        next = null;
    }
    public Node(int DATA){
        this.data = DATA;
        next = null;
    }
}
