package ui;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NewOrderDialog extends JOptionPane {
	
	public int backToMain() {
		return JOptionPane.showConfirmDialog(parent, "Return to the main menu and discard this order?", "Confirm", JOptionPane.YES_NO_OPTION);
	}
	
	public int newCustomer() {
		return JOptionPane.showConfirmDialog(parent, "Customer does not exist. Store new customer details?", "Confirm", JOptionPane.YES_NO_OPTION);
	}
	
	public void invalidPhoneNumber() {
		showMessageDialog(parent, "Error: Invalid phone number.\nPlease enter a valid phone number.\nFormat: 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void invalidAddress() {
		showMessageDialog(parent, "Error: Invalid address.\nPlease enter a valid address.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void invalidCreditCardNumber() {
		showMessageDialog(parent, "Error: Invalid credit card number.\nPlease enter a valid credit card number.\nFormat: 16 digits", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void invalidMenuSelection() {
		showMessageDialog(parent, "Error: Invalid number.\nPlease enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void menuItemNotFound() {
		showMessageDialog(parent, "Error: Menu item not found.\nPlease enter an existing menu item.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public int getQuantity(String menuItem) {
		int quantity;
		String input = showInputDialog(parent, "Enter quantity for menu item:\n" + menuItem, "Enter quantity", JOptionPane.QUESTION_MESSAGE);
		try {
			quantity = Integer.parseInt(input);
		} catch(NumberFormatException ex) {
			return -1;
		}
		return quantity;
	}
	
	public void invalidQuantity() {
		showMessageDialog(parent, "Error: Invalid quantity.\nPlease enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private NewOrder parent;
	
	public NewOrderDialog(NewOrder parent) {
		this.parent = parent;
	}
}
