package Project_phase1;

// company class manages all buses
public class BusCompany {
    private String name;
    private Bus[] busses;
    private int busCount;
    
    public BusCompany(String name, int num) {
        this.name = name;
        this.busses = new Bus[num];
        this.busCount = 0;
    }
    
    // add bus to the array
    public boolean addBus(Bus b) {
        if(busCount < busses.length) {
            busses[busCount] = b; 
            busCount++;
            return true;
        }
        return false;
    }
    
    // start the recursive search
    public Bus findBus(String id) {
        return findBusRecursive(id, 0);
    }

    // recursive method to find a bus
    private Bus findBusRecursive(String id, int index) {
        if(index >= busCount) {
            return null; // base case: not found
        }
        if(busses[index].getId().equals(id)) {
            return busses[index]; // base case: found
        }
        return findBusRecursive(id, index + 1); // recursive step
    }
    
    // delete bus and shift
    public boolean delete(String id) {
        for(int i = 0; i < busCount; i++) {
            if(busses[i].getId().equals(id)) {
                for(int j = i; j < busCount - 1; j++) {
                    busses[j] = busses[j+1];
                }
                busses[busCount - 1] = null;
                busCount--;
                return true;
            }
        }
        return false;
    }
    
    public String toString() {
        String s = "Bus Company: " + name + "\n";
        for(int i = 0; i < busCount; i++) {
            s += i + "-Bus: " + busses[i].getId() + "   Capacity: (" + busses[i].getPassCount() + "/" + busses[i].getPassengers().length +") - Total revenue made: " + busses[i].totalRevenue() + " SAR - Max travel distance " + busses[i].maxDistance() + "Km.\n";
        }
        return s;
    }
}				busses[j] = busses[j+1];
			}
			busses[busCount-1] = null;
			busCount--;
			return true;
		}
	}
	return false;
}
public String toString() {
	String s = "Bus Company: " + name +"\n";
	for(int i = 0; i < busCount; i++) {
		s+= i + "-Bus: " + busses[i].getId() + "   Capacity: (" + busses[i].getPassCount() + "/" + busses[i].getPassengers().length +") -" + " Total revenue made: " + busses[i].totalRevenue() + " SAR -" + " Max travel distance " + busses[i].maxDistance() + "Km.";
		s+= "\n";
	}
	return s;
}

}
