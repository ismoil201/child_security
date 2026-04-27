package com.example.childsecurity.model;

public class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }
    public static void main(String[] args) {

        Cat cat = new Cat("Tom");
        System.out.println(cat.name+" Tom is a cat . It is white and has a tail");
    }



    Cat cat2 = new Cat("Tom");


}
