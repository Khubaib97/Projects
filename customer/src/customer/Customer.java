/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;
class customerr{
    public String name;
    protected double balance;
    public void setName(String s){
        name = s;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    public void RecordCall(int t, double min){
        if(t==1){
            balance += 0.5*min;
        }
        else if(t==2){
            balance += min;
        }
    }
    public void RecordPayment(double a){
        balance = balance - a;
    }
}
class GC extends customerr{
        int minutes = 0;
        public void RecordCall(int t, double min){
            if(t==1){
                balance += 0.5*min;
            }
            else if(t==2){
                for(int i = 0; i<min; i++){
                    if(minutes>=60){
                        balance += 0.2;
                    }
                    else{
                        balance += 0.5;
                    }
                    minutes += 1;
                }
            }
        }
    }
/**
 *
 * @author Khubaib
 */
public class Customer {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GC c2 = new GC();
        c2.RecordCall(2, 20);
        c2.RecordCall(2, 15);
        c2.RecordCall(2, 30);
        c2.RecordCall(2, 25);
        System.out.println(c2.getBalance());
    }
   
}