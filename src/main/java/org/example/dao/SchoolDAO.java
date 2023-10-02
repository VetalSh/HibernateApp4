package org.example.dao;

import org.example.model.School;
import org.hibernate.Session;

public class SchoolDAO {
    public static void getSchool(Session session, int id) {
        School school = session.get(School.class, id);
        System.out.println(school);
    }

    public static void getPrincipal(Session session, int id) {
        School school = session.get(School.class, id);
        System.out.println(school.getPrincipal());
    }
}
