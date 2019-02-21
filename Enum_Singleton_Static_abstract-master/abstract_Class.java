/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author Ozero
 */
public class abstract_Class {

    public static void main(String[] args) {
        MyGraphics cir = new MyCircle(5, 5, 5);
        MyGraphics rec = new MyRectangle(5, 5, 3, 4);
        System.out.println("area " + cir.findArea());
        System.out.println("xy " + cir.getX() + "," + cir.getY());
        System.out.println("area " + rec.findArea());
        System.out.println("xy " + rec.getX() + "," + rec.getY());
        cir.move(50, 50);
        System.out.println("xy cir  " + cir.getX() + "," + cir.getY());
        cir.move(cir, 30, 20);
        System.out.println("xy cir " + cir.getX() + "," + cir.getY());
        MyGraphics.move(cir, 10, 30);
        System.out.println("xy cir  " + cir.getX() + "," + cir.getY());
    }
}

//supper-class
abstract class MyGraphics {

    private int x;
    private int y;

    public MyGraphics() {
    }

    public MyGraphics(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(); //abstract method

    public abstract double findArea(); //abstract method

    public void move(int x, int y) {//concremethod
        this.setX(x);
        this.setY(y);
    }
      public static void move(MyGraphics gra,int x, int y) {//concremethod
        gra.setX(x);
        gra.setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

//sub-class
class MyCircle extends MyGraphics {

    private double radius;

    public MyCircle(double radius, int x, int y) {
        super(x, y);
        this.radius = radius;
    }

    public MyCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
    }

    @Override
    public double findArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}

class MyRectangle extends MyGraphics {

    private double width;
    private double height;

    public MyRectangle(double width, double height, int x, int y) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public MyRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
    }

    @Override
    public double findArea() {
        return width * height;
    }

}
