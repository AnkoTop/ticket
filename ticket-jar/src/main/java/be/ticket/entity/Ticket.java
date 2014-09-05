package be.ticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({ @NamedQuery(name = Ticket.FIND_TICKETS_BY_DATEOFDEPARTURE, query = "select t from Ticket t where t.dateOfDeparture = :dateOfDeparture") })
public class Ticket extends AbstractEntity {

    public static final String FIND_TICKETS_BY_DATEOFDEPARTURE = "Ticket.findTicketsByDateOfDeparture";

    private double price;

    private String dateOfDeparture;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    /**
     * Used by JPA.
     */
    public Ticket() {
    }

    public Ticket(double price, String dateOfDeparture) {
        this.price = price;
        this.dateOfDeparture = dateOfDeparture;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPassenger(Passenger p) {
        this.passenger = p;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }
}
