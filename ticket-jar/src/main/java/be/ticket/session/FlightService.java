package be.ticket.session;

import be.ticket.dao.FlightDAO;
import be.ticket.entity.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by top on 2-9-14.
 */
@Stateless
@LocalBean
@Named
public class FlightService implements Serializable {
    @Inject
    FlightDAO flightDAO;

    public List<Flight> findAllFlights(){return flightDAO.findAll();}

    public  Flight findFlight(Long id){return flightDAO.find(id);}

    public void createFlight(Flight flight) {
        try {
            flightDAO.create(flight);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public Flight updateFlight(Flight flight) {
        return flightDAO.update(flight);
    }

    public void deleteFlight(Flight flight) {flightDAO.delete(flight);}
}
