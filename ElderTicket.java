package pckg;

public class ElderTicket extends NormalTicket implements Discounts{
private int age;
public ElderTicket(double distance,String id, int age) {
	super(distance,id);
	this.age = age;
}
public double rideCost() {
	return Math.ceil( distance*4.5*applyDiscount()*100) / 100.0;
}
public double applyDiscount() {
	return (double) 50/age;
}
@Override
public Ticket copy() {
	return new ElderTicket(this.getDistance(),this.getId(),this.getAge());
}
public String toString() {
	String s = "Elder ";
	s+= super.toString();
	return s;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
}
