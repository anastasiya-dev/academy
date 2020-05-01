package by.academy.lesson9.Task_6;

public class GenericClass <T extends Comparable<String>, V extends Animal, Serializable, K extends Number>{
	private T objT;
	private V objV;
	private K objK;
	
	public GenericClass() {
		super();		
	}
	public GenericClass(T objT, V objV, K objK) {
		super();
		this.objT = objT;
		this.objV = objV;
		this.objK = objK;
	}
	public T getObjT() {
		return objT;
	}
	public void setObjT(T objT) {
		this.objT = objT;
	}
	public V getObjV() {
		return objV;
	}
	public void setObjV(V objV) {
		this.objV = objV;
	}
	public K getObjK() {
		return objK;
	}
	public void setObjK(K objK) {
		this.objK = objK;
	}
	
	public void printClassName() {
		System.out.println("Receive class name:");
		System.out.println(GenericClass.class.getSimpleName());
		System.out.println("Receive variable actual type passed to generic:");
		System.out.println("T = " + this.objT.getClass());
		System.out.println("V = " + this.objV.getClass());
		System.out.println("K = " + this.objK.getClass());
	}	

}
