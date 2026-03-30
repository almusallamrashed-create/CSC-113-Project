package Project_phase1;

// abstract class for all ticket types
public abstract class Ticket implements Trackable {
    protected double travelDistance;
    protected String ticketNumber;
    private String bookingDate; // date of the booking
    
    // constructor
    public Ticket(double travelDistance, String ticketNumber, String bookingDate) {
        this.travelDistance = travelDistance;
        this.ticketNumber = ticketNumber;
        this.bookingDate = bookingDate;
    }
    
    // copy constructor
    public Ticket(Ticket t) {
        this.travelDistance = t.getDistance();
        this.ticketNumber = t.getId();
        this.bookingDate = t.getBookingDate();
    }
    
    // getters and setters
    public String getId() {
        return ticketNumber;
    }
    public void setId(String id) {
        this.ticketNumber = id;
    }
    public double getDistance() {
        return travelDistance;
    }
    public void setDistance(double distance) {
        this.travelDistance = distance;
    }
    public String getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    // abstract methods
    public abstract Ticket copy();
    public abstract double rideCost(); 
    
    // print ticket info
    public String toString() {
        return "Ticket No: " + ticketNumber + " | Date: " + bookingDate + "\nDistance is " + travelDistance + "Km \nRide cost is: " + rideCost() + " SAR";
    }
    
    // from Trackable interface
    public String getTrackingInfo() {
        return "Tracking Ticket [" + ticketNumber + "] booked on: " + bookingDate;
    }
}    
    public abstract double rideCost(); 
    public String toString() {
        return "Ticket No: " + ticketNumber + " | Date: " + bookingDate + "\nDistance is " + travelDistance + "Km \nRide cost is: " + rideCost() + " SAR";
    }
    public String getTrackingInfo() {
        return "Tracking Ticket [" + ticketNumber + "] booked on: " + bookingDate;
    }
}
