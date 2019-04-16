/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

/**
 *
 * @author Khubaib
 */
public class HashTable<T> {
    LinkedList<T>[] table;
    public HashTable(int size){
        table = new LinkedList[size];
        for(int i = 0; i<table.length; i++){
            table[i] = new LinkedList();
        }
    }
    public int Hash(int key){
        return key%table.length;
    }
    public void insert(T ins, int key){
        int i = Hash(key);
        table[i].Insert(ins);
    }
    public void displayTable(){
        for(int i = 0; i<table.length; i++){
            if(table[i].head!=null)
            System.out.println(table[i].toString());
        }
    }
}
class Node<T>{
    T data;
    Node next;
    public Node(T data){
        this.data = data;
        next = null;
    }
}
class LinkedList<T>{
    Node head;
    public void Insert(T data){
        if(head==null){
            head = new Node(data);
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new Node(data);
    }
    public void Remove(T data){
        Node ins = new Node(data);
        if(head.data.equals(ins.data)){
            head = head.next;
        }
        Node temp = head;
        while(temp.next!=null){
            if(temp.next.data.equals(ins.data)){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    public void clear(){
        head = null;
    }
    public String toString(){
        String str = "";
        Node temp = head;
        while(temp!=null){
            str = str+temp.data.toString();
            temp = temp.next;
        }
        return str;
    }
}
class Student{
    int ID;
    String name;
    String address;
    public Student(int a, String b, String c){
        ID = a;
        name = b;
        address = c;
    }
    public String toString(){
        return "ID = "+ID+"\nName: "+name+"\nAddress: "+address+"\n";
    }
}