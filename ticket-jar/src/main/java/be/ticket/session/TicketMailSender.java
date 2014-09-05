package be.ticket.session;

import be.ticket.dao.TicketDAO;
import be.ticket.entity.Ticket;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Anko on 8/28/2014.
 */

@Stateless
public class TicketMailSender {
    @Inject
    TicketDAO daoT;

    @Schedule(hour = "0", minute = "0", second = "0/30", persistent = false)
    public void sendMail() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
            List<Ticket> ticketsToday = daoT.findTicketsByDateOfDeparture(dateWithoutTime);
            Calendar c = Calendar.getInstance();
            c.setTime(dateWithoutTime);
            c.add(Calendar.DATE, 7);
            dateWithoutTime = sdf.parse(sdf.format(c.getTime()));
            List<Ticket> tickets = daoT.findTicketsByDateOfDeparture(dateWithoutTime);
            for (Ticket ticket : tickets) {
                System.out.println("\nDear " + ticket.getPassenger().getFirstName() + ",");
                System.out.println("Don't forget your flight on " + sdf.format(dateWithoutTime) + " as you paid " + ticket.getPrice() + " $ for it!");
                System.out.println("Have a good flight,\nThe Team.\n");
            }
            if (tickets.isEmpty()){
                System.out.println("\nNo emails to send for tickets valid on " + sdf.format(dateWithoutTime));

            }
            System.out.println(tickets.size()+ " tickets valid for this date.");
            System.out.println("\nFor today there are " + ticketsToday.size() + " valid tickets sold.\n");
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
