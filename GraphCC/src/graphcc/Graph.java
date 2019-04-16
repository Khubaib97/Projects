/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcc;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Khubaib
 */
public class Graph {
    vertex[] AdjList;
    int count = 0;
    public Graph(){
        AdjList = new vertex[10];
    }
    public Graph(int s){
        AdjList = new vertex[s];
    }
    public void AddVertex(String l){
        if(count==AdjList.length){
            System.out.println("FUll");
        }
        AdjList[count] = new vertex(l);
        count++;
    }
    public void AddEdge(String l1, String l2){
        int c1 = 0; int c2 = 0;
        for(int i = 0; i<AdjList.length; i++){
            if(AdjList[i].label.equals(l1)){
                c1 = i;
            }
            if(AdjList[i].label.equals(l2)){
                c2 = i;
            }
        }
        AdjList[c1].L.add(AdjList[c2]);
        AdjList[c2].L.add(AdjList[c1]);
    }
    public void DFS(){
        Stack<vertex> s = new Stack<vertex>();
        vertex v = AdjList[0];
        v.visit = true;
        System.out.println(" "+v.label);
        int i;
        while(!s.empty()){
            LinkedList<vertex> l = v.L;
            for(i = 0; i< l.size() && l.get(i).visit != false;){
                i++;
            }
            if(i< l.size() && l.get(i).visit == false){
                l.get(i).visit = true;
                s.push(l.get(i));
                v = l.get(i);
                System.out.println(" "+v.label);
            }
            else{
                v = s.pop();
            }
        }
    }
    public int component(){
        Stack<vertex> s = new Stack<vertex>();
        int i = 0;
        while(i!=AdjList.length){
        vertex v = AdjList[i];
        v.visit = true;
        System.out.println(" "+v.label);
        while(!s.empty()){
            LinkedList<vertex> l = v.L;
            for(i = 0; i< l.size() && l.get(i).visit != false;){
                i++;
            }
            if(i< l.size() && l.get(i).visit == false){
                l.get(i).visit = true;
                s.push(l.get(i));
                v = l.get(i);
                System.out.println(" "+v.label);
            }
            else{
                v = s.pop();
            }
        }
        i++;
        }
        return i;
    }
    public void display(){

    }
}
class vertex{
    String label;
    boolean visit = false;
    LinkedList<vertex> L = new LinkedList<vertex>();
    int component;
    public vertex(String l){
        label = l;
        component = 0;
    }
}
