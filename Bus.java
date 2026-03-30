package Project_phase1;

// bus class holds an array of tickets
public class Bus implements Trackable {
    private String busCode;
    private Ticket[] passengers;
    private int currentSize; // number of passengers

    public Bus(String id) {
        this.busCode = id;
        this.passengers = new Ticket[120]; // max capacity 120
        this.currentSize = 0;
    }
    
    // copy constructor
    public Bus(Bus b) {
        this.busCode = b.busCode;
        this.passengers = new Ticket[120];
        for(int i = 0; i < b.currentSize; i++) {
            this.addPassenger(b.passengers[i]);
        }
        this.currentSize = b.currentSize;
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
    
    // add a new ticket to the bus
    public boolean addPassenger(Ticket t) {
        if(t == null || currentSize >= passengers.length) {
            return false;
        }
        passengers[currentSize] = t.copy(); // deep copy
        currentSize++;
        return true;
    }
    
    // find ticket by id
    public Ticket findTicket(String id) {
        for(int i = 0; i < currentSize; i++) {
            if(passengers[i].getId().equals(id)) {
                return passengers[i];
            }
        }
        return null; // not found
    }
    
    // delete ticket and shift elements
    public boolean delete(String id) {
        for(int i = 0; i < currentSize; i++) {
            if(passengers[i].getId().equalsIgnoreCase(id)) {
                // shift left
                for(int j = i; j < currentSize - 1; j++) { 
                    passengers[j] = passengers[j+1];
                }
                passengers[currentSize - 1] = null;
                currentSize--;
                return true;
            }
        }
        return false;
    }
    
    public String toString() {
        String s = "Bus: " + busCode;
        for(int i = 0; i < currentSize; i++) {
            s += "\n----------------- \n";
            s += i + "-" + passengers[i].toString();
        }
        s += "\n----------------- \n";
        return s;
    }
    
    // calculate total money from this bus
    public double totalRevenue() {
        double tr = 0;
        for(int i = 0; i < currentSize; i++) {
            tr += passengers[i].rideCost();
        }
        return tr;
    }
    
    // find the max distance passenger
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
    
    public String getTrackingInfo() {
        return "Tracking Bus [" + busCode + "] - Total Passengers " + currentSize;
    }
}	this.passengers = passengers;
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
public String getTrackingInfo() {
	return "Tracking Bus [" + busCode + "] - Total Passengers " + currentSize;
}

}
