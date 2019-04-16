/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rehash;

/**
 *
 * @author Khubaib
 */
public class ReHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable f1 = new HashTable(6);
        HashTable f2 = new HashTable(6);
        f1.insert("Cat", 0); f2.insert("Cat", 1);
        f1.insert("Batman", 0); f2.insert("Batman", 1);
        f1.insert("And", 0); f2.insert("And", 1);
        f1.insert("If", 0); f2.insert("If", 1);
        f1.insert("Oggy", 0); f2.insert("Oggy", 1);
        f1.insert("Hamza", 0); f2.insert("Hamza", 1);
        f1.insert("Khubaib", 0); f2.insert("Khubaib", 1);
        f1.displayTable();
        System.out.println("-----------------------------");
        f2.displayTable();
    }
    
}
