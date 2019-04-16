/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khpayments;
import java.util.ArrayList;
import java.util.Scanner;

interface Payments{
    double payments();
}
abstract class Supplier implements Payments{
    protected String name;
    protected String email;
    protected String website;
    protected int numofgoods;
    Supplier(){
        name = "DoofenSchmertz Evil Incorporated";
        email = "123@example.com";
        website = "www.company.com";
        numofgoods = 0;
    }
    Supplier(String name, String email, String website, int numofgoods){
        this.name = name;
        this.email = email;
        this.website = website;
        this.numofgoods = numofgoods;
    }
    public String toString(){
        return "Name: "+name+"\nWebsite: "+website+"\nE-mail: "+email;
    }
}
class ElectronicGoods extends Supplier{
    protected double el_rate;
    public ElectronicGoods(String name, String email, String website, int numofgoods, double rate){
        super(name, email, website, numofgoods);
        el_rate = rate;
    }
    public double payments(){
        return el_rate*numofgoods;
    }
    public String toString(){
        return "Name: "+name+"\nWebsite: "+website+"\nE-mail: "+email+"\nPayment due: "+payments();
    }
}
class pharmaceuticals extends Supplier{
    protected double ph_rate;
    public pharmaceuticals(String name, String email, String website, int numofgoods, double rate){
        super(name, email, website, numofgoods);
        ph_rate = rate;
    }
    public double payments(){
        return ph_rate*numofgoods;
    }
    public String toString(){
        return "Name: "+name+"\nWebsite: "+website+"\nE-mail: "+email+"\nPayment due: "+payments();
    }
}
class garments extends Supplier{
    protected double g_rate;
    public garments(String name, String email, String website, int numofgoods, double rate){
        super(name, email, website, numofgoods);
        g_rate = rate;
    }
    public double payments(){
        return g_rate*numofgoods;
    }
    public String toString(){
        return "Name: "+name+"\nWebsite: "+website+"\nE-mail: "+email+"\nPayment due: "+payments();
    }
}
abstract class Employee implements Payments{
    private String firstname;
    private String lastname;
    private String SSN;
    public Employee(){
        firstname = "Benedict";
        lastname = "Cumberbatch";
        SSN = "6969-6969-6969";
    }
    public Employee(String firstname, String lastname, String SSN){
        this.firstname = firstname;
        this.lastname = lastname;
        this.SSN = SSN;
    }
    public String getname(){
        return firstname+" "+lastname;
    }
    public String getssn(){
        return SSN;
    }
    public abstract double payments();
    public String toString(){
        return firstname+" "+lastname+"\nSocial Security Number: "+SSN;
    }
}
class Semployee extends Employee{
    private double WeeklySalary;
    public Semployee(){
        super();
        WeeklySalary = 12.26;
    }
    public Semployee(String firstname, String lastname, String SSN, double WeeklySalary){
        super(firstname, lastname, SSN);
        this.WeeklySalary = WeeklySalary;
    }
    public double payments(){
        return WeeklySalary;
    }
    public String toString(){
        return "Salaried Employee: "+super.getname()+"\nSocial Security Number: "+super.getssn()+"\nWeekly Salary: "+WeeklySalary+"\nPayment due: "+payments();
    }
}
class Hemployee extends Employee{
    private double wage;
    private int hours;
    public Hemployee(){
        super();
        wage = 2.34;
        hours = 0;
    }
    public Hemployee(String firstname, String lastname, String SSN, double wage, int hours){
        super(firstname, lastname, SSN);
        this.wage = wage;
        this.hours = hours;        
    }
    public double payments(){
        if(hours<=40){
            return wage*hours;
        }
        else{
            return ((40*wage)+((hours-40)*wage*1.5));
        }
    }
    public String toString(){
        return "Hourly Employee: "+super.getname()+"\nSocial Security Number: "+super.getssn()+"\nhourly wage: "+wage+"; hours worked: "+hours+"\nPayment due: "+payments();
    }
}
class Cemployee extends Employee{
    private double grosssales;
    private double commissionrate;
    public Cemployee(){
        super();
        grosssales = 0;
        commissionrate = 0.34;
    }
    public Cemployee(String firstname, String lastname, String SSN, double grosssales, double commissionrate){
        super(firstname, lastname, SSN);
        this.grosssales = grosssales;
        this.commissionrate = commissionrate;
    }
    public double getgrosssales(){
        return grosssales;
    }
    public double getcommission(){
        return commissionrate;
    }
    public double payments(){
        return grosssales*commissionrate;
    }
    public String toString(){
        return "Commission Employee: "+super.getname()+"\nSocial Security Number: "+super.getssn()+"\ngross sales: "+grosssales+"\ncommission rate: "+commissionrate+"\nPayment due: "+payments();
    }
}
class BPCemployee extends Cemployee{
    private double basesalary;
    public void Increment(){
        basesalary = (basesalary*1.1);
    }
    public BPCemployee(){
        super();
        basesalary = 15.56;
    }
    public BPCemployee(String firstname, String lastname, String SSN, double grosssales, double commissionrate, double basesalary){
        super(firstname, lastname, SSN, grosssales, commissionrate);
        this.basesalary = basesalary;
    }
    public double payments(){
        return ((super.getgrosssales()*super.getcommission())+(basesalary));
    }
    public String toString(){
        return "Base-Salaried Commission Employee: "+super.getname()+"\nSocial Security Number: "+super.getssn()+"\ngross sales: "+super.getgrosssales()+"\ncommission rate: "+super.getcommission()+"\nBase Salary: "+basesalary+"\nPayment due: "+payments();
    }
}
/**
 *
 * @author Khubaib
 */
