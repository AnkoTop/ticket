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
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by Anko on 8/28/2014.
 */
@Stateful
@StatefulTimeout(value = 30, unit = TimeUnit.MINUTES)
@Named
public class TicketRegistrationEJB {
    @Inject
    TicketDAO daoTicket;
    @Inject
    PassengerDAO daoPassenger;
    @Inject
    FlightDAO daoFlight;

    private Passenger passenger;

    private Flight flight;

    //select a passenger
    public void selectPassenger(Long id){ passenger = (Passenger) daoPassenger.find(id);}

    //select a flight
    public void selectFlight(Integer id){flight = daoFlight.find(id);}

    //book a ticket for date of departure

    @Remove
    public void bookTicket(double price, Date DateOfDeparture){
        Ticket ticket = new Ticket(price, DateOfDeparture);
        ticket.setPassenger(passenger);
        ticket.setFlight(flight);
        daoTicket.save(ticket);
    }
}
