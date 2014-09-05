package be.ticket;

import be.ticket.common.AbstractArquillianTestCase;
import be.ticket.dao.PassengerDAO;
import be.ticket.entity.AbstractEntity;
import be.ticket.entity.Passenger;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static be.ticket.entity.PassengerType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class PassengerTest extends AbstractArquillianTestCase {
    @Inject
    private PassengerDAO dao;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void passengerCanBeSaved() {
        Passenger passenger = new Passenger("Jimi", "Hendrix", "26-11-1968", REGULAR);
        dao.create(passenger);
        assertNotNull(passenger.getId());
    }

    @Test
    public  void  passengerCanBeFound(){
        AbstractEntity passenger = dao.find(1);
        assertEquals((Integer)1, passenger.getId());
    }

    private static Date createDate(String value) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse date", e);
        }
    }
}
