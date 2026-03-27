package Project_phase1;

public abstract class Ticket implements Trackable {
    protected double travelDistance;
    protected String ticketNumber;
    private String bookingDate;
    
    public Ticket(double travelDistance, String ticketNumber, String bookingDate) {
        this.travelDistance = travelDistance;
        this.ticketNumber = ticketNumber;
        this.bookingDate = bookingDate;
    }
    public String getId() {
        return ticketNumber;
    }
    public void setId(String id) {
        this.ticketNumber = id;
    }
    public Ticket(Ticket T) {
        this.travelDistance = T.getDistance();
        this.ticketNumber = T.getId();
        this.bookingDate = T.getBookingDate();
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
    public abstract Ticket copy();
    
    public abstract double rideCost(); 
    public String toString() {
        return "Ticket No: " + ticketNumber + " | Date: " + bookingDate + "\nDistance is " + travelDistance + "Km \nRide cost is: " + rideCost() + " SAR";
    }
    public String getTrackingInfo() {
        return "Tracking Ticket [" + ticketNumber + "] booked on: " + bookingDate;
    }
}
