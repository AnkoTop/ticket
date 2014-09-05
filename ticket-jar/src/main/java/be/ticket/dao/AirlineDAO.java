package be.ticket.dao;

import be.ticket.entity.Airline;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Anko on 8/29/2014.
 */

@Stateless
@LocalBean
@Named
public class AirlineDAO extends AbstractDAO<Airline>{

    public List<Airline> findAll(){
        return em.createQuery("select a from Airline a", Airline.class).getResultList();
    }
}
