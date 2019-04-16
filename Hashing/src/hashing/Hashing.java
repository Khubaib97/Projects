/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

/**
 *
 * @author Khubaib
 */
public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable<Student> lel = new HashTable(20);
        Student std = new Student(234, "asad", "gulshan block 3");
        Student std1 = new Student(334, "saad", "jauhar block 1");
        Student std2 = new Student(221, "uzair", "gulshan");
        Student std3 = new Student(007, "izaor", "jauhar");
        lel.insert(std2, std2.ID);
        lel.insert(std3, std3.ID);
        lel.insert(std, std.ID);
        lel.insert(std1, std1.ID);
        lel.displayTable();
    }
    
}
