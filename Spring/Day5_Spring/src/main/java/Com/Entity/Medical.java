package Com.Entity;

import org.springframework.stereotype.Component;

@Component("Doc")
public class Medical implements Carrier{

	@Override
	public String SelectCarrier() {
		return "Choose Doctor";
	}

}
