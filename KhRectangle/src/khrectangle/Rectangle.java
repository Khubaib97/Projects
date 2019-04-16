/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khrectangle;
public class Rectangle implements java.io.Serializable{
    public double width;
    public double height;
    public Rectangle(){
        width = 1;
        height = 1;
    }
    public Rectangle(double w, double h){
        width = w;
        height = h;
    }
    public double getArea(){
        return width*height;
    }
    public double getPerimeter(){
        return width+width+height+height;
    }
}
/**
 *
 * @author Khubaib
 */
class KhRectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle(4, 40);
        System.out.println("RECTANGLE 1: ");
        System.out.println("Width: "+rec1.width);
        System.out.println("Height: "+rec1.height);
        System.out.println("Area: "+rec1.getArea());
        System.out.println("Perimeter: "+rec1.getPerimeter());
        Rectangle rec2 = new Rectangle(3.5, 35.9);
        System.out.println("RECTANGLE 2: ");
        System.out.println("Width: "+rec2.width);
        System.out.println("Height: "+rec2.height);
        System.out.println("Area: "+rec2.getArea());
        System.out.println("Perimeter: "+rec2.getPerimeter());
    }
    
}
