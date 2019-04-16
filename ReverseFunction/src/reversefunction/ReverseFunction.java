/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversefunction;

/**
 *
 * @author Khubaib
 */
public class ReverseFunction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DLL a = new DLL();
        a.Insert(5);
        a.Insert(6);
        a.Insert(7);
        a.Insert(8);
        a.Insert(9);
        a.Insert(11);
        System.out.println(a.toString());
        System.out.println("AFTER REVERSE");
        Reverse(a.head);
    }
    static void Reverse(Node head){
        Node h_next = null, h_prev = null;
        // cannot use head.next as condition; last node untouched that way
        while(head!=null){
            h_prev = head.prev;
            h_next = head.next;
            head.prev = h_next;
            head.next = h_prev;
            head = h_next;
        }
        head = h_prev.prev;
        // print job below
        String str = "";
        Node temp = head;
        while(temp!=null){
            str = str+","+temp.data;
            temp = temp.next;
        }
        System.out.println(str);
    }
}
