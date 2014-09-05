package be.ticket.beans;

import be.ticket.entity.Airline;
import be.ticket.observers.Message;
import be.ticket.session.AirlineService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Created by Anko on 8/30/2014.
 */
@Named
@RequestScoped
public class AirlineManagerAction {

    @Inject
    private Conversation conversation;

    @Inject
    private AirlineBean airlineBean;

    @Inject
    AirlineService airlineService;

    @Inject
    Event<Message> event;

    private DataModel<Airline> airlines;

    @PostConstruct
    public void init() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        reload();
    }

    public DataModel<Airline> getAirlines(){return airlines;}

    public String createAirline() {
        airlineService.createAirline(airlineBean.getAirline());
        event.fire(new Message(null, "be.ticket.entity.airline.created"));
        reload();
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "airlines?faces-redirect=true";
    }

    public String editAirline() {
        Airline airline = airlines.getRowData();
        airlineBean.setAirline(airline);
        return "airlinecreate";
    }

    public String updateAirline(){
        airlineService.updateAirline(airlineBean.getAirline());
        event.fire(new Message(null, "be.ticket.entity.airline.updated"));
        reload();
        if (!conversation.isTransient()) {
            conversation.end();
        }
        return "airlines?faces-redirect=true";
    }


    public String cancel(){
        reload();
        return "airlines?faces-redirect=true";
    }

    public void deleteAirline(){
        Airline airline = airlines.getRowData();
        airlineService.deleteAirline(airline);
        event.fire(new Message(null, "be.ticket.entity.airline.deleted"));
        reload();
    }

    public AirlineBean getAirlineBean() {
        return airlineBean;
    }

    public boolean isAirlinesEmpty() {
        return airlines != null ? airlines.getRowCount() == 0 : true;
    }

    private void reload() {
        airlines = new ListDataModel<Airline>();
        airlines.setWrappedData(airlineService.findAllAirlines());
    }

}