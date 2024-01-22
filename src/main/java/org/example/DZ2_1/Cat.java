package org.example.DZ2_1;

public class Cat extends Animal
{

    public Cat(String name, int age, String color)
    {
        super(name, age);
    }

    @Override
    public void makeSound()
    {
        System.out.println("Мяу");
    }
}