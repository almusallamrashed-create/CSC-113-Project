package Project_phase1;

// VIP ticket gets discount if distance is more than 10
public class VIPTicket extends NormalTicket implements Discounts {
    
    public VIPTicket(double travelDistance, String ticketNumber, String bookingDate) {
        super(travelDistance, ticketNumber, bookingDate);
    }
    
    public double rideCost() {
        return travelDistance * 7.5 * applyDiscount();
    }
    
    // check discount based on distance
    public double applyDiscount() {
        if(travelDistance > 10) {
            return 0.8; // 20% discount
        }
        return 1;
    }
    
    @Override
    public Ticket copy() {
        return new VIPTicket(this.getDistance(), this.getId(), this.getBookingDate());
    }
    
    public String toString() {
        String s = "VIP ";
        s += super.toString();
        return s;
    }
}
