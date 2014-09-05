package be.ticket.beans;

import be.ticket.entity.Passenger;
import be.ticket.observers.Message;
import be.ticket.session.PassengerService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * Created by top on 1-9-14.
 */

@Named
@RequestScoped
public class PassengerManagerAction {

    @Inject
    private Conversation  conversation;

    @Inject
    private PassengerBean passengerBean;

    @Inject
    PassengerService passengerService;

    @Inject
    Event<Message> event;

    private DataModel<Passenger> passengers;

    @PostConstruct
    public void init() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        reload();
    }

    public DataModel<Passenger> getPassengers(){return passengers;}

    public String createPassenger() {
        passengerService.createPassenger(passengerBean.getPassenger());
        event.fire(new Message(null, "be.ticket.entity.passenger.created"));
        reload();
        return "./passengers.jsf";
    }

   public PassengerBean getPassengerBean(){return passengerBean;}

    public String editPassenger() {
        Passenger passenger = passengers.getRowData();
        passengerBean.setPassenger(passenger);
        return "./passengercreate.jsf";
    }

    public String updatePassenger(){
        passengerService.updatePassenger(passengerBean.getPassenger());
        event.fire(new Message(null, "be.ticket.entity.passenger.updated"));
        reload();
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "./passengers.jsf";
    }

    public String cancel(){
        reload();
        return "./passengers.jsf";
    }

    public void deletePassenger() {
        Passenger passenger = passengers.getRowData();
        passengerService.deletePassenger(passenger);
        event.fire(new Message(null, "be.ticket.entity.passenger.deleted"));
        reload();
    }

    private void reload() {
        passengers = new ListDataModel<Passenger>();
        passengers.setWrappedData(passengerService.findAllPassengers());
    }
}

