/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gut.waniusza.semestr_5.oojp.col_2;

/**
 *
 * @author student
 */
public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        Car sport = new SportsCar();
        Car family = new FamilyCar();

        car.drive();
        car.stop();
        sport.drive();
        sport.stop();
        family.drive();
        family.stop();
    }

    private static class Car {
        public void stop() {
            System.out.println("A car is stopping.");
        }
        public void drive() {
            System.out.println("A car is driving.");
        }
    }

    private static class SportsCar extends Car {

        @Override
        public void stop() {
            System.out.println("A sport car is stopping.");
        }

        @Override
        public void drive() {
            System.out.println("A sport car is driving.");
        }
    }

    private static class FamilyCar extends Car {

        @Override
        public void stop() {
            System.out.println("A family car is stopping.");
        }

        @Override
        public void drive() {
            System.out.println("A family is driving.");
        }
    }
}
