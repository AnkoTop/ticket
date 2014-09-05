package be.ticket.session;

import be.ticket.dao.AirlineDAO;
import be.ticket.entity.Airline;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Anko on 8/30/2014.
 */
@Stateless
@LocalBean
@Named
public class AirlineService {
    @Inject
    AirlineDAO airlinedao;


    public List<Airline> findAllAirlines() {
        return airlinedao.findAll();
    }

    public Airline findAirline(Long id) {
        return airlinedao.find(id);
    }

    public void createAirline(Airline airline) {
        try {
            airlinedao.create(airline);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public Airline updateAirline(Airline airline) {
        return airlinedao.update(airline);
    }

    public void deleteAirline(Airline airline) {airlinedao.delete(airline);}
}

