package be.ticket.beans;

import be.ticket.entity.Flight;
import be.ticket.observers.Message;
import be.ticket.session.FlightService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by top on 2-9-14.
 */
@Named
@RequestScoped
public class FlightManagerAction {
    @Inject
    private Conversation conversation;

    @Inject
    private FlightBean flightBean;

    @Inject
    FlightService flightService;

    @Inject
    Event<Message> event;

    private DataModel<Flight> flights;

    @PostConstruct
    public void init() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        reload();
    }

    public DataModel<Flight> getFlights(){return flights;}

    public String createFlight(){
        flightService.createFlight(flightBean.getFlight());
        event.fire(new Message(null, "be.ticket.entity.flight.created"));
        reload();
        return "flights?faces-redirect=true";
    }

    public String editFlight() {
        Flight flight = flights.getRowData();
        flightBean.setFlight(flight);
        return "flightcreate";
    }

    public String updateFlight(){
        flightService.updateFlight(flightBean.getFlight());
        event.fire(new Message(null, "be.ticket.entity.flight.updated"));
        reload();
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "flights?faces-redirect=true";
    }

    public void deleteFlight(){
        Flight flight = flights.getRowData();
        flightService.deleteFlight(flight);
        event.fire(new Message(null, "be.ticket.entity.flight.deleted"));
        reload();
    }

    public String cancel(){
        reload();
        return "./flights.jsf";
    }

    public FlightBean getFlightBean(){return flightBean;}

    private void reload() {
        flights = new ListDataModel<Flight>();
        flights.setWrappedData(flightService.findAllFlights());
    }
}
