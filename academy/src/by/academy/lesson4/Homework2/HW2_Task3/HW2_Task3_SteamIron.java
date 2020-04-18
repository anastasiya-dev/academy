package by.academy.lesson4.Homework2.HW2_Task3;

public class HW2_Task3_SteamIron extends HW2_Task3_IroningAppliances implements Portable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double height = 0;
	double waterTankSize = 0;
	
	public HW2_Task3_SteamIron() {
		super();
		setHeight(height);
		setWaterTankSize(waterTankSize);
	}
	
	protected void setHeight(double height) {
		this.height = height;	
	}
	
	public double getHeight() {
		return height;		
	}
	
	protected void setWaterTankSize(double waterTankSize) {
		this.waterTankSize = waterTankSize;	
	}
	
	public double getWaterTankSize() {
		return waterTankSize;		
	}
	
	@Override
	public void info() {
		System.out.println("--------------------");
		System.out.println("This is a steam iron");
		System.out.println("The price is " + getPrice());
		System.out.print("The capacity (W, V, Hz) is: ");
		for (int i = 0; i < 3; i++) {
			System.out.print(getCapacity()[i] + " ");
		}
		System.out.println("\n");
		System.out.println("There are " + getHeatSettings() + " heat settings available");
		System.out.println("The maximum temperature is " + getMaxTemp() + " degrees");
		System.out.println("The height is " + getHeight() + " cm");
		System.out.println("The size of the water tank is " + getWaterTankSize() + " l");
		System.out.println("--------------------");
	}

	@Override
	public void fold() {
		System.out.println("Folded for storage");		
	}	
}
