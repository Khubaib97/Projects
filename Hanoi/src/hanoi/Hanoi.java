/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

/**
 *
 * @author Khubaib
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    static void Recursive_Tower(int n, String A, String B, String C){
        if(n==1){
            System.out.println(A+"--->"+B);
        }
        else{
            Recursive_Tower(n-1, A, C, B);
            System.out.println(A+"--->"+B);
            Recursive_Tower(n-1, C, B, A);
        }
    }
    public static void main(String[] args) {
        Recursive_Tower(4, "A", "B", "C");
    }
    
}
