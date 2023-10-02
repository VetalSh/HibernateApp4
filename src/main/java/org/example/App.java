package org.example;

import org.example.dao.CommonDAO;
import org.example.dao.PrincipalDAO;
import org.example.dao.SchoolDAO;
import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This is small app which demonstrate using Hibernate
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        PrincipalDAO principalDAO = new PrincipalDAO();
        SchoolDAO schoolDAO = new SchoolDAO();
        CommonDAO commonDAO = new CommonDAO();

        try {
            session.beginTransaction();

            System.out.println("~~~ Get principal by id ~~~");
            principalDAO.getPrincipal(session, 3);

            System.out.println("~~~ Get school (principal id is input data) ~~~");
            principalDAO.getSchool(session, 3);

            System.out.println("~~~ Get school by id ~~~");
            schoolDAO.getSchool(session, 3);

            System.out.println("~~~ Get principal (school id is input data) ~~~");
            schoolDAO.getPrincipal(session, 3);

            System.out.println("~~~ Create a new principal and a new school ~~~");
//            commonDAO.createPrincipalAndSchool(session);

            System.out.println("~~~ Change the principal of a school ~~~");
            String principalName = "Test_Principal";
            int principalAge = 50;
//            commonDAO.changePrincipal(session, principalName, principalAge, 5);

            System.out.println("~~~ Add a second school to the existing principal and analyze the error ~~~");
//            commonDAO.addSecondSchool(session, 25, 7);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
