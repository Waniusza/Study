package com.gut.waniusza.semestr_5.oojp;

public class Cat {

    public String name;
    public int age;

    public static void main(String[] args) {
        Cat cat = new Cat("Mruczek", 0);
        System.out.println("I'm a young cat, I'm " + cat.getAge() + " years old");
        System.out.println("I'm a young cat named :" + cat.getName());
        cat.setAge(cat.getAge() + 1);
        cat.setName("Mrucz");
        System.out.println("I'm a adult cat, I'm " + cat.getAge() + " years old");
        System.out.println("I'm a adult cat, now I'm named :" + cat.getName());

        cat.itsBirthday();
        cat.setName("Mruk");
        System.out.println("I'm a senior cat, I'm already " + cat.getAge() + " years old");
        System.out.println("I'm a senior cat, now people called me :" + cat.getName());
    }

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public void itsBirthday() {
        this.age ++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
