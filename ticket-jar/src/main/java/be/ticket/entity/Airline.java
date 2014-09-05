package be.ticket.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by Anko on 8/29/2014.
 */

@XmlRootElement
@Entity
public class Airline extends AbstractEntity {
    private static final long serialVersionUID = -334444415999348L;

    private String company;

    public Airline(){super();}

    public Airline(String company) {
        super();
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }


}
