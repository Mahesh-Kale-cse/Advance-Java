package Com.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Autowired
	@Qualifier("Eng")
	Carrier Enginnering;
	
	@Autowired
	@Qualifier("Doc")
	Carrier Doctor;

	public Carrier getEnginnering() {
		return Enginnering;
	}

	public void setEnginnering(Carrier enginnering) {
		Enginnering = enginnering;
	}

	public Carrier getDoctor() {
		return Doctor;
	}

	public void setDoctor(Carrier doctor) {
		Doctor = doctor;
	}

	@Override
	public String toString() {
		return "Student [Enginnering=" + Enginnering + ", Doctor=" + Doctor + "]";
	}
	
	

}
