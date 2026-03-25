public class Bus {
private String id;
private Ticket [] passengers;
private int passCount;

public Bus(String id) {
	this.id = id;
	this.passengers = new Ticket[120];
	passCount = 0;
}
public Bus(Bus B) {
	this.id = B.id;
	for(int i = 0; i < B.passCount; i++) {
		this.addPassenger(B.passengers[i]);
	}
	this.passCount = B.passCount;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getPassCount() {
	return passCount;
}
public void setPassCount(int passCount) {
	this.passCount = passCount;
}

public Ticket[] getPassengers() {
	return passengers;
}
public void setPassengers(Ticket[] passengers) {
	this.passengers = passengers;
}
public boolean addPassenger(Ticket T) {
	if(T == null || passCount>= passengers.length) {
		return false;}
		passengers[passCount] = T.copy(); //composition
	passCount++;
	return true;
}
public Ticket findTicket(String T) {
	for(int i = 0; i < passCount; i++) {
		if( passengers[i].getId().equals(T)) {
			return passengers[i];
		}
	}
	return null;
}
public boolean delete(String id){
	for(int i = 0; i < passCount; i++) {
	if(passengers[i].getId().equalsIgnoreCase(id)) {
		for(int j=i;j<passCount;j++)  
		passengers[j] = passengers[j+1];
		passengers[j-1]=null;
		passCount--;
		return true;
	 }
	}
	return false;
}
public String toString() {
	String s = "Bus: " + id;
	for(int i = 0; i < passCount; i++) {
		s+= "\n----------------- \n";
		s+= i + "-" + passengers[i].toString();
	}
	s+= "\n----------------- \n";
	return s;
}
public double totalRevenue() {
	double TR =0;
	for(int i = 0; i < passCount; i++) {
		TR += passengers[i].rideCost();
	}
	return TR;
}
public double maxDistance() {
	if(passCount == 0) {
		return 0;
	}
	Ticket max = passengers[0];
	for(int i = 1; i < passCount; i++) {
		if(max.getDistance() < passengers[i].getDistance()) {
			max = passengers[i];
		}		
	}
	return max.getDistance();
}

}
