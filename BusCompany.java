package Project_phase1;

public class BusCompany {
	private String name;
	private Bus [] busses;
	private int busCount;
public BusCompany(String name, int num) {
	this.name = name;
	busses = new Bus[num];
	busCount=0;
}
public boolean addBus(Bus B) {
	if(busCount < busses.length) {
		busses[busCount] = B; 
		busCount++;
		return true;
	}
	return false;
}
public Bus findBus(String id) {
    return findBusRecursive(id, 0);
}

private Bus findBusRecursive(String id, int index) {
    if(index >= busCount) {
        return null;
    }
    if(busses[index].getId().equals(id)) {
        return busses[index];
    }
    return findBusRecursive(id, index + 1);
}
public boolean delete(String id){
	for(int i = 0; i < busCount; i++) {
		if(busses[i].getId().equals(id)) {
			for(int j = i; j < busCount - 1; j++) {
				busses[j] = busses[j+1];
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
