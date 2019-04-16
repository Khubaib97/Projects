/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coo;
class course{
    private String name;
    private String[] students = new String[3];
    private int numberOfStudents;
    public course(){
        name = "BIG BOX BARRY.";
        numberOfStudents = 0;
    }
    public course(String name){
        this.name = name;
        numberOfStudents = 0;
    }
    public String getName(){
        return name;
    }
    public void addStudent(String student){
        if(numberOfStudents<students.length){
            students[numberOfStudents] = student;
            numberOfStudents += 1;
        }
        else{
            System.out.println("COURSE FULL GTFO");
        }
    }
    public String[] getStudents(){
        return students;
    }
    public int getNumberOfStudents(){
        return numberOfStudents;
    }
}
/**
 *
 * @author Khubaib
 */
public class Coo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        course c1 = new course("OOP");
        System.out.println(c1.getName());
        c1.addStudent("khewbabe");
        c1.addStudent("Khubaib");
        c1.addStudent("khoobaib");
        c1.addStudent("uzair");
        String[] arr = c1.getStudents();
        for(int i = 0; i<c1.getNumberOfStudents(); i++){
            System.out.println(arr[i]);
        }
    }
    
}
