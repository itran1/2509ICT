package ui;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class NewOrderDialog extends JOptionPane {
	
	public int backToMain() {
		return JOptionPane.showConfirmDialog(parent, "Return to the main menu and discard this order?", "Confirm", JOptionPane.YES_NO_OPTION);
	}
	private NewOrder parent;
	
	public NewOrderDialog(NewOrder parent) {
		this.parent = parent;
	}
}
