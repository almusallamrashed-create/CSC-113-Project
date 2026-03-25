package pckg;

public class ChildrenTicket extends NormalTicket{
	public ChildrenTicket(double distance,String id) {
		super(distance,id);
	}
	public double rideCost() {
		return distance*3;		
	}
	
	@Override
	public Ticket copy() {
		return new ChildrenTicket(this.getDistance(),this.getId());
	}
	public String toString() {
		String s = "Children ";
		s+= super.toString();
		return s;
	}
	}