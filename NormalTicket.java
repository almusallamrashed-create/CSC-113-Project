package pckg;

public class NormalTicket extends Ticket {
public NormalTicket(double distance,String id) {
	super(distance,id);
}
public double rideCost() {
	return distance*5;
}
@Override
public Ticket copy() {
	return new NormalTicket(this.getDistance(),this.getId());
}
public String toString() {
	String s = "Ticket " + id + "\n";
	s+= super.toString();
	return s;
}
}
