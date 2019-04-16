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
public class GenericDoublyLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DLL<Double> a = new DLL<Double>();
        a.Insert(1.4);
        System.out.println(a.toString());
        a.Insert(2.3);
        System.out.println(a.toString());
        a.Insert(0.7);
        System.out.println(a.toString());
        a.Insert(1.7);
        System.out.println(a.toString());
        a.Insert(3.1);
        System.out.println(a.toString());
        a.find(1.7);
        a.delete(2.3);
        a.delete(0.7);
        a.delete(3.1);
        System.out.println(a.toString());
    }
    
}
