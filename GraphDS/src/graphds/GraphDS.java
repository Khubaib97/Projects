/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphds;

/**
 *
 * @author Khubaib
 */
public class GraphDS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "D");
        g.display();
    }
    
}
