package by.academy.lesson15;

@MyAnnotation
public class Cat {
	public int age;
	protected String name;
	private String toy;
	
	public Cat(int age, String name, String toy) {
		super();
		this.age = age;
		this.name = name;
		this.toy = toy;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getToy() {
		return toy;
	}

	protected void setToy(String toy) {
		this.toy = toy;
	}	
}
