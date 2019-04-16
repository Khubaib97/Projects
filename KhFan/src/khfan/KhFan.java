/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khfan;
class Fan{
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    Fan(){
        speed = SLOW;
        on = false;
        radius = 5;
        color = "blue";
    }
    public void setSpeed(int spd){
        switch (spd){
            case SLOW:
                speed = SLOW;
                break;
            case MEDIUM:
                speed = MEDIUM;
                break;
            case FAST:
                speed = FAST;
                break;
            default:
                System.out.println("Not a valid option.");
                break;
        }
    }
    public String getSpeed(){
        switch (speed){
            case 1:
                return "Speed is set to slow.";
            case 2:
                return "Speed is set to medium.";
            case 3:
                return "Speed is set to fast.";
            default:
                return "Error.";
        }
    }
    public void TurnOn(){
        on = true;
    }
    public void TurnOff(){
        on = false;
    }
    public String getOnState(){
        if(on==true){
            return "Fan is on.";
        }
        else{
            return "Fan is off.";
        }
    }
    public void setRadius(double rad){
        radius = rad;
    }
    public double getRadius(){
        return radius;
    } 
    public void setColor(String clr){
        color = clr;
    }
    public String getColor(){
        return color;
    }
    public String toString(){
        if(on==true){
            switch (speed){
                case 1:
                    return "Speed is set to slow. Radius is set to "+radius+" and color is "+color+".";
                case 2:
                    return "Speed is set to medium. Radius is set to "+radius+" and color is "+color+".";
                case 3:
                    return "Speed is set to fast. Radius is set to "+radius+" and color is "+color+".";
                default:
                    return "Error.";
            }
        }
        else{
            return "Fan is off. Radius is set to "+radius+" and color is "+color+".";
        }
    }
}
/**
 *
 * @author Khubaib
 */
public class KhFan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.TurnOn();
        Fan fan2 = new Fan();
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.TurnOff();
        System.out.println("FAN 1: ");
        System.out.println(fan1.toString());
        System.out.println("FAN 2: ");
        System.out.println(fan2.toString());
    }
    
}
