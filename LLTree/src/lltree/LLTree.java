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
public class LLTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(40);
        t.insert(50);
        t.insert(10);
        t.insert(30);
        t.insert(60);
        t.insert(70);
        t.insert(5);
        t.insert(20);
        t.insert(101);
        t.insert(31);
        printPaths(t.root);
        t.delete(101);
        printPaths(t.root);
    }
    static void printPaths(Node node) 
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
    static void printPathsRecur(Node node, int path[], int pathLen) 
    {
        if (node == null)
            return;
        path[pathLen] = (int)node.data;
        pathLen++;
        if (node.left == null && node.right == null)
            printArray(path, pathLen);
        else
        {
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }
    static void printArray(int ints[], int len) 
    {
        int i;
        for (i = 0; i < len; i++) 
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }
    /*public static void print(Node temp){
        if(temp!=null){
            System.out.println("");
            print(temp.left);
            System.out.print(temp.data+" ");
            print(temp.right);
        }
    }*/
}
