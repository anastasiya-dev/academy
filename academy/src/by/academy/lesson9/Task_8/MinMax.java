package by.academy.lesson9.Task_8;

public class MinMax <K extends Number>{
	private K[] numbers;
	
	public MinMax() {
		super();
	}

	public MinMax(K[] numbers) {
		super();
		this.numbers = numbers;
	}
	
	
	public K[] getNumbers() {
		return numbers;
	}

	public void setNumbers(K[] numbers) {
		this.numbers = numbers;
	}

	public K max() {
		K max = this.numbers[0];
		for (K i : this.numbers) {
			if (i.doubleValue() > max.doubleValue()) {
				max = i;
			}
		}
		return max;
	}
	
	public K min() {
		K min = this.numbers[0];
		for (K i : this.numbers) {
			if (i.doubleValue() < min.doubleValue()) {
				min = (K) i;
			}
		}
		return min;
	}
}
