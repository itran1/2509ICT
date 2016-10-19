package ui;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MenuItemsDialog extends JOptionPane {
	
	public void invalidPrice() {
		showMessageDialog(parent, "Error: Invalid price.\nPlease enter a valid price.\nFormat: dd.cc (dd = dollars, cc = cents)", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void invalidName() {
		showMessageDialog(parent, "Error: Invalid name.\nPlease choose a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public int deleteItem(String itemNumber, String itemName) {
		return JOptionPane.showConfirmDialog(parent, "Delete item " + itemNumber + ": " + itemName + "?", "Delete Item", JOptionPane.OK_CANCEL_OPTION);
	}
	
	private MenuItems parent;
	
	public MenuItemsDialog(MenuItems parent) {
		this.parent = parent;
	}
}
