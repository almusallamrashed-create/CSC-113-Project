package pckg;

public class VIPTicket extends NormalTicket implements Discounts {
	public VIPTicket(double distance, String id) {
		super(distance,id);
	}
	public double rideCost() {
		return distance*7.5*applyDiscount() ;
	}
	public double applyDiscount() {
		if(distance > 10) {
			return 0.8;
		}
		return 1;
	}
	@Override
	public Ticket copy() {
		return new VIPTicket(this.getDistance(),this.getId());
	}
	public String toString() {
		String s = "VIP ";
		s+= super.toString();
		return s;
	}
	}


