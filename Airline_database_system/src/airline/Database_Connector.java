package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connector {
	Connection con;

	public Database_Connector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connected");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost",
					"system", "shoeb1208");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	Connection getConnection() {
		return con;
	}

}
