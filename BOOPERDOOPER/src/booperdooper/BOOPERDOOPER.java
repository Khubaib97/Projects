/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booperdooper;

import java.util.Scanner;

class Person{
    private String name;
    private String address;
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String toString(){
        return "Person[name = "+name+",address = "+address+"]";
    }
}
class Student extends Person{
    private String program;
    private int year;
    private double fee;
    public Student(String name, String address, String program, int year, double fee){
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }
    public String getProgram(){
        return program;
    }
    public void setProgram(String program){
        this.program = program;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public double getFee(){
        return fee;
    }
    public void setFee(double fee){
        this.fee = fee;
    }
    public String toString(){
        return "Student[Person[name = "+super.getName()+",address = "+super.getAddress()+"],program = "+program+",year = "+year+",fee = "+fee+"]";
    }
}
class Staff extends Person{
    private String school;
    private double pay;
    public Staff(String name, String address, String school, double pay){
        super(name, address);
        this.school = school;
        this.pay = pay;
    }
    public String getSchool(){
        return school;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public double getPay(){
        return pay;
    }
    public void setPay(double pay){
        this.pay = pay;
    }
    public String toString(){
        return "Staff[Person[name = "+super.getName()+",address = "+super.getAddress()+"],school = "+school+",pay = "+pay+"]";
    }
}
/**
 *
 * @author Khubaib
 */
public class BOOPERDOOPER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("HOW MANY NIGGAS?");
        int a = inp.nextInt();
        Person[] psn = new Person[a];
        for(int i = 0; i<psn.length; i++){
            System.out.println("1 FOR STUDENT------2 FOR STAFF");
            int ans = inp.nextInt();
            inp.nextLine();
            if(ans==1){
                System.out.print("Enter name: ");
                String name = inp.nextLine();
                System.out.print("Enter address: ");
                String address = inp.nextLine();
                System.out.print("Enter program: ");
                String program = inp.nextLine();
                System.out.print("Enter year: ");
                int year = inp.nextInt();
                System.out.print("Enter fee: ");
                double fee = inp.nextDouble();
                psn[i] = new Student(name, address, program, year, fee);
            }
            else if(ans==2){
                System.out.print("Enter name: ");
                String name = inp.nextLine();
                System.out.print("Enter address: ");
                String address = inp.nextLine();
                System.out.print("Enter school: ");
                String school = inp.nextLine();
                System.out.print("Enter pay: ");
                double pay = inp.nextDouble();
                psn[i] = new Staff(name, address, school, pay);
            }
        }
        System.out.println("LIST: ");
        for(int i = 0; i<psn.length; i++){
            System.out.println(psn[i].toString());
        }
    }
    
}
