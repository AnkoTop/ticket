package be.ticket.beans;

import be.ticket.entity.Flight;
import be.ticket.entity.Passenger;
import be.ticket.entity.Ticket;
import be.ticket.observers.Message;
import be.ticket.session.FlightService;
import be.ticket.session.PassengerService;
import be.ticket.session.TicketRegistrationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by top on 2-9-14.
 */
@Named
@ConversationScoped
public class TicketManagerAction implements Serializable {

    @Inject
    private Conversation conversation;

    @Inject
    private TicketRegistrationService ticketRegistrationService;

    @Inject
    private FlightService flightService;

    @Inject
    private PassengerService passengerService;


    @Inject @Dependent
    private PassengerBean passengerBean;

    @Inject @Dependent
    private FlightBean flightBean;

    @Inject
    private TicketBean ticketBean;

    private DataModel<Passenger> passengers;
    private DataModel<Flight> flights;
    private DataModel<Ticket> tickets;

    @Inject
    Event<Message> event;


    @PostConstruct
    public void init() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        reload();
    }

    public DataModel<Passenger> getPassengers(){return passengers;}

    public DataModel<Flight> getFlights(){return flights;}

    public DataModel<Ticket> getTickets(){return tickets;}

    public void setPassenger(){
        Passenger passenger = passengers.getRowData();
        passengerBean.setPassenger(passenger);

    }
    public void setFlight(){
        Flight flight = flights.getRowData();
        flightBean.setFlight(flight);
    }

    public String createTicket(){
        ticketBean.setTicketPassenger(passengerBean.getPassenger());
        ticketBean.setTicketFlight(flightBean.getFlight());
        ticketRegistrationService.createTicket( ticketBean.getTicket());
        event.fire(new Message(null, "be.ticket.entity.ticket.created"));
        reload();
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "tickets?faces-redirect=true";
    }

    public String cancel() {
        ticketRegistrationService.cancel();
        reload();
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "tickets?faces-redirect=true";
    }

    public PassengerBean getPassengerBean() { return passengerBean;}

    public FlightBean getFlightBean(){return flightBean;}

    public TicketBean getTicketBean(){return ticketBean;}

    private void reload() {
        flights = new ListDataModel<Flight>();
        flights.setWrappedData(flightService.findAllFlights());
        passengers = new ListDataModel<Passenger>();
        passengers.setWrappedData(passengerService.findAllPassengers());
        tickets = new ListDataModel<Ticket>();
        tickets.setWrappedData(ticketRegistrationService.findAllTickets());
    }

}
