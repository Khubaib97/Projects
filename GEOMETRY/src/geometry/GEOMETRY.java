/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import java.util.ArrayList;

class GeometricObject{
    private String color;
    private boolean filled;
    private java.util.Date dateCreated;
    public GeometricObject(){
        dateCreated = new java.util.Date();
        color = "white";
        filled = false;
    }
    public GeometricObject(String color, boolean filled){
        this.color = color;
        this.filled = filled;
        dateCreated = new java.util.Date();
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    public String toString(){
        return dateCreated+"Color is "+color+". IsFilled: "+filled+".";
    }
}
class Circle extends GeometricObject{
    private double radius;
    public Circle(){
        super();
        radius = 69;
    }
    public Circle(double radius){
        super();
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    public double getDiameter(){
        return 2*radius;
    }
    public void printCircle(){
        System.out.println(super.toString()+"Radius of circle is: "+radius+".");
    }
}
class Rectangle extends GeometricObject{
    private double width;
    private double height;
    public Rectangle(){
        super();
        width = 69;
        height = 69;
    }
    public Rectangle(double width, double height){
        super();
        this.width = width;
        this.height = height;
    }
    public Rectangle(double width, double height, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.height = height;
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;
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
public class GEOMETRY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<GeometricObject> list = new ArrayList<GeometricObject>();
    }
    public void displayGeometricObject(Object ob){
        
    }
}
