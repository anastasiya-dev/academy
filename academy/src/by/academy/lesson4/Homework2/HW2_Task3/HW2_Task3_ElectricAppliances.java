package by.academy.lesson4.Homework2.HW2_Task3;

public abstract class HW2_Task3_ElectricAppliances implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double price = 0;
	boolean switchOn;
	int [] capacity = {0, 0, 0};
	
	public HW2_Task3_ElectricAppliances() {
		super();
		System.out.println("***");
		setCapacity(capacity);
		setPrice(price);
		switchOn = false;
	}
	
	protected boolean changeMode() {
		if (switchOn == true) {
			switchOn = false;			
		}
		else {
			switchOn = true;
		}
		return switchOn;
	}
		
	public void getSwitch() {
		if (switchOn == true) {
			System.out.println("Switched on!");
		}
		else {			
			System.out.println("Switched off!");
		}
	}
	
	protected void setCapacity(int [] capacity) {
		this.capacity = capacity;		
	}
	
	public int [] getCapacity() {
		return capacity;
	}
	
	protected void setPrice(double price) {
		this.price = price;	
	}
	
	public double getPrice() {
		return price;
	}
	
	public void info() {
		System.out.println("--------------------");
		System.out.println("This is an item of electric appliances");
		System.out.println("The price is " + getPrice());
		System.out.print("The capacity (W, V, Hz) is: ");
		for (int i = 0; i < 3; i++) {
			System.out.print(getCapacity()[i] + " ");
		}
		System.out.println("\n");
		System.out.println("--------------------");
	}
}
