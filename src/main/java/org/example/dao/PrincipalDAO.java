package org.example.dao;

import org.example.model.Principal;
import org.hibernate.Session;

public class PrincipalDAO {
    public static void getPrincipal(Session session, int id) {
        Principal principal = session.get(Principal.class, id);
        System.out.println(principal);
    }

    public static void getSchool(Session session, int id) {
        Principal principal = session.get(Principal.class, id);
        System.out.println(principal.getSchool());
    }

}
