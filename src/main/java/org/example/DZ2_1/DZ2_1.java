package org.example.DZ2_1;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DZ2_1 {
    public static void main(String[] args)
    {
        Animal[] animals = new Animal[2];
        animals[0] = new Dog("Джагер", 5, "овчарка");
        animals[1] = new Cat("Барсик", 8, "серый");

        for (Animal animal: animals) {
            Class<?> clazz = animal.getClass();

            System.out.println("Информация о классе: " + clazz.getSimpleName() + ":");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field: fields)
            {
                try
                {
                    field.setAccessible(true);
                    System.out.println("уникальное поле " + field.getName() +": " +  field.get(animal));
                }
                catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("Метод makesound  может делать звук: ");
                Method makeSoundMethod = clazz.getDeclaredMethod("makeSound");
                makeSoundMethod.setAccessible(true);
                makeSoundMethod.invoke(animal);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}