/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfindingdesu;

import java.util.*;

/**
 *
 * @author Khubaib
 */
public class Graph {
    ArrayList<vertex> adjlist;
    public Graph(){
        adjlist = new ArrayList<vertex>();
    }
    public void AddVertex(String l){
        adjlist.add(new vertex(l));
    }
    public void AddEdge(String l1, String l2){
        int c1 = 0; int c2 = 0;
        for(int i = 0; i<adjlist.size(); i++){
            if(adjlist.get(i).label.equals(l1)){
                c1 = i;
            }
            if(adjlist.get(i).label.equals(l2)){
                c2 = i;
            }
        }
        adjlist.get(c1).L.add(adjlist.get(c2));
        adjlist.get(c2).L.add(adjlist.get(c1));
    }
    public void BFS(){
        Queue Q = new ArrayDeque();
        
    }
}
class vertex{
    String label;
    LinkedList<vertex> L = new LinkedList<vertex>();
    boolean visit = false;
    public vertex(String label){
        this.label = label;
    }
}
