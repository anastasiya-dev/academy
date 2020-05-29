package by.academy.lesson15;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task {
	public static void main(String[] args) {
		Cat myCat = new Cat(5, "Barsik", "Ball");
		Tiger myTiger = new Tiger(10, "Reks", "Ball-2", "Meat", "Nepal", "Ussuriyskiy");
		Class<Cat> catClass = Cat.class;
		Class<Tiger> tigerClass = Tiger.class;
		Method[] catMethods = catClass.getMethods();
		for (Method method: catMethods) {
			System.out.println(method);
		}
		
		System.out.println("-------");
		Method[] tigetMethods = tigerClass.getDeclaredMethods();
		for (Method method: tigetMethods) {
			System.out.println(method);
		}
		System.out.println("-------");
		Field[] catFields = catClass.getFields();
		for (Field field: catFields) {
			try {
				System.out.println(field + " " + field.get(myCat));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("-------");
		Field[] tigerFields = tigerClass.getDeclaredFields();
		for (Field field: tigerFields) {
			field.setAccessible(true);
			try {
				System.out.println(field+ " " + field.get(myTiger));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("-------");		
		
		try {
			Field toyField = catClass.getDeclaredField("toy");
			toyField.setAccessible(true);
			System.out.println("Before change: " + toyField.get(myCat));
			toyField.set(myCat, "Pischalka");
			System.out.println("After change: " + toyField.get(myCat));
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("-------");		
		try {
			Field areaField = tigerClass.getDeclaredField("area");
			System.out.println("Before change: " + areaField.get(myTiger));
			areaField.set(myTiger, "Sibir");
			System.out.println("After change: " + areaField.get(myTiger));
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.out.println("-------");	
		Method runMethod;
		try {
			runMethod = tigerClass.getDeclaredMethod("run");
			runMethod.setAccessible(true);
			System.out.println(runMethod.invoke(myTiger));		

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println("-------");
		Annotation[] ann1 = catClass.getAnnotations();
		for (Annotation a: ann1) {
			if(a instanceof MyAnnotation) {
				MyAnnotation i = (MyAnnotation)a;
				System.out.println("character " + i.character);
				System.out.println("friends " + i.friends);	
			}			
		}
		System.out.println("-------");
		Annotation[] ann2 = tigerClass.getAnnotations();
		for (Annotation a: ann2) {
			if(a instanceof MyAnnotation) {
				MyAnnotation i = (MyAnnotation)a;
				System.out.println("character " + i.character);
				System.out.println("friends " + i.friends);	
			}			
		}
	}
}
