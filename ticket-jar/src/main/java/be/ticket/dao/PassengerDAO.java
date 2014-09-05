package be.ticket.dao;

import be.ticket.entity.Passenger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.List;

@Stateless
@LocalBean
@Named
public class PassengerDAO extends AbstractDAO<Passenger>{

    public List<Passenger> findAll(){
        return em.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

}

