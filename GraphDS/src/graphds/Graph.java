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
public class Graph {
    Vertex[] v_list;
    int adjMat[][];
    public Graph(int s){
        v_list = new Vertex[s];
        adjMat = new int[s][s];
    }
    public void addVertex(String l){
        int count = 0;
        while(v_list[count]!=null){
            count++;
        }
        v_list[count] = new Vertex(l);
    }
    public int findVertex(String l){
        for(int i = 0; i<v_list.length; i++){
            if(v_list[i].label.compareTo(l)==0){
                return i;
            }
        }
        return -5;
    }
    public void addEdge(String l1, String l2){
        int one = findVertex(l1);
        int two = findVertex(l2);
        adjMat[one][two] = 1;
        adjMat[two][one] = 1;
    }
    public void display(){
            System.out.print("\t");
        for(int i = 0; i<v_list.length; i++){
            System.out.print(v_list[i].label+"\t");
        }
          System.out.println("");
        for(int i = 0; i<v_list.length; i++){
            System.out.print(v_list[i].label+"\t");
            for(int j = 0; j<v_list.length; j++){
                System.out.print(adjMat[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
class Vertex{
    String label;
    public Vertex(String l){
        label = l;
    }
}
