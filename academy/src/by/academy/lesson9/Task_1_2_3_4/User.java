package by.academy.lesson9.Task_1_2_3_4;

public class User {
	private String login;
	private String password;
	
	public User() {
		super();
	}
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public class QueryInner{
		public void printToLog () {
			StringBuilder printToLog = new StringBuilder();
			printToLog.append("User sent query: ");
			printToLog.append(User.this.login);
			printToLog.append(" ");
			printToLog.append(User.this.password);
			System.out.println(printToLog);
		}

	}
	
	public void createQueryInner() {
		QueryInner query1 = new QueryInner();
		query1.printToLog();		
	}
	
	public void createQueryLocal() {

		class QueryLocal{
			
			public void printToLog () {
				StringBuilder printToLog = new StringBuilder();
				printToLog.append("User sent query: ");
				printToLog.append(User.this.login);
				printToLog.append(" ");
				printToLog.append(User.this.password);
				System.out.println(printToLog);				
			}
		}
		QueryLocal query1 = new QueryLocal();
		query1.printToLog();
	}
	
	static class QueryStatic{
		public void printToLog (User user1) {
			StringBuilder printToLog = new StringBuilder();
			printToLog.append("User sent query: ");
			printToLog.append(user1.login);
			printToLog.append(" ");
			printToLog.append(user1.password);
			System.out.println(printToLog);		
		}
	}
}
