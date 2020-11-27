package practice;

public class Car01 {
	public int num;
	public String name;
	
	public void drive(String name) {
		System.out.println(this.name+"달려요");
	}
	
	public void stop(int num) {
		System.out.println("멈춰요");
		this.num=num;
	}
}
