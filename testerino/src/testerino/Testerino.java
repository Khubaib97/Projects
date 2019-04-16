/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testerino;
class customer{
    private int bal = 0;
    public void deposit(int amount){
        bal += amount;
    }
    public void withdraw(int amount){
        bal -= amount;
    }
    public int balance(){
        if(bal==0){
            System.out.println("POOR CUNT");
            System.exit(0);
        }
        else{
        return bal;
        }
        return bal;
    }
}
/**
 *
 * @author Khubaib
 */
public class Testerino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        customer obj1 = new customer();
        customer obj2 = new customer();
        customer obj3 = new customer();
        obj1.deposit(10000);
        obj1.deposit(25000);
        obj2.deposit(5000);
        System.out.println(obj1.balance());
        System.out.println("customer 3: "+obj3.balance());
    }
    
}
