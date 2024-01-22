package org.example.DZ4_1.Hibernate;

import org.hibernate.Session;
import org.example.DZ4_1.UI.ConsoleView;
import org.example.DZ4_1.Models.Course;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateActions {
    private static final ConsoleView cv = new ConsoleView();
    public static void insertData(Session session) {
        Course course = new Course(cv.inputTitle(), cv.inputDuration());

        session.beginTransaction();

        session.save(course);
        System.out.println("Object course save successfully");

        session.getTransaction().commit();
        System.out.println("Transaction commit successfully");


    }

    private static Course readData (Session session){

        Course retrievedCourse = session.get(Course.class, cv.inputID());
        System.out.println(retrievedCourse);
        System.out.println("Object course retrieved successfully");

        System.out.println("Retrieved course object: " + retrievedCourse);
        return retrievedCourse;
    }

    public static void updateTitle(Session session){
        session.beginTransaction();

        Course retrievedCourse = readData(session);
        retrievedCourse.setTitle(cv.inputTitle());
        session.update(retrievedCourse);
        System.out.println("Object course update successfully");

        session.getTransaction().commit();
        System.out.println("Transaction commit successfully");
    }

    public static void updateDuration(Session session){
        session.beginTransaction();

        Course retrievedCourse = readData(session);
        retrievedCourse.setDuration(cv.inputDuration());
        session.update(retrievedCourse);
        System.out.println("Object course update successfully");

        session.getTransaction().commit();
        System.out.println("Transaction commit successfully");
    }

    public static void deleteData (Session session){
        session.beginTransaction();

        Course retrievedCourse = readData(session);
        session.delete(retrievedCourse);
        System.out.println("Object course delete successfully");

        session.getTransaction().commit();
        System.out.println("Transaction commit successfully");
    }

    public static void showCourses(Session session) {
        session.beginTransaction();
        List<Course> courses = findAllCourses(session);

        session.getTransaction().commit();
        System.out.println("Transaction commit successfully");

        for (var course : courses){
            System.out.println(course);
        }
    }

    private static List<Course> findAllCourses(Session session) {

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> rootEntry = cq.from(Course.class);
        CriteriaQuery<Course> all = cq.select(rootEntry);

        TypedQuery<Course> allQuery = session.createQuery(all);

        return allQuery.getResultList();
    }
}
