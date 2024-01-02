package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

public class DZ1_1 {
    public static void main(String[] args) {
        // Создаем первоначальный список
        List<Double> listNumber = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            double x = ran.nextDouble(10);
            listNumber.add(Math.ceil(x));
        }

        // Выводим на экран первоначальный список
        System.out.println("Список чисел: " + listNumber);

        // Выделяем из списка четные числа
        List<Double> listNumber1 = listNumber.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Список четных чисел: " + listNumber1);

        // Считаем среднее значение всех четных чисел
        OptionalDouble averageValue = listNumber1.stream().mapToInt(Double::intValue).average();
        System.out.println("Среднее значение: " + averageValue.getAsDouble());
    }
}