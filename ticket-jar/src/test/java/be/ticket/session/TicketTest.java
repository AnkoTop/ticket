package be.ticket.session;

import be.ticket.common.AbstractArquillianTestCase;

import be.ticket.dao.TicketDAO;
import be.ticket.entity.Ticket;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by Anko on 8/28/2014.
 */
@RunWith(Arquillian.class)
public class TicketTest extends AbstractArquillianTestCase{
    @Inject
    TicketDAO daoT;

    @Test
    public void testListTicketsOnDod(){
       List<Ticket> tickets = daoT.findTicketsByDateOfDeparture(new Date());
        for (Ticket ticket : tickets) {
            System.out.println("Passenger" + ticket.getPassenger().getFirstName() + " don't forget your flight on " + ticket.getDateOfDeparture());
        }
    }
}
