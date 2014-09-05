package be.ticket.session;

import be.ticket.common.AbstractArquillianTestCase;
import be.ticket.dao.FlightDAO;
import be.ticket.dao.PassengerDAO;
import be.ticket.entity.Flight;
import be.ticket.entity.Passenger;
import be.ticket.entity.PassengerType;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by Anko on 8/28/2014.
 */
@RunWith(Arquillian.class)
public class TicketRegistrationTest extends AbstractArquillianTestCase {

    @Inject
    TicketRegistrationEJB ticketregistration;

    @Inject
    PassengerDAO daoP;

    @Inject
    FlightDAO daoF;
    
   @Test
    public void TicketRegistrationSimple() {

       Passenger passenger = new Passenger("test","Persoon", "10-10-2008", PassengerType.REGULAR);
       daoP.save(passenger);
       Flight flight = new Flight("AT001");
       daoF.save(flight);
       ticketregistration.selectPassenger(passenger.getId());
       ticketregistration.selectFlight(flight.getId());
       ticketregistration.bookTicket(125.00,new Date());


   }



}
