package be.ticket.beans;

import be.ticket.dao.FlightDAO;
import be.ticket.entity.Flight;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Anko on 8/29/2014.
 */

@Named
@ConversationScoped
public class FlightBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private Flight flight = new Flight();

    public Flight getFlight(){return flight;}

    public void setFlight(Flight flight){this.flight = flight;}

    public boolean isManaged() {
        return flight.getId() != null;
    }
}
