package Com.Entity;

import org.springframework.stereotype.Component;

@Component("Eng")
public class Enginnering implements Carrier{

	@Override
	public String SelectCarrier() {
		return "Choose Computer Science";
	}
	
	

}
