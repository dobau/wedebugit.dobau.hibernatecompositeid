package it.wedebug.dobau.embeddedid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Exemplo {

    public static void main(String[] args) {
        try {

            Client joao = new Client();
            joao.getId().setFirstName("Joao");
            joao.getId().setLastName("Alves");
            joao.setAge(15);

            Client maria = new Client();
            maria.getId().setFirstName("Maria");
            maria.getId().setLastName("Oliveira");
            maria.setAge(20);

            Client jose = new Client();
            jose.getId().setFirstName("Jose");
            jose.getId().setLastName("Silva");
            jose.setAge(40);

            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-embeddedid.cfg.xml")
                .buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(joao);
            session.save(maria);
            session.save(jose);
            session.getTransaction().commit();
            session.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
