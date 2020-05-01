package by.academy.lesson9.Task_5;

public class Main_Task_5 {
	public static void main(String[] args) {
	Food lasagna = new Food();

	lasagna.prepare(new Cookable() {

		@Override
		public void cook(String meal) {
			System.out.println("Cooking " + meal);
			
		}
		
	}, "diMare");
	
	}
}
