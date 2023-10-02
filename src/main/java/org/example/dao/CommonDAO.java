package org.example.dao;

import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;

public class CommonDAO {
    public static void createPrincipalAndSchool(Session session) {
        Principal principal = new Principal("New principal", 30);
        School school = new School(777, principal);
        // for hibernate cash
        principal.setSchool(school);
        // make SQL request
        session.save(principal);
        session.save(school);

        System.out.println(principal + " and " + school + " successfully added to the database.");
    }

    public static void changePrincipal(Session session, String principal_name,int principal_age, int school_id) {
        Principal principal = new Principal(principal_name, principal_age);
        School school = session.get(School.class, school_id);
        System.out.println("Old principal of " + school + " is " + school.getPrincipal());
        session.save(principal);
        school.setPrincipal(principal);
        principal.setSchool(school);
        System.out.println("New principal of " + school + " is " + school.getPrincipal());
    }

    public static void addSecondSchool(Session session, int secondSchoolNumber, int principalId) {
        Principal principal = session.get(Principal.class, principalId);
        School secondScool = new School(secondSchoolNumber, principal);
        // for hibernate cash
        principal.setSchool(secondScool);
        // make SQL request
        session.save(secondScool);
    }
}
