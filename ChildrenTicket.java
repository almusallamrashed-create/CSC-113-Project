package Project_phase1;

public class ChildrenTicket extends NormalTicket {
	public ChildrenTicket(double travelDistance, String ticketNumber, String bookingDate) {
		super(travelDistance, ticketNumber, bookingDate);
	}
	public double rideCost() {
		return travelDistance * 3;		
	}
	
	@Override
	public Ticket copy() {
		return new ChildrenTicket(this.getDistance(), this.getId(), this.getBookingDate());
	}
	public String toString() {
		String s = "Children ";
		s += super.toString();
		return s;
	}
}
