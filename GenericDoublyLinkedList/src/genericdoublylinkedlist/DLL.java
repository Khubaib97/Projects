/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericdoublylinkedlist;

/**
 *
 * @author Khubaib
 */
public class DLL<T extends Comparable<T>> {
    Node head;
    Node tail;
    public DLL(){
        head = null;
        tail = null;
    }
    public DLL(T data){
        head = new Node(data, null, null);
        tail = null;
    }
    public void Insert(T data){
        Node ins = new Node(data, null, null);
        Node temp = head;
        int count = 1;
        if(head==null){
            head = ins;
            tail = ins;
            return;
        }
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        temp = head;
        for(int i =0; i<count; i++){
            if(ins.data.compareTo(temp.data)>0){
                if(temp.next==null){
                    temp.next = ins;
                    ins.prev = temp;
                    tail = ins;
                    return;
                }
                temp = temp.next;
            }
            else{
                if(temp.prev==null){
                    ins.next = temp;
                    temp.prev = ins;
                    head = ins;
                }
                else{
                    Node t = temp.prev;
                    temp.prev = ins;
                    ins.next = temp;
                    ins.prev = t;
                    t.next = ins;
                }
                break;
            }
        }
    }
    public int find(T data){
        Node temp = head;
        Node ins = new Node(data, null, null);
        int count = 1;
        int index = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        temp = head;
        for(int i = 0; i<count; i++){
            if(temp.data.compareTo(ins.data)==0){
                System.out.println("Value found at: "+index);
                return index;
            }
            else{
                temp = temp.next;
                index++;
            }
        }
        System.out.println("Value could not be found.");
        return -5;
    }
    public void delete(T data){
        int index = find(data);
        if(index==-5){
            System.out.println("That entry does not exist.");
            return;
        }
        Node temp = head;
        for(int i =1; i<index; i++){
            temp = temp.next;
        }
        if(temp==head){
            head = temp.next;
            head.prev = null;
        }
        else if(temp==tail){
            tail = temp.prev;
            tail.next = null;
        }
        else{
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }    
    }
    public String toString(){
        String str = "";
        Node temp = head;
        int count = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        temp = head;
        for(int i = 0; i<count; i++){
            str = str+","+temp.data;
            temp = temp.next;
        }
        return str;
    }
}
class Node<T extends Comparable<T>> {
    T data;
    Node next;
    Node prev;
    public Node(){
        next = null;
        prev = null;
    }
    public Node(T data, Node next, Node prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
