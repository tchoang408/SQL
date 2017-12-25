package mySql.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL_Integration {

	public void SetUpConnection(String select) {
		try {
			// step 1: create connection to database
			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world", "root", "veritas34");
			// step 2: create statement
			Statement myStmt = myConn.createStatement();
			// step 3: Execute SQL query
			ResultSet myRs = myStmt.executeQuery(select);
			// step 4: Process the result set
			System.out.println(
					"----------------------------------------------------------------------------------");
			System.out.printf("%-6s%-20s%-25s%-20s%-20s\n", "ID", "Name",
					"CountryCode", "District", "Population");

			while (myRs.next()) {

				System.out.printf("%-6s%-20s%-25s%-20s%-20s\n",
						myRs.getString("ID"), myRs.getString("Name"),
						myRs.getString("CountryCode"),
						myRs.getString("District"),
						myRs.getString("Population"));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
