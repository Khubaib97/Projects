/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potato;
class Circle{
    double radius;
    double area;
    Circle(){
        radius = 69;
        area = 3.14*radius*radius;
    }
    Circle(double JEWradius){
        radius = JEWradius;
        area = 3.14*radius*radius;
    }
    double getArea(){
        return area;
    }
}
/**
 *
 * @author Khubaib
 */
public class Potato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle o1 = new Circle(76);
        System.out.println(o1.radius);
        System.out.println(o1.getArea());
    }
    
}
