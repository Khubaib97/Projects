/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author Khubaib
 */
public class PriorityQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PQ a = new PQ(5);
        a.enqueue(3);
        a.enqueue(7);
        a.enqueue(8);
        a.enqueue(2);
        a.enqueue(3);
        System.out.println(a.toString());
        for(int i =0; i<5; i++){
            a.dequeue();
            System.out.println(a.toString());
        }
    }
    
}
