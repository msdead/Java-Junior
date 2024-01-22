package org.example.DZ4_1.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.DZ4_1.UI.ConsoleView;
import org.example.DZ4_1.Models.Course;

public class Program {

    private static final ConsoleView cv = new ConsoleView();

    public static void main(String[] args) {

        // Создание фабрики сессий
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        while (true) {
            // Создание сессии
            try (Session session = sessionFactory.getCurrentSession()) {
                switch (cv.menu()) {
                    // Вставка данных
                    case 1 -> HibernateActions.insertData(session);
                    // Чтение данных
                    case 2 -> HibernateActions.showCourses(session);
                    // Изменение названия курса
                    case 3 -> HibernateActions.updateTitle(session);
                    // Изменение продолжительности курса
                    case 4 -> HibernateActions.updateDuration(session);
                    // Удаление данных
                    case 5 -> HibernateActions.deleteData(session);
                    // Закрытие приложения
                    case 0 -> System.exit(0);
                    default -> System.out.println("Некорректный ввод");
                }
            }
        }
    }
}
