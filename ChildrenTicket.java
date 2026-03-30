package Project_phase1;

// ticket for kids
public class ChildrenTicket extends NormalTicket {
    
    public ChildrenTicket(double travelDistance, String ticketNumber, String bookingDate) {
        super(travelDistance, ticketNumber, bookingDate);
    }
    
    // cost is cheaper for children
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
