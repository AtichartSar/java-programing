/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author Ozero
 */
public class Demo {
    public static void main(String[] args) {
        car c=new car();
        c.setColor("yellow");
        c.setModel("sport");
        c.setSpeed(60);
        
        Honda h=new Honda();
        h.setColor("bronze");
        h.setEngineType("fast");
        h.setModel("sport");
        h.setSpeed(300);
    }
}


class Honda extends car{
    private String engineType;

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
// class แม่
class car{
    private int speed;
    private String color;
    private String model;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
}
