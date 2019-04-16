/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customexception;

class Circle{
    double radius;
    Circle(){
        System.out.println("CHIKCEN NUGGER");
    }
    Circle(double radius) throws InvalidRadiusException{    
        if(radius <= 0){
            throw new InvalidRadiusException();
        }
        else{
            System.out.println("Valid input, thank you.");
            this.radius = radius;
        }
    }
}
class InvalidRadiusException extends Exception{
    InvalidRadiusException(){
        System.out.println("INVALID RADIUS.");
    }
}
/**
 *
 * @author Khubaib
 */
public class CustomException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws InvalidRadiusException {
        
            Circle c = new Circle(-5);
       
 
    }
    
}
