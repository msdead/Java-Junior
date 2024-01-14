package org.example.DZ2_1;

public abstract class Animal
{
    public String name;
    public int age;

    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public abstract void makeSound();

}