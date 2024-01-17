package org.example.DZ3_1;

import java.io.*;

public class DZ3_1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student students1 = new Student("Павел ", 18, 4.6);
        Student students2 = new Student("Александр", 19, 4.7);
        System.out.println("\nСтудент 1: " + students1 + "\nСтудент 2: " + students2);

        try (FileOutputStream fileOutputStream = new FileOutputStream("student.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(students1);
            System.out.println("\nСтудент 1 сериализован");
            objectOutputStream.writeObject(students2);
            System.out.println("Студент 2 сериализован");
        }
        try (FileInputStream fileInputStream = new FileInputStream("student.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            students1 = (Student)objectInputStream.readObject();
            System.out.println("\nСтудент 1 десериализован");
            students2 = (Student)objectInputStream.readObject();
            System.out.println("Студент 2 десериализован");
        }
        System.out.println("\nСтудент 1: ");
        System.out.println("Имя: " + students1.getName());
        System.out.println("Возраст: " + students1.getAge());

        // "transient" - это модификатор переменных, который используется для сериализации
        // во время сериализации, если мы не хотим сохранять значение определенной переменной
        // в файле, используем ключевое слово "transient"

        System.out.println("Средний балл (null, так как transient): " + students1.getGPA());

        System.out.println("\nСтудент 2: ");
        System.out.println("Имя: " + students2.getName());
        System.out.println("Возраст: " + students2.getAge());
        System.out.println("Средний балл (null, так как transient): " + students2.getGPA());
    }
}