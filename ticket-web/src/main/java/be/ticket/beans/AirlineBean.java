package be.ticket.beans;

import be.ticket.entity.Airline;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import java.io.Serializable;


/**
 * Created by Anko on 8/29/2014.
 */
@Named
@ConversationScoped
public class AirlineBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Airline airline = new Airline();

    public Airline getAirline(){return airline;}

    public void setAirline(Airline airline){this.airline = airline;}

    public boolean isManaged() {
        return airline.getId() != null;
    }
}
