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
public class Graph {
    vertexList hue;
    public Graph(){
        hue = new vertexList();
    }
    public void add_vert(String n, int a){
        hue.addVertex(n, a);
    }
    public void add_edge(String l1, String l2){
        vertex temp = hue.head;
        while(temp!=null){
            if(temp.name.equalsIgnoreCase(l1)){
                break;
            }
            temp = temp.next;
        }
        temp.neighbor.addEdge(hue.findVertex(l2));
    }
    public String toString(){
        return hue.toString();
    }
}
class vertex{
    String name;
    int age;
    vertex next;
    edgeList neighbor = new edgeList();
    public vertex(String a, int b){
        name = a;
        age = b;
    }
    public String toString(){
        return "Name: "+name+"\tAge: "+age;
    }
}
class edge{
    vertex v;
    edge next;
    public edge(vertex v){
        this.v = v;
    }
    public String toString(){
        return v.toString();
    }
}
class vertexList{
    vertex head;
    public vertex findVertex(String l){
        vertex temp = head;
        while(temp!=null){
            if(temp.name.equalsIgnoreCase(l)){
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("Vertex not found.");
        return null;
    }
    public void addVertex(String n, int a){
        if(head==null){
            head = new vertex(n, a);
        }
        else{
            vertex temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new vertex(n, a);
        }
    }
    public String toString(){
        vertex temp = head;
        String s = "";
        System.out.println("List of vertices: ");
        while(temp!=null){
            s += temp.toString()+"\nIts edges: "+temp.neighbor.toString()+"\n";
            temp = temp.next;
        }
        return s;
    }    
}
class edgeList{
    edge head;
    public void addEdge(vertex v){
        if(head==null){
            head = new edge(v);
        }
        else{
            edge temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new edge(v);
        }
    }
    public String toString(){
        String s = "";
        edge temp = head;
        while(temp!=null){
            s += temp.toString();
            temp = temp.next;
        }
        return s;
    }
}
