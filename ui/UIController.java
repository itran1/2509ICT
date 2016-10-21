package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Database.Item;
import Database.Order.OrderType;

import java.awt.event.*;

public class UIController implements ActionListener, ListSelectionListener {

	private Database.Database db;
	private Database.Order order;
	private Database.Customer customer;
	
	private JFrame frame;
	private CardLayout cardLayout;
	private JPanel[] views;
	private JPanel cardPanel;
	
	private final static String[] screens = {
		"MainMenu",
		"NewOrder",
		"EditMenuItems",
		"DailyReport"
	};
	
	private String currentScreen;
	private StyleSettings styleSettings;
	
	public UIController() {
		
		this.db = new Database.Database();
		Database.Item[] menu = db.getAllItems();
		if(menu == null) {
			menu = new Database.Item[]{};
		}
		this.order = new Database.Order();
		styleSettings = new StyleSettings();
		
		views = new JPanel[] {
				(JPanel)new MainMenu(styleSettings),
				(JPanel)new NewOrder(styleSettings, menu),
				(JPanel)new MenuItems(styleSettings, menu)
				// other screens added here
		};
		
		((MainMenu)views[0]).newOrder.addActionListener(this);
		((MainMenu)views[0]).editMenuItems.addActionListener(this);
		((MainMenu)views[0]).viewDailyReport.addActionListener(this);
		
		((NewOrder)views[1]).backToMainMenuFromOrderTypeScreen.addActionListener(this);
		((NewOrder)views[1]).backToMainMenuFromPhoneNumberScreen.addActionListener(this);
		((NewOrder)views[1]).backToMainMenuFromCustomerDetailsScreen.addActionListener(this);
		((NewOrder)views[1]).backToMainMenuFromOrderListScreen.addActionListener(this);
		((NewOrder)views[1]).takeaway.addActionListener(this);
		((NewOrder)views[1]).homeDelivery.addActionListener(this);
		((NewOrder)views[1]).confirmPhoneNumber.addActionListener(this);
		((NewOrder)views[1]).confirmCustomerDetails.addActionListener(this);
		
		((MenuItems)views[2]).backToMainMenu.addActionListener(this);
		((MenuItems)views[2]).createNewMenuItem.addActionListener(this);
		((MenuItems)views[2]).editMenuItem.addActionListener(this);
		((MenuItems)views[2]).deleteMenuItem.addActionListener(this);
		((MenuItems)views[2]).saveMenuItem.addActionListener(this);
		((MenuItems)views[2]).cancelMenuItem.addActionListener(this);
		((MenuItems)views[2]).menuList.addListSelectionListener(this);
		
		// add buttons from other screens here
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		
		frame = new JFrame("Ordering System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setResizable(false);
		
		cardLayout.addLayoutComponent(((MainMenu)views[0]), screens[0]);
		cardLayout.addLayoutComponent(((NewOrder)views[1]), screens[1]);
		cardLayout.addLayoutComponent(((MenuItems)views[2]), screens[2]);
		// add other screens here
		
		cardPanel.add(((MainMenu)views[0]));
		cardPanel.add(((NewOrder)views[1]));
		cardPanel.add(((MenuItems)views[2]));
		// add other screens here
		
		currentScreen = screens[0];
		cardLayout.show(cardPanel, currentScreen);
		
		frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		
		Database.Item item;
		JList<Database.Item> list;
		DefaultListModel<Database.Item> menuListModel;
		
		list = ((MenuItems)views[2]).menuList;
		menuListModel = ((MenuItems)views[2]).menuListModel;
		
		
		// If the "Edit Menu Items" button is clicked from the main menu,
		// load the edit menu screen
		if(cmd.equals(screens[2])) {
			currentScreen = screens[2];
			cardLayout.show(cardPanel, currentScreen);
		}
		
		// If the "Back" button is clicked from the edit menu screen,
		// load the main menu screen
		if(cmd.equals("BackToMainMenu")) {
			((MenuItems)views[2]).cleanUp();
			currentScreen = screens[0];
			cardLayout.show(cardPanel, currentScreen);
		}
		
		// If the "Create New" button is clicked from the edit menu screen,
		// enable the editing fields
		if(cmd.equals("CreateNewMenuItem")) {
			((MenuItems)views[2]).enableEditing(true);
			((MenuItems)views[2]).menuList.clearSelection();
			((MenuItems)views[2]).deleteMenuItem.setEnabled(false);
			((MenuItems)views[2]).menuList.setEnabled(false);
			((MenuItems)views[2]).creatingNew = true;
			((MenuItems)views[2]).nameTextField.setText("");
			((MenuItems)views[2]).priceTextField.setText("");
		}
		
		// If the "Save" button is clicked from the edit menu screen,
		// create the Item and store it in the database
		if(cmd.equals("SaveMenuItem")) {
			String name = ((MenuItems)views[2]).nameTextField.getText();
			if(name == null || name.equals("")) {
				((MenuItems)views[2]).dialog.invalidName();
			} else {
				int price = -1;
				String priceText = ((MenuItems)views[2]).priceTextField.getText();
				if(priceText == null || priceText.equals("")) {
					((MenuItems)views[2]).dialog.invalidPrice();
				} else {
					try {
						price = (int)(Double.parseDouble(priceText) * 100);
						if(price <= 0) {
							((MenuItems)views[2]).dialog.invalidPrice();
						} else {
							if(((MenuItems)views[2]).creatingNew) {
								((MenuItems)views[2]).creatingNew = false;
								((MenuItems)views[2]).enableEditing(false);
								db.addItem(name, price);
								Item newItem = db.getItem(db.getMenuSize() - 1);
								((MenuItems)views[2]).menuListModel.addElement(newItem);
								((MenuItems)views[2]).menuList.setEnabled(true);
								((MenuItems)views[2]).nameTextField.setText("");
								((MenuItems)views[2]).priceTextField.setText("");
								((MenuItems)views[2]).deleteMenuItem.setEnabled(false);
							} else if(((MenuItems)views[2]).editingExisting) {
								item = menuListModel.getElementAt(list.getSelectedIndex());
								((MenuItems)views[2]).editingExisting = false;
								((MenuItems)views[2]).enableEditing(false);
								db.updateItem(item.getNumber(), name, price);
								item = db.getItem(item.getNumber());
								((MenuItems)views[2]).menuListModel.setElementAt(item, list.getSelectedIndex());
								((MenuItems)views[2]).nameTextField.setText("");
								((MenuItems)views[2]).priceTextField.setText("");
								((MenuItems)views[2]).menuList.clearSelection();
								((MenuItems)views[2]).deleteMenuItem.setEnabled(false);
							}
						}
					} catch(NumberFormatException ex) {
						((MenuItems)views[2]).dialog.invalidPrice();
					}

				}
			}
		}
		
		// If the "Cancel" button is clicked from the edit menu screen,
		// clear selection and fields
		if(cmd.equals("CancelMenuItem")) {
			((MenuItems)views[2]).nameTextField.setText("");
			((MenuItems)views[2]).priceTextField.setText("");
			((MenuItems)views[2]).menuList.clearSelection();
			((MenuItems)views[2]).deleteMenuItem.setEnabled(false);
			((MenuItems)views[2]).enableEditing(false);
			((MenuItems)views[2]).editingExisting = false;
			((MenuItems)views[2]).creatingNew = false;
			((MenuItems)views[2]).menuList.setEnabled(true);
		}
		
		// If the "Delete" button is clicked from the edit menu screen,
		// produce a confirmation dialog
		if(cmd.equals("DeleteMenuItem")) {
			int itemIndex = ((MenuItems)views[2]).menuList.getSelectedIndex();
			item = ((MenuItems)views[2]).menuListModel.getElementAt(itemIndex);
			String itemNumber = "" + item.getNumber();
			int response = ((MenuItems)views[2]).dialog.deleteItem(itemNumber, item.getName());
			if(response == JOptionPane.OK_OPTION) {
				db.removeItem(item.getNumber());
				((MenuItems)views[2]).menuListModel.removeElementAt(itemIndex);
				((MenuItems)views[2]).nameTextField.setText("");
				((MenuItems)views[2]).priceTextField.setText("");
				((MenuItems)views[2]).menuList.clearSelection();
				((MenuItems)views[2]).deleteMenuItem.setEnabled(false);
				((MenuItems)views[2]).enableEditing(false);
				((MenuItems)views[2]).editingExisting = false;
				((MenuItems)views[2]).creatingNew = false;
				((MenuItems)views[2]).menuList.setEnabled(true);
				((MenuItems)views[2]).updateIndexes(db.getAllItems());
			}
		}
		
		// If the "New Order" button is clicked from the main menu,
		// load the new order screen
		if(cmd.equals(screens[1])) {
			currentScreen = screens[1];
			cardLayout.show(cardPanel, currentScreen);
		}
		
		// If the "Back" button is clicked from the new order screen,
		// produce a confirmation dialog
		if(cmd.equals("BackToMainMenuFromNewOrderPanel")) {
			int response = ((NewOrder)views[1]).dialog.backToMain();
			if(response == JOptionPane.YES_OPTION) {
				((NewOrder)views[1]).cleanUp();
				order = new Database.Order();
				currentScreen = screens[0];
				cardLayout.show(cardPanel, currentScreen);
			}
		}
		
		// If the "Takeaway" button is clicked from the new order screen,
		// set the order to takeaway and load the phone number screen
		if(cmd.equals("Takeaway")) {
			order.setOrderType(OrderType.TAKEAWAY);
			((NewOrder)views[1]).showPhoneNumberPanel();
		}
		
		// If the "Home Delivery" button is clicked from the new order screen,
		// set the order to home delivery and load the phone number screen
		if(cmd.equals("HomeDelivery")) {
			order.setOrderType(OrderType.HOME_DELIVERY);
			((NewOrder)views[1]).showPhoneNumberPanel();
		}
		
		// If the "Check Database" button is clicked from the new order screen,
		// check the database to see if the phone number exists. If it doesn't,
		// produce a dialog box to confirm storing it, and go to the customer details screen.
		// Otherwise, just go to the customer details screen.
		if(cmd.equals("ConfirmPhoneNumber")) {
			String phoneNumber = ((NewOrder)views[1]).phoneNumberTextField.getText();
			if(phoneNumber == null || phoneNumber.equals("") || (phoneNumber.length() != 10 && phoneNumber.length() != 8)) {
				((NewOrder)views[1]).dialog.invalidPhoneNumber();
			} else {
				try {
					long phoneNumberLong = Long.parseLong(phoneNumber);
					if(phoneNumberLong <= 0) {
						((NewOrder)views[1]).dialog.invalidPhoneNumber();
					} else {
						this.customer = db.getCustomer(phoneNumber);
						if(this.customer == null) {
							int response = ((NewOrder)views[1]).dialog.newCustomer();
							if(response == JOptionPane.YES_OPTION) {
								((NewOrder)views[1]).showCustomerDetailsPanel(phoneNumber);
							}
						} else {
							((NewOrder)views[1]).showOrderListPanel(this.customer);
						}
					}
				} catch(NumberFormatException ex) {
					((NewOrder)views[1]).dialog.invalidPhoneNumber();
				}
				
			}
		}
		
		// If the "Confirm" button is clicked from the customer details screen,
		// create the Customer and store it in the database
		if(cmd.equals("ConfirmCustomerDetails")) {
			String address = ((NewOrder)views[1]).addressTextField.getText();
			if(address == null || address.equals("")) {
				((NewOrder)views[1]).dialog.invalidAddress();
			} else {
				String creditCardNumberString = ((NewOrder)views[1]).creditCardNumberTextField.getText();
				if(creditCardNumberString == null || creditCardNumberString.equals("") || creditCardNumberString.length() != 16) {
					((NewOrder)views[1]).dialog.invalidCreditCardNumber();
				} else {
					try {
						long creditCardNumber = Long.parseLong(creditCardNumberString);
						if(creditCardNumber < 0) {
							((NewOrder)views[1]).dialog.invalidCreditCardNumber();
						} else {
							String phoneNumber = "" + ((NewOrder)views[1]).phoneNumberText.getText();
							String creditCardDetails = new String(((NewOrder)views[1]).creditCardType.getSelectedItem().toString());
							creditCardDetails += ("|" + creditCardNumberString + "|");
							creditCardDetails += (((NewOrder)views[1]).creditCardExpiryMonth.getSelectedItem() + "|");
							creditCardDetails += (((NewOrder)views[1]).creditCardExpiryYear.getSelectedItem() + "|");
							Database.Customer customer = new Database.Customer(phoneNumber, address, creditCardDetails);
							db.addCustomer(phoneNumber, address, creditCardDetails);
							((NewOrder)views[1]).showOrderListPanel(customer);
						}
					} catch(NumberFormatException ex) {
							((NewOrder)views[1]).dialog.invalidCreditCardNumber();
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		JList<Database.Item> list;
		list = (JList<Database.Item>)e.getSource();
		
		if(list.getSelectedIndex() >= 0) {
			Database.Item item;
			
			DefaultListModel<Database.Item> menuListModel;
			
			
			menuListModel = (DefaultListModel<Database.Item>) list.getModel();
			item = menuListModel.getElementAt(list.getSelectedIndex());
			
			((MenuItems)views[2]).nameTextField.setText(item.getName());
			String priceText = "" + item.getPrice() / 100 + "." + item.getPrice() % 100;
			if(item.getPrice() % 100 == 0) {
				priceText += "0";
			}
			((MenuItems)views[2]).priceTextField.setText(priceText);
			((MenuItems)views[2]).editingExisting = true;
			((MenuItems)views[2]).enableEditing(true);
			((MenuItems)views[2]).deleteMenuItem.setEnabled(true);
		}

	}

}
