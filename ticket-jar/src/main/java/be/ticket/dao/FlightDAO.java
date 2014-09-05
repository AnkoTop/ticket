package be.ticket.dao;


import be.ticket.entity.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Anko on 8/28/2014.
 */

@Stateless
@LocalBean
@Named
public class FlightDAO extends AbstractDAO<Flight> {

    public List<Flight> findAll(){
        return em.createQuery("select f from Flight f", Flight.class).getResultList();
    }
}
