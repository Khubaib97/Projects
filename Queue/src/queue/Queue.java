/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author Khubaib
 */
public class Queue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Q queue = new Q(5);
        for(int i = 0; i<4; i++){
            queue.Enqueue(i);
        }
        for(int i = 0; i<4; i++){
            System.out.println(queue.Dequeue());
        }
    }
    
}
