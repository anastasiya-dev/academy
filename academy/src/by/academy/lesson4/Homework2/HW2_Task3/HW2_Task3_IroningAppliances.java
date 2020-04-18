package by.academy.lesson4.Homework2.HW2_Task3;

public class HW2_Task3_IroningAppliances extends HW2_Task3_ElectricAppliances {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double maxTemp = 0;
	int heatSettings = 0;
	
	public HW2_Task3_IroningAppliances() {
		super();
		setMaxTemp (maxTemp);
		setHeatSettings(heatSettings);
	}
		
	protected void setMaxTemp (double maxTemp) {
		this.maxTemp = maxTemp;	
	}
	
	public double getMaxTemp() {
		return maxTemp;
	}
	
	protected void setHeatSettings(int heatSettings) {
		this.heatSettings = heatSettings;	
	}
	
	public int getHeatSettings() {
		return heatSettings;
	}
	
	@Override
	public void info() {
		System.out.println("--------------------");
		System.out.println("This is an item of ironing appliances");
		System.out.println("The price is " + getPrice());
		System.out.print("The capacity (W, V, Hz) is: ");
		for (int i = 0; i < 3; i++) {
			System.out.print(getCapacity()[i] + " ");
		}
		System.out.println("\n");
		System.out.println("There are " + getHeatSettings() + " heat settings available");
		System.out.println("The maximum temperature is " + getMaxTemp() + " degrees");
		System.out.println("--------------------");
	}
}
