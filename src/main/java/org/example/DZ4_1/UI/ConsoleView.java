package org.example.DZ4_1.UI;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in, StandardCharsets.UTF_8);
    }

    public int inputDuration() {
        System.out.print("Введите длительность курса в часах: ");
        return in.nextInt();
    }

    public String inputTitle() {
        System.out.print("Введите название курса: ");
        return in.next();
    }

    public int inputID() {
        System.out.print("Введите ID: ");
        return in.nextInt();
    }

    public int menu() {
        System.out.println(
                """
                1 - Вставка данных
                2 - Чтение данных
                3 - Изменение названия курса
                4 - Изменение продолжительности курса
                5 - Удаление курса
                0 - закрыть приложение
                """
        );
        System.out.print("Введите номер действия: ");
        return in.nextInt();
    }
}