public class KHpayments {
static ArrayList<Employee> list = new ArrayList<Employee>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("1 to add new employee");
            System.out.println("2 to remove employee");
            System.out.println("3 to get specified employee's type");
            System.out.println("4 to search for employee by SSN");
            System.out.println("5 to search for employee by name");
            System.out.println("6 to give specific BPC employees increment");
            System.out.println("7 to give list of all employees");
            System.out.println("0 to exit");
            System.out.print("Make your choice: ");
            int choice1 = input.nextInt();
            input.nextLine();
            switch(choice1){
                case 1:
                    System.out.println("1 for Salaried Employee");
                    System.out.println("2 for Hourly Employee");
                    System.out.println("3 for Commission Employee");
                    System.out.println("4 for Base-plus Commission Employee");
                    System.out.print("Make your choice: ");
                    int choice2 = input.nextInt();
                    input.nextLine();
                    switch(choice2){
                        case 1:
                            System.out.println("Input first name: ");
                            String firstname = input.nextLine();
                            System.out.println("Input last name: ");
                            String lastname = input.nextLine();
                            System.out.println("Input SSN: ");
                            String SSN = input.nextLine();
                            System.out.println("Set weekly salary: ");
                            double weeklysalary = input.nextDouble();
                            list.add(new Semployee(firstname, lastname, SSN, weeklysalary));
                            break;
                        case 2:
                            System.out.println("Input first name: ");
                            String firstname1 = input.nextLine();
                            System.out.println("Input last name: ");
                            String lastname1 = input.nextLine();
                            System.out.println("Input SSN: ");
                            String SSN1 = input.nextLine();
                            System.out.println("Set wage: ");
                            double wage = input.nextDouble();
                            System.out.println("Input hours worked: ");
                            int hours = input.nextInt();
                            list.add(new Hemployee(firstname1, lastname1, SSN1, wage, hours));
                            break;
                        case 3:
                            System.out.println("Input first name: ");
                            String firstname2 = input.nextLine();
                            System.out.println("Input last name: ");
                            String lastname2 = input.nextLine();
                            System.out.println("Input SSN: ");
                            String SSN2 = input.nextLine();
                            System.out.println("Set sales: ");
                            double grosssales = input.nextDouble();
                            System.out.println("Set commission rate: ");
                            double commissionrate = input.nextDouble();
                            list.add(new Cemployee(firstname2, lastname2, SSN2, grosssales, commissionrate));
                            break;
                        case 4:
                            System.out.println("Input first name: ");
                            String firstname3 = input.nextLine();
                            System.out.println("Input last name: ");
                            String lastname3 = input.nextLine();
                            System.out.println("Input SSN: ");
                            String SSN3 = input.nextLine();
                            System.out.println("Set sales: ");
                            double grosssales1 = input.nextDouble();
                            System.out.println("Set commission rate: ");
                            double commissionrate1 = input.nextDouble();
                            System.out.println("Set base salary: ");
                            double basesalary = input.nextDouble();
                            list.add(new BPCemployee(firstname3, lastname3, SSN3, grosssales1, commissionrate1, basesalary));
                            break;
                        default:
                            System.out.println("Error in input.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter employee SSN: ");
                    String SSNc2 = input.nextLine();
                    list.remove(getObj(SSNc2));
                    break;
                case 3:
                    System.out.println("Enter employee SSN: ");
                    String SSNc3 = input.nextLine();
                    if(getObj(SSNc3) instanceof Semployee){
                        System.out.println("Employee "+list.indexOf(getObj(SSNc3))+" is a salaried employee.");
                    }
                    else if(getObj(SSNc3) instanceof Hemployee){
                        System.out.println("Employee "+list.indexOf(getObj(SSNc3))+" is a hourly employee.");
                    }
                    else if(getObj(SSNc3) instanceof Cemployee){
                        System.out.println("Employee "+list.indexOf(getObj(SSNc3))+" is a commission employee.");
                    }
                    else if(getObj(SSNc3) instanceof BPCemployee){
                        System.out.println("Employee "+list.indexOf(getObj(SSNc3))+" is a base plus commission employee.");
                    }
                    break;
                case 4:
                    System.out.println("Enter employee SSN: ");
                    String SSNc4 = input.nextLine();
                    System.out.println(list.get(list.indexOf(getObj(SSNc4))).toString());
                    break;
                case 5:
                    System.out.println("Enter first name: ");
                    String fname = input.nextLine();
                    System.out.println("Enter last name: ");
                    String lname = input.nextLine();
                    System.out.println(list.get(list.indexOf(getObj(fname, lname))).toString());
                    break;
                case 6:
                    System.out.println("Enter employee first name");
                    String fn6 = input.nextLine();
                    System.out.println("Enter employee last name");
                    String ln6 = input.nextLine();
                    for(Employee a: list){
                        if(a instanceof BPCemployee){
                            if((fn6+" "+ln6).equalsIgnoreCase(a.getname())){
                                ((BPCemployee)a).Increment();
                            }    
                        }
                    }
                    break;
                case 7:
                    System.out.println("INCREMENT BASE SALARY FOR ALL BPC EMPLOYEES? (Y/N)");
                    String str = input.nextLine();
                    if(str.equalsIgnoreCase("y")){
                        for(Employee a: list){
                            if(a instanceof BPCemployee){
                                ((BPCemployee)a).Increment();
                            }
                            System.out.println(a.toString());
                            System.out.println("");
                        }
                    }
                    else{
                        for(Employee a: list){
                            System.out.println(a.toString());
                            System.out.println("");
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error in input.");
                    break;
            }
        }
    }
    static Employee getObj(String SSN){
        for(Employee obj: list){
            if(obj.getssn().equals(SSN)){
                return obj;
            }
        }
        return null;
    }
    static Employee getObj(String firstname, String lastname){
        for(Employee obj: list){
            if(obj.getname().equalsIgnoreCase(firstname+" "+lastname)){
                return obj;
            }
        }
        return null;
    }
}    

