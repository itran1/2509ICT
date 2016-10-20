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
	
	private NewOrder parent;
	
	public NewOrderDialog(NewOrder parent) {
		this.parent = parent;
	}
}
