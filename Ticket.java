package pckg;

public abstract class Ticket{
protected double distance;
protected String id;
public Ticket(double distance,String code) {
	this.distance = distance;
	this.id = code;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Ticket(Ticket T) {
	this.setDistance(T.getDistance());
	this.setId(T.getId());
}
public double getDistance() {
	return distance;
}
public void setDistance(double distance) {
	this.distance = distance;
}

public abstract Ticket copy();
public abstract double rideCost(); 

public String toString() {
	return "Distance is " + distance + "Km \n" + "Ride cost is: " + rideCost() + " SAR";
}
}
