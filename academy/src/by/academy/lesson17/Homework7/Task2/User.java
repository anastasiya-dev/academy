package by.academy.lesson17.Homework7.Task2;

public class User extends Person {
	private String login;
	private String password;
	private String email;

	public User(String firstName, String lastName, String dateOfBirth, String login, String password,
			String email) {
		super(firstName, lastName, dateOfBirth);
		this.login = login;
		this.password = password;
		this.email = email;
	}

	public User() {
		super();
	}

	protected String getLogin() {
		return login;
	}

	protected void setLogin(String login) {
		this.login = login;
	}

	private String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	public void printUserInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("***");
		sb.append("First Name: ");
		sb.append(getFirstName());
		sb.append("; Last Name: ");
		sb.append(getLastName());
		sb.append("; Age: ");
		sb.append(getAge());
		sb.append("; Date of Birth: ");
		sb.append(sdf.format(getDateOfBirth().getTime()));
		sb.append("; Login: ");
		sb.append(getLogin());
		sb.append("; Password: ");
		sb.append(getPassword());
		sb.append("; Email: ");
		sb.append(getEmail());
		sb.append("***");
		System.out.println(sb.toString());
	}
}
