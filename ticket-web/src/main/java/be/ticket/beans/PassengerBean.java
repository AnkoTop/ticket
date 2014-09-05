package be.ticket.beans;

import be.ticket.entity.Passenger;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Anko on 8/29/2014.
 */

@Named
@ConversationScoped
public class PassengerBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private Passenger passenger = new Passenger();

    public Passenger getPassenger(){return passenger;}

    public void setPassenger(Passenger passenger){this.passenger = passenger;}

    public boolean isManaged() {
        return passenger.getId() != null;
    }
}
