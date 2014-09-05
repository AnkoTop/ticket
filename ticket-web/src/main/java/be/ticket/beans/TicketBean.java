package be.ticket.beans;

import be.ticket.entity.Flight;
import be.ticket.entity.Passenger;
import be.ticket.entity.Ticket;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by top on 3-9-14.
 */

@Named
@ConversationScoped
public class TicketBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private Ticket ticket = new Ticket();

    public Ticket getTicket(){return ticket;}

    public void setTicket(Ticket ticket){this.ticket = ticket;}

    public void setTicketPassenger(Passenger passenger){this.ticket.setPassenger(passenger);}

    public void  setTicketFlight(Flight flight){this.ticket.setFlight(flight);}

    public boolean isManaged() {
        return ticket.getId() != null;
    }
}
