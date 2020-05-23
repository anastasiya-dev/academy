package by.academy.lesson13.Homework6.Task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Task3 {
	public static void main(String[] args) {
		/*
		 * Создайте класс User с полями Имя, Фамилия, Возраст и конструктором(Имя,
		 * Фамилия, Возраст). В классе Main создайте ArrayList<User>, добавьте 10
		 * пользователей в коллекцию. Создайте каталог(папку) users и для каждого
		 * пользователя создайте файл в этом каталоге. Назовите файл Имя_Фамилия.txt.
		 * Сериализуйте информацию о пользователе и положите в файл пользователя. Не
		 * забываем закрывать потоки. В блоке catch выводим сообщение ошибки на экран
		 * (System.err.println(e.getMessage());)
		 */

		ArrayList<User> users = new ArrayList<>();

		// add users to array list
		users.add(new User("Boris", "Pasternak", 35));
		users.add(new User("Taras", "Bulba", 28));
		users.add(new User("Alexandr", "Pushkin", 16));
		users.add(new User("Alexandr", "Blok", 12));
		users.add(new User("Lev", "Tolstoy", 74));
		users.add(new User("Kir", "Bulychev", 22));
		users.add(new User("Svetlana", "Aleksievich", 44));
		users.add(new User("Yuri", "Lermontov", 30));
		users.add(new User("Fedor", "Dostoevskiy", 21));
		users.add(new User("Aleksandr", "Griboedov", 21));

		// create folder for user files
		File dirTask = new File(
				"C:\\Users\\admin\\git\\repository\\academy\\src\\by\\academy\\lesson13\\Homework6\\Task3");
		File dirNew = new File(dirTask, "Users");
		if (!dirNew.exists()) {
			dirNew.mkdir();
		}

		for (User user : users) {
			// create user files
			File file = new File(dirNew, user.getName() + "_" + user.getSurname() + ".txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}

			// serialization
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
				out.writeObject(user.getName());
				out.writeObject(user.getSurname());
				out.writeInt(user.getAge());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

			// deserialization test
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				String name = (String) ois.readObject();
				String surname = (String) ois.readObject();
				int age = ois.readInt();
				System.out.println(name + " " + surname + " " + age);
			} catch (ClassNotFoundException | IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
