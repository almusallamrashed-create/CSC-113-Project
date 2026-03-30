package Project_phase1;

public class NormalTicket extends Ticket {
public NormalTicket(double travelDistance,String ticketNumber,String bookingDate) {
	super(travelDistance,ticketNumber,bookingDate);
}
public double rideCost() {
	return travelDistance*5;
}
@Override
public Ticket copy() {
	return new NormalTicket(this.getDistance(),this.getId(),this.getBookingDate());
}
public String toString() {
	String s = "Ticket " + ticketNumber + "\n";
	s+= super.toString();
	return s;
}
}
