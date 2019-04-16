/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphu;

/**
 *
 * @author Khubaib
 */
public class Graphu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = new Graph();
        g.add_vert("Khubaib", 20);
        g.add_vert("Ali", 20);
        g.add_vert("Faizan", 21);
        g.add_edge("Ali", "Faizan");
        g.add_edge("Khubaib", "Ali");
        g.add_edge("Faizan", "Ali");
        System.out.println(g.toString());
    }
    
}
