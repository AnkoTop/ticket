package be.ticket.session;


import be.ticket.dao.FlightDAO;
import be.ticket.dao.PassengerDAO;
import be.ticket.dao.TicketDAO;
import be.ticket.entity.Flight;
import be.ticket.entity.Passenger;
import be.ticket.entity.Ticket;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by Anko on 8/28/2014.
 */
@Stateful
@StatefulTimeout(value = 30, unit = TimeUnit.MINUTES)
@Named
public class TicketRegistrationService implements Serializable {
    @Inject
    TicketDAO ticketDAO;

    public List<Ticket> findAllTickets(){return ticketDAO.findAll();}

    public void createTicket(Ticket ticket){

        ticketDAO.create(ticket);

    }

    @Remove
    public void cancel(){
        //Remove bean after cancellation of the bookingprocess
    }
}
