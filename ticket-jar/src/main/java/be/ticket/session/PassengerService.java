package be.ticket.session;

import be.ticket.dao.PassengerDAO;
import be.ticket.entity.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Anko on 8/30/2014.
 */
@Stateless
@LocalBean
@Named
public class PassengerService implements Serializable{
    @Inject
    PassengerDAO passengerdao;


    public List<Passenger> findAllPassengers() {
        return passengerdao.findAll();
    }

    public Passenger findPassenger(Long id){return passengerdao.find(id);}

    public void createPassenger(Passenger passenger) {
        try {
            passengerdao.create(passenger);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public Passenger updatePassenger(Passenger passenger){
        return passengerdao.update(passenger);
    }

    public void deletePassenger(Passenger passenger) {
        passengerdao.delete(passenger);
    }
}
