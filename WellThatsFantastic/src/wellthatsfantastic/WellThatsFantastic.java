/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wellthatsfantastic;

import java.util.Scanner;

class Well{
    int diskcount;
    Ring[] MANYRINGS;
    Well(double[] hue){
        MANYRINGS = new Ring[hue.length];
        for(int i = 0; i<hue.length; i++){
            MANYRINGS[i] = new Ring(hue[i]);
        }
    }
    void dropdisk(Disk d){
        for(int i = 0; i<MANYRINGS.length; i++){
            if(MANYRINGS[i].filled==false){
                if(i==(MANYRINGS.length-1)){
                    MANYRINGS[i].filled = true;
                    diskcount++;
                    break;
                }
                if(d.diameter>MANYRINGS[i].diameter){
                    if(i==0){
                        break;
                    }
                    MANYRINGS[i-1].filled = true;
                    diskcount++;
                    break;
                }
            }
            else{
                if(i==0){
                    break;
                }
                MANYRINGS[i-1].filled = true;
                diskcount++;
                break;
            }
        }
    }
}
class Ring{
    double diameter;
    boolean filled;
    Ring(){
        diameter = 69;
        filled = false;
    }
    Ring(double diameter){
        this.diameter = diameter;
        filled = false;
    }
}
class Disk{
    double diameter;
    Disk(){
        diameter = 69;
    }
    Disk(double diameter){
        this.diameter = diameter;
    }
}
/**
 *
 * @author Khubaib
 */
public class WellThatsFantastic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("How many rings?");
        int wellsize = inp.nextInt();
        double[] ringsu = new double[wellsize];
        for(int i = 0; i<ringsu.length; i++){
            System.out.println("Enter diameter of ring: ");
            ringsu[i] = inp.nextDouble();
        }
        Well WTF = new Well(ringsu);
        System.out.println("How many disks?");
        int numd = inp.nextInt();
        Disk[] disksu = new Disk[numd];
        for(int i = 0; i<disksu.length; i++){
            System.out.println("Enter diameter of disk: ");
            disksu[i] = new Disk(inp.nextDouble());
        }
        for(int i = 0; i<disksu.length; i++){
            WTF.dropdisk(disksu[i]);
        }
        System.out.println("Disk count is: "+WTF.diskcount);
        //following loop used to better understand filled status
        /*for(int i = 0; i<WTF.MANYRINGS.length; i++){
            System.out.println(WTF.MANYRINGS[i].filled);
        }*/
    }
    
}
