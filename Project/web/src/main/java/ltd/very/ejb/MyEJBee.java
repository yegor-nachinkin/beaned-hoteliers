package ltd.very.ejb;

import ltd.very.bean.MyEJB;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.annotation.PostConstruct;

import java.io.Serializable;

// @Stateful(mappedName="stateful77")
// @StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
@Stateless
public class MyEJBee implements Serializable {

    @EJB
    private MyEJB myEJB;

    private String message;
    // private int counter; // just for statefulness :-)
 
    /*
    @PostConstruct
    private void initialize(){
      counter = 0;
    }

    public void resetCounter(){
      counter = 0;
    }
    */

    public void beanEcho(String wrds) {
        // counter++;
        message = myEJB.echo(wrds);
	}

    public String getEcho() {
        // return message + " (" + String.valueOf(counter) + ")";
        return message;
    }

}
