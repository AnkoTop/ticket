package be.ticket.entity;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Flight extends AbstractEntity {
    private static final long serialVersionUID = -334034115999348L;
    private String number;


    /**
     * Used by JPA.
     */
    public Flight() {
    }

    public Flight(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
