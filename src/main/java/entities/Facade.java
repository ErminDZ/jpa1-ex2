package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Facade {
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();

    Customer findByID(long id) {
        Customer c = em.find(Customer.class,id);
        System.out.println("hej" + c);
        return c;
    }

    List<Customer> findByLastName(String name) {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c  WHERE c.lastName = :lastName ", Customer.class);
        query.setParameter("lastName",name);
        List<Customer> result = query.getResultList();
        System.out.println("All persons with lastName = " + result);
        return result;
    }

    //int getNumberOfCustomers()

    List<Customer> allCustomers() {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> result = query.getResultList();
        System.out.println("All customer " + result);
        return result;
    }

    Customer addCustomer(String fName, String lName) {
        Customer customer = new Customer();

        try {
            em.getTransaction().begin();
            customer.setFirstName(fName);
            customer.setLastName(lName);
            em.persist(customer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        System.out.println("You have created a new Customer : " + customer);
        return customer;
    }

}
