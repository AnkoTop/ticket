package be.ticket.dao;

import be.ticket.entity.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anko on 8/28/2014.
 */

@Stateless
@LocalBean
@Named
public class TicketDAO extends AbstractDAO<Ticket> {

    public List<Ticket> findTicketsByDateOfDeparture(Date dateOfDeparture) {
        TypedQuery<Ticket> query = em.createQuery("select t from Ticket t where t.dateOfDeparture = :dod",Ticket.class);
        query.setParameter("dod" ,dateOfDeparture);
        return query.getResultList();
}
}
