package entities;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class EntityTested {
    public static void main(String[] args) {
        Customer c1 = new Customer("Jesper", "hej", new Date());
        Customer c2 = new Customer("Ermin", "hi", new Date());
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();
        System.out.println("The person got this new id: " +
                c1.getId());
        System.out.println("The person got this new id: " +
                c2.getId());
        Facade facade = new Facade();
        facade.findByID(1L);
        facade.findByLastName("hej");
      //  facade.getNumberOfCustomers();
        facade.addCustomer("Per", "nej");
        facade.allCustomers();
        em.close();
        emf.close();
    }

}

