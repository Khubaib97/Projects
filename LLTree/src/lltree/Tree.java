/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltree;

/**
 *
 * @author Khubaib
 */
public class Tree<T extends Comparable<T>> {
    Node root;
    public Tree(){
        root = null;
    }
    public void insert(T data){
        Node ins = new Node(data);
        if(root==null){
            root = ins;
            return;
        }
        Node temp = root;
        while(temp!=null){
            if(ins.data.compareTo(temp.data)<0){
                if(temp.left==null){
                    temp.left = ins;
                    break;
                }
                temp = temp.left;
            }
            else{
                if(temp.right==null){
                    temp.right = ins;
                    break;
                }
                temp = temp.right;
            }
        }
    }
    public void find(T data){
        Node ins = new Node(data);
        Node temp = root;
        while(temp!=null){
            if(ins.data.compareTo(temp.data)==0){
                System.out.println("Value found");
                break;
            }
            else if(ins.data.compareTo(temp.data)<0){
                temp = temp.left;
                if(temp.data.compareTo(ins.data)==0){
                    System.out.println("Value found");
                    break;
                }
            }
            else{
                temp = temp.right;
                if(temp.data.compareTo(ins.data)==0){
                    System.out.println("Value found");
                    break;
                }
            }
        }
    }
    public void delete(int val){
        Node ins = new Node(val);
        Node temp = root;
        Node parent = temp;
        while(temp.right!=null || temp.left!=null){
            if(ins.data.compareTo(temp.data)==0){
                System.out.println("Value found");
                break;
            }
            else if(ins.data.compareTo(temp.data)<0){
                parent = temp;
                temp = temp.left;
                if(temp.data.compareTo(ins.data)==0){
                    System.out.println("Value found");
                    break;
                }
            }
            else{
                parent = temp;
                temp = temp.right;
                if(temp.data.compareTo(ins.data)==0){
                    System.out.println("Value found");
                    break;
                }
            }
        }
        System.out.println(parent.data);
        System.out.println(temp.data);
        if(temp.left==null && temp.right==null){
            if(parent.left==null){
                parent.right = null;
            }
            else{
                parent.right = null;
            }
        }
        else if((temp.left==null) || (temp.right==null)){
            if(temp.left==null){
                if(parent.left.data.compareTo(ins.data)==0){
                    parent.left = temp.right;
                }
                else{
                    parent.right = temp.right;
                }
            }
            else{
                if(parent.left.data.compareTo(ins.data)==0){
                    parent.left = temp.left;
                }
                else{
                    parent.right = temp.left;
                }
            }
        }
        else{
            Node t = temp;
            Node tp = t;
            while(t.right!=null){
                tp = t;
                t = t.right;
            }
            temp = t;
            tp.right = null;
        }
    }
}
class Node<T extends Comparable<T>>{
    T data;
    Node left;
    Node right;
    public Node(){
        data = null;
        right = null;
        left = null;
    }
    public Node(T data){
        this.data = data;
        left = null;
        right = null;
    }
}
