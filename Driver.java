package mySql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {

		UserInterface Interface = new UserInterface();
		Interface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Interface.setSize(275, 180);
		Interface.setVisible(true);

		// TODO Auto-generated method stub
		/*
		 * // create a GUI Panel asking for the user to input a number String fn
		 * = JOptionPane.showInputDialog("Enter first number"); String sn =
		 * JOptionPane.showInputDialog("Enter the second number");
		 * 
		 * // convert the string to integer int num1 = Integer.parseInt(fn); int
		 * num2 = Integer.parseInt(sn); int sum = num1 + num2;
		 * 
		 * // show the result message dialog panel
		 * JOptionPane.showMessageDialog(null, "Total is " + sum, "Result",
		 * JOptionPane.PLAIN_MESSAGE);
		 */
		try {
			// step 1: create connection to database
			Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world", "root", "veritas34");
			// step 2: create statement
			Statement myStmt = myConn.createStatement();
			// step 3: Execute SQL query
			ResultSet myRs = myStmt
					.executeQuery("select * from city WHERE name='San Jose'");
			// step 4: Process the result set
			while (myRs.next()) {

				System.out.println(myRs.getString("Name") + ","
						+ myRs.getString("District") + "  "
						+ myRs.getString("Population"));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
