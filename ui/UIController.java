package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Database.Item;

import java.awt.event.*;

public class UIController implements ActionListener, ListSelectionListener {

	private Database.Database db;
	
	private JFrame frame;
	private CardLayout cardLayout;
	private JPanel[] views;
	private JPanel cardPanel;
	
	private final static String[] screens = {
		"MainMenu",
		"Order",
		"EditMenuItems",
		"DailyReport"
	};
	
	private String currentScreen;
	private StyleSettings styleSettings;
	
	public UIController() {
		
		//this.model = new Model();
		// get stuff from database
		// maybe dont need to load all customers and menu items yet
		// discuss with group
		// could just load them on the other screens when needed
		
		db = new Database.Database();
		Database.Item[] menu = db.getAllItems();
		if(menu == null) {
			menu = new Database.Item[]{};
		}
		styleSettings = new StyleSettings();
		
		views = new JPanel[] {
				(JPanel)new MainMenu(styleSettings),
				(JPanel)new MainMenu(styleSettings), // replace with order screen
				(JPanel)new MenuItems(styleSettings, menu)
				// other screens added here
		};
		
		((MainMenu)views[0]).newOrder.addActionListener(this);
		((MainMenu)views[0]).editMenuItems.addActionListener(this);
		((MainMenu)views[0]).viewDailyReport.addActionListener(this);
		
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
		cardLayout.addLayoutComponent(((MenuItems)views[2]), screens[2]);
		// add other screens here
		
		cardPanel.add(((MainMenu)views[0]));
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
			((MenuItems)views[2]).cleanup();
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
