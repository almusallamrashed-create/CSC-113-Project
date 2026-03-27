package Project_phase1;

public class Bus {
private String busCode;
private Ticket [] passengers;
private int currentSize;

public Bus(String id) {
	this.busCode = id;
	this.passengers = new Ticket[120];
	currentSize = 0;
}
public Bus(Bus B) {
	this.busCode = B.busCode;
	for(int i = 0; i < B.currentSize; i++) {
		this.addPassenger(B.passengers[i]);
	}
	this.currentSize = B.currentSize;
}
public String getId() {
	return busCode;
}
public void setId(String id) {
	this.busCode = id;
}
public int getPassCount() {
	return currentSize;
}
public void setPassCount(int passCount) {
	this.currentSize = passCount;
}

public Ticket[] getPassengers() {
	return passengers;
}
public void setPassengers(Ticket[] passengers) {
	this.passengers = passengers;
}
public boolean addPassenger(Ticket T) {
	if(T == null || currentSize>= passengers.length) {
		return false;}
		passengers[currentSize] = T.copy(); 
		currentSize++;
	return true;
}
public Ticket findTicket(String T) {
	for(int i = 0; i < currentSize; i++) {
		if( passengers[i].getId().equals(T)) {
			return passengers[i];
		}
	}
	return null;
}
public boolean delete(String id){
	for(int i = 0; i < currentSize; i++) {
	if(passengers[i].getId().equalsIgnoreCase(id)) {
		for(int j=i;j<currentSize-1;j++) { 
		passengers[j] = passengers[j+1];
		}
		passengers[currentSize - 1]=null;
		currentSize--;
		return true;
	 }
}
	
	return false;
}
public String toString() {
	String s = "Bus: " + busCode;
	for(int i = 0; i < currentSize; i++) {
		s+= "\n----------------- \n";
		s+= i + "-" + passengers[i].toString();
	}
	s+= "\n----------------- \n";
	return s;
}
public double totalRevenue() {
	double TR =0;
	for(int i = 0; i < currentSize; i++) {
		TR += passengers[i].rideCost();
	}
	return TR;
}
public double maxDistance() {
	if(currentSize == 0) {
		return 0;
	}
	Ticket max = passengers[0];
	for(int i = 1; i < currentSize; i++) {
		if(max.getDistance() < passengers[i].getDistance()) {
			max = passengers[i];
		}		
	}
	return max.getDistance();
}

}public boolean addPassenger(Ticket T) {
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
