package Project_phase1;

// ticket for older people with age discount
public class ElderTicket extends NormalTicket implements Discounts {
    private int age;
    
    public ElderTicket(double travelDistance, String ticketNumber, String bookingDate, int age) {
        super(travelDistance, ticketNumber, bookingDate);
        this.age = age;
    }
    
    // calculate cost and round it
    public double rideCost() {
        return Math.ceil(travelDistance * 4.5 * applyDiscount() * 100) / 100.0;
    }
    
    // discount formula based on age
    public double applyDiscount() {
        return (double) 50 / age;
    }
    
    @Override
    public Ticket copy() {
        return new ElderTicket(this.getDistance(), this.getId(), this.getBookingDate(), this.getAge());
    }
    
    public String toString() {
        String s = "Elder ";
        s += super.toString();
        return s;
    }
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
