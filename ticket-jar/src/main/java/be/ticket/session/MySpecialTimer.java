package be.ticket.session;

import javax.ejb.Schedule;
import javax.ejb.Stateless;


/**
 * Created by Anko on 8/28/2014.
 */

@Stateless
public class MySpecialTimer {
    int counter = 0;

    @Schedule(second="0/2", minute = "0", hour="0", persistent = false)
    public void showPeriodicMessage(){

        counter = counter + 2;
        System.out.println(counter);
    }
}
