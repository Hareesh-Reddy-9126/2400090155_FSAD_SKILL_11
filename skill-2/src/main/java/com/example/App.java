package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static void main(String[] args) {

        createStudent();
        readStudent();
        updateStudent();
        deleteStudent();

        factory.close();
    }

    // CREATE
    public static void createStudent() {
        Session session = factory.openSession();
        session.beginTransaction();

        Student s = new Student(11, "Sai1 Prasad", 95);
        session.persist(s);

        session.getTransaction().commit();
        session.close();

        System.out.println("Student Created");
    }

    // READ
    public static void readStudent() {
        Session session = factory.openSession();

        Student s = session.get(Student.class, 11);
        if (s != null) {
            System.out.println("Student Found:");
            System.out.println(s.getId() + " " + s.getName() + " " + s.getMarks());
        } else {
            System.out.println("Student Not Found");
        }

        session.close();
    }

    // UPDATE
    public static void updateStudent() {
        Session session = factory.openSession();
        session.beginTransaction();

        Student s = session.get(Student.class, 11);
        if (s != null) {
            s.setMarks(95);
            s.setName("Sai Prasad Updated");
            session.merge(s);
        }

        session.getTransaction().commit();
        session.close();

        System.out.println("Student Updated");
    }

    // DELETE
    public static void deleteStudent() {
        Session session = factory.openSession();
        session.beginTransaction();

        Student s = session.get(Student.class, 11);
        if (s != null) {
            session.remove(s);
        }

        session.getTransaction().commit();
        session.close();

        System.out.println("Student Deleted");
    }
}