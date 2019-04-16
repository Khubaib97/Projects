/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;
class account{
    private String name;
    private String acc;
    private String nic;
    private double balance;
    account(){
        name = "Eggs benedict";
        acc = "6666666";
        nic = "4220109964515";
        balance = 0;
    }
    account(String name, String nic, String acc){
        this.name = name;
        this.nic = nic;
        this.acc = acc;
    }
    public String GetName(){
        return name;
    }
    public String GetAcc(){
        return acc;
    }
    public String GetNic(){
        return nic;
    }
    public double GetBalance(){
        return balance;
    }
    public void Deposit(double amount){
        balance += amount;
    }
    public void Withdraw(double amount){
        if(balance<=1000){
            System.out.println("Min balance reached");
        }
        else{
            balance -= amount;
        }
    }
    public String toString(){
        return "NAME: "+name+"/nBALANCE: "+balance;
    }
}
class curracc extends account{
    public String toString(){
        return "NAME: "+super.GetName()+"\nBALANCE: "+super.GetBalance()+"\nACCOUNT TYPE: CURRENT";
    } 
}
class savacc extends account{
    double savings;
    savacc(){
        super();
        savings = 0;
    }
    savacc(String name, String nic, String acc, double savings){
        super(name, nic, acc);
        this.savings = savings;
    }
    public void Deposit(double amount){
        super.Deposit(amount-(amount*0.05));
        savings += amount*0.05;
    }
    public String toString(){
        return "NAME: "+super.GetName()+"\nBALANCE: "+super.GetBalance()+"\nACCOUNT TYPE: SAVING"+"\nSAVINGS: "+savings;
    }
}
/**
 *
 * @author Khubaib
 */
public class BankSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        account A1 = new savacc();
        account A2 = new curracc();
        System.out.println(A1.toString());
        System.out.println(A2.toString());
    }
    
}
