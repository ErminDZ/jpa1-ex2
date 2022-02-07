package entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class Customer {
    @GeneratedValue
    @Id
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Date created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", created=" + created +
                '}';
    }
}
