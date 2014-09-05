package be.ticket.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Passenger extends AbstractEntity {
    private static final long serialVersionUID = -21544459999348L;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    //@Temporal(TemporalType.DATE)
    private String birthDate;

    @Enumerated(EnumType.STRING)
    private PassengerType type;

    /**
     * Used by JPA.
     */
    public Passenger() {super();
    }

    public Passenger(String firstName, String lastName, String birthDate, PassengerType type) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.type = type;
    }

    public Passenger(String firstName, String lastName, String birthDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Passenger(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PassengerType getType() {
        return type;
    }
}
