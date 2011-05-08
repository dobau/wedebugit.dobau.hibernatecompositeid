package it.wedebug.dobau.idclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Exemplo {

    public static void main(String[] args) {
        try {

            Client joao = new Client();
            joao.setFirstName("Joao");
            joao.setLastName("Alves");
            joao.setAge(15);

            Client maria = new Client();
            maria.setFirstName("Maria");
            maria.setLastName("Oliveira");
            maria.setAge(20);

            Client jose = new Client();
            jose.setFirstName("Jose");
            jose.setLastName("Silva");
            jose.setAge(40);

            SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-idclass.cfg.xml")
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
