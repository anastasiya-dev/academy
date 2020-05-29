package by.academy.lesson15;

@MyAnnotation
public class Tiger extends Cat {

	public String meal;
	protected String area;
	private String type;	
	
	public Tiger(int age, String name, String toy, String meal, String area, String type) {
		super(age, name, toy);
		this.meal = meal;
		this.area = area;
		this.type = type;
	}

	protected String getMeal() {
		return meal;
	}

	protected void setMeal(String meal) {
		this.meal = meal;
	}

	protected String getArea() {
		return area;
	}

	protected void setArea(String area) {
		this.area = area;
	}

	protected String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}
	
	private void run() {
		System.out.println("I'm running!");
	}

}
