/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryds;

/**
 *
 * @author Khubaib
 */
public class BST {
    Node root;
    public BST(){
        root = null;
    }
    public void insert(String w, String m){
        Node ins = new Node(w, m);
        if(root==null){
            root = ins;
            return;
        }
        Node temp = root;
        while(temp!=null){
            if(ins.word.compareTo(temp.word)<0){
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
    public void find(String data){
        Node temp = root;
        while(temp!=null){
            if(data.compareTo(temp.word)==0){
                System.out.println(temp.toString());
                return;
            }
            else if(data.compareTo(temp.word)<0){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        System.out.println("Word not found.");
    }
    public void delete(String data){
        Node temp = root;
        Node parent = temp;
        while(temp!=null){
            if(data.compareTo(temp.word)==0){
                break;
            }
            else if(data.compareTo(temp.word)<0){
                parent =  temp;
                temp = temp.left;
            }
            else{
                parent = temp;
                temp = temp.right;
            }
        }
        if(temp.left==null && temp.right==null){
            if(parent.left==temp){
                parent.left = null;
            }
            else{
                parent.right = null;
            }
        }
        else if(temp.left!=null && temp.right!=null){
            Node t = temp.right;
            Node tp = temp;
            while(t.left != null){
                tp = t;
                t = t.left;
            }
            temp.word = t.word;
            temp.meaning = t.meaning;
            tp.left = null;
        }
        else{
            if(temp.left==null){
                if(parent.left.word.compareTo(data)==0){
                    parent.left = temp.right;
                }
                else{
                    parent.right = temp.right;
                }
            }
            else{
                if(parent.left.word.compareTo(data)==0){
                    parent.left = temp.left;
                }
                else{
                    parent.right = temp.left;
                }
            }
        }
    }
    public void traversal(){
        traverse(root);
    }
    public void traverse(Node n){
        if(n==null){
            return;
        }
        traverse(n.left);
        System.out.println(n.toString());
        traverse(n.right);
    }
}
class Node{
    String word;
    String meaning;
    Node left;
    Node right;
    public Node(String w, String m){
        word = w;
        meaning = m;
        left = null;
        right = null;
    }
    public String toString(){
        return word+"  "+meaning;
    }
}
