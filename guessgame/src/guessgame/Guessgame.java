/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessgame;
import java.util.Scanner;
/**
 *
 * @author Khubaib
 */
public class Guessgame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int a = (int)(Math.random()*50);
        int b = -1; int count = 0;
        while(b!=a){
            if(count==5){
                System.out.println("Game over.");
                break;
            }
            System.out.print("Enter your guess: ");
            b = inp.nextInt();
            if(b>a)
                System.out.println("Guess too high.");
            if(b<a)
                System.out.println("Guess too low.");
            if(b==a){
                System.out.println("Correct.");
                break;
            }
            count++;
            System.out.println((5-count)+" guesses left.");
        }
    }
    
}
