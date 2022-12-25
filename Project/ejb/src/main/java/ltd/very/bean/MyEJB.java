package ltd.very.bean;

import javax.ejb.Stateless;

@Stateless
public class MyEJB {

	public String echo(String words) {
		return "You said: " + words;
	}

}
