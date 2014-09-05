package be.ticket;

import be.ticket.common.AbstractArquillianTestCase;
import be.ticket.dao.AirlineDAO;
import be.ticket.entity.Airline;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Anko on 8/30/2014.
 */
@RunWith(Arquillian.class)
public class AirlineTest extends AbstractArquillianTestCase {
    @Inject
    private AirlineDAO dao;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void AirlineCanBeSaved(){
        Airline airline = new Airline("KLM");
        dao.create(airline);
        assertNotNull(airline.getId());
    }
}
