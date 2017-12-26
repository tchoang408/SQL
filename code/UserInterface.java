package mySql.code;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UserInterface extends JFrame {
	private JTextField text1;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JButton button1;
	private JRadioButton rEqualButton;
	private JRadioButton rGreaterButton;
	private JRadioButton rLessButton;
	private ButtonGroup group;
	private SQL_Integration mySQL;
	private JComboBox dropMenu;

	private String searchType;
	private String userInput;
	private String equality;
	public UserInterface() {
		// The following desfin GUI interfaces
		super("Search Window");
		label2 = new JLabel("Select a search category");
		add(label2);
		dropMenu = new JComboBox(new String[]{"ID", "City Name", "Population",
				"District", "ContryCode"});
		add(dropMenu);
		setLayout(new FlowLayout());
		rEqualButton = new JRadioButton("Equal");
		rGreaterButton = new JRadioButton("Greater Than");
		rLessButton = new JRadioButton("Less Than");
		group = new ButtonGroup();
		group.add(rEqualButton);
		group.add(rGreaterButton);
		group.add(rLessButton);
		add(rEqualButton);
		add(rGreaterButton);
		add(rLessButton);
		label1 = new JLabel("Search");
		add(label1);
		text1 = new JTextField("Enter Here", 10);
		add(text1);
		button1 = new JButton("Enter");
		add(button1);
		// The following are action listeners function
		TheHandler handler = new TheHandler();
		dropMenu.addActionListener(handler);
		text1.addActionListener(handler);
		button1.addActionListener(handler);
		rEqualButton.addActionListener(handler);
		rGreaterButton.addActionListener(handler);
		rLessButton.addActionListener(handler);

		// text1.getDocument().addDocumentListener(listener);
		/*
		 * 2nd method of using action listener button1.addActionListener((e) ->
		 * { submitAction(); });
		 */
	}
	private class TheHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			mySQL = new SQL_Integration();
			String select = "";
			if (event.getSource() == dropMenu) {
				searchType = (String) dropMenu.getSelectedItem();

				// This code activate when use press the enter button but
				// doesn't really do anything
			} else if (event.getSource() == rEqualButton
					|| event.getSource() == rGreaterButton
					|| event.getSource() == rLessButton) {
				equality = event.getActionCommand();
				System.out.println(equality);
			} else if (event.getSource() == text1) {
				userInput = event.getActionCommand();
			} else {
				userInput = text1.getText();
				select = String.format("select * from city WHERE %s='%s'",
						searchType, userInput);
				// System.out.println(select);
				mySQL.SetUpConnection(select);
			}

		}
	}

	private void submitAction() {
		mySQL = new SQL_Integration();
		String select = "select * from city WHERE name=" + "'" + text1.getText()
				+ "'";
		mySQL.SetUpConnection(select);
	}
}
