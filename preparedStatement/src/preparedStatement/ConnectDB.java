package preparedStatement;

import java.sql.Connection;

public class ConnectDB {

	public static void main(String[] args) {
		
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriveManager.getConnection("jdbc:postgresql://localhost:5432/");
			
			if(connection != null) {
				System.out.println("Connection OK");
			}
			else {
				System.out.println("Connection Failed");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
