/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchengine;

/**
 *
 * @author Khubaib
 */
public class SearchEngine {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SearchList a = new SearchList();
        a.insert("Asia","Wiki.com");
        a.insert("asia","iba.edu.pk");
        a.insert("asia","ibm.com");
        a.insert("Karachi","lums.com");
        a.insert("admission","wikipedia.com");
        a.insert("karachi","iba.com");
        a.insert("karachi","yahoo.com");
        a.insert("admission","nust.edu.pk");
        a.insert("admission","yahoo.com");
        System.out.println(a.toString());
        a.search("asia");
        System.out.println("");
    }
    
}
