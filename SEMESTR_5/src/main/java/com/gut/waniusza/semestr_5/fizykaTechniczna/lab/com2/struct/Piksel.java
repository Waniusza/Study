/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com2.struct;

/**
 *
 * @author janusz
 */
public class Piksel {

    private double colorIntensity;
    private double shiftX;
    private double shiftY;

    public Piksel(double colorIntensity) {
        this.colorIntensity = colorIntensity;
        this.shiftX = 0;
        this.shiftY = 0;
    }

    public int getColorIntensity() {
        return (int) colorIntensity;
    }

    public void setColorIntensity(double colorIntensity) {
        if (colorIntensity < 255 && colorIntensity > Config.COLOR_INTENCITY_DECREASE) {
            this.colorIntensity = colorIntensity - Math.random() * Config.COLOR_INTENCITY_DECREASE;
        } else if (colorIntensity >= 255) {
            this.colorIntensity = 255;
        } else {
            this.colorIntensity = 0;
        }
    }

    public int getShiftX() {
        return (int) shiftX;
    }

    public int getShiftY() {
        return (int) shiftY;
    }

    public void addShift(double shiftX, double shiftY) {
        this.shiftX += shiftX;
        this.shiftY += shiftY;
    }
}
