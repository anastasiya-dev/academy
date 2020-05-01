package by.academy.lesson9.Task_5;

public class Food {
	
	Food(){
		super();
	}
	
	public void prepare(Cookable c, String dish) {
		c.cook(dish);
	}
}
