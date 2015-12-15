package com.gut.waniusza.semestr_5.oojp.col_5;

/**
 *
 * @author student
 */
public class Pen implements Movable {
    private double x;
    private double y;

    public Pen(){
        this.x = 0.0;
        this.y = 0.0;
    }
    
    public Pen(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void setX(double x){
        this.x = x;
    }
    
    @Override
    public void setY(double y){
        this.y = y;
    }
    
    @Override
    public double getX(){
        return this.x;
    }
    
    @Override
    public double getY(){
        return this.y;
    }

    @Override
    public void move(double deltaX, double deltaY) {
        this.x -= deltaX;
        this.y -= deltaY;
    }
    
    public String toString(){
        return "Pen("+x+", "+y+")";
    }       }