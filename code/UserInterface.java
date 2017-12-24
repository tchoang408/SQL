
/*
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class UserInterface extends JFrame {
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JTextField item4;
	private JPasswordField passwordField;
	private JLabel cityLabel;
	private JLabel idLabel;

	public UserInterface() {
		super("Database");
		setLayout(new FlowLayout());
		// Label a textField for item1
		cityLabel = new JLabel("Please enter a city");
		add(cityLabel);
		// create a text field of 10 character
		item1 = new JTextField(10);
		add(item1);
		// label a textfield for item2
		idLabel = new JLabel("Please enter a ID");
		add(idLabel);
		//
		item2 = new JTextField("Enter text here");
		add(item2);
		//
		item3 = new JTextField("undeditable", 20);
		item3.setEditable(false);
		add(item3);
		//
		passwordField = new JPasswordField("mypass");
		add(passwordField);
		TheHandler handler = new TheHandler();
		item1.addActionListener(handler);

	}
	private class TheHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String string = "";
			if (event.getSource() == item1)
				string = String.format("field 1: %s", event.getActionCommand());

			JOptionPane.showMessageDialog(null, string);

		}

	}

}
*/
package mySql.code;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserInterface extends JFrame {
	private JTextField text1;
	private JLabel label1;
	private JButton button1;
	private SQL_Integration mySQL;
	public UserInterface() {
		super("Search Window");
		setLayout(new FlowLayout());
		label1 = new JLabel("Enter The City");
		add(label1);
		text1 = new JTextField("Enter Here", 10);
		add(text1);
		button1 = new JButton("Enter");
		add(button1);
		button1.addActionListener((e) -> {
			submitAction();
		});

	}
	private void submitAction() {
		mySQL = new SQL_Integration();
		String select = "select * from city WHERE name=" + "'" + text1.getText()
				+ "'";
		mySQL.SetUpConnection(select);
	}

}

/*
 * private JTextField item1; private JTextField item2; private JTextField item3;
 * private JPasswordField passwordField; private JLabel cityLabel; private
 * JLabel idLabel; private JButton button; private JPanel panel; UserInterface()
 * { super("Database"); // Label a textField for item1 cityLabel = new
 * JLabel("Please enter a city"); add(cityLabel); // create a text field of 10
 * character item1 = new JTextField(10); add(item1); // create enter button //
 * label a textfield for item2 idLabel = new JLabel("Please enter a ID");
 * add(idLabel); // item2 = new JTextField("Enter text here"); add(item2); //
 * item3 = new JTextField("undeditable", 20); item3.setEditable(false);
 * add(item3); TheHandler handler = new TheHandler();
 * item1.addActionListener(handler); String city = handler.getCity1(); }
 * 
 * private class TheHandler implements ActionListener { private String city1;
 * public void actionPerformed(ActionEvent event) {
 * 
 * if (event.getSource() == item1) city1 = String.format("field 1: %s",
 * event.getActionCommand());
 * 
 * JOptionPane.showMessageDialog(null, city1);
 * 
 * } public String getCity1() { return city1; } }
 */
