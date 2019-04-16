/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerystore;

/**
 *
 * @author Khubaib
 */
public class GroceryStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue q = new Queue(50);
        q.HomeDelivery();
        q.CustomerEnter();
        q.CustomerEnter();
        q.HomeDelivery();
        q.ShowAll();
        q.ServeCustomer();
        q.ServeCustomer();
        q.HomeDelivery();
        q.CustomerEnter();
        q.CustomerEnter();
        q.ShowAll();
        q.CancelAll();
        q.ShowAll();
    }
    
}
