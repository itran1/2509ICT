package ui;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class NewOrder extends JPanel {
	
	public void cleanUp() {
		currentScreen = screens[0];
		this.cardLayout.show(this, currentScreen);
	}
	
	public void showOrderListPanel() {
		currentScreen = screens[3];
		this.cardLayout.show(this, currentScreen);
	}
	
	public void showCustomerDetailsPanel() {
		currentScreen = screens[2];
		this.cardLayout.show(this, currentScreen);
	}
	
	public void showPhoneNumberPanel() {
		currentScreen = screens[1];
		this.cardLayout.show(this, currentScreen);
	}
	
	private JPanel createOrderTypePanel() {
		JPanel orderTypePanel = new JPanel();
		GridBagLayout orderTypePanelLayout = new GridBagLayout();
		orderTypePanel.setLayout(orderTypePanelLayout);
		
		JPanel topPanel = new JPanel();
		GridBagLayout topPanelLayout = new GridBagLayout();
		topPanel.setLayout(topPanelLayout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		orderTypePanel.add(topPanel, c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 10, 0, 0);
		backToMainMenu = new JButton("Back");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		backToMainMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
		backToMainMenu.setFont(buttonFont);
		backToMainMenu.setActionCommand("BackToMainMenuFromNewOrderPanel");
		backToMainMenu.setPreferredSize(backButtonSize);
		topPanel.add(backToMainMenu, c);
		
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(20, 0, 0, 0);
		Font headingFont = new Font(this.styleSettings.getDefaultFont(), Font.BOLD, 36);
		JLabel l = new JLabel("Ordering System");
		l.setFont(headingFont);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		topPanel.add(l, c);
		
		Font screenFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, 24);
		l = new JLabel("Select Order Type");
		l.setFont(screenFont);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_END;
		topPanel.add(l, c);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0, 0, 0, 10);
		JPanel topPanelFiller = new JPanel();
		topPanelFiller.setPreferredSize(backButtonSize);
		topPanel.add(topPanelFiller, c);
		
		JPanel bottomPanel = new JPanel();
		GridBagLayout leftPanelLayout = new GridBagLayout();
		bottomPanel.setLayout(leftPanelLayout);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		orderTypePanel.add(bottomPanel, c);
		
		takeaway = new JButton("Takeaway");
		buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize() + 2);
		takeaway.setFont(buttonFont);
		takeaway.setActionCommand("Takeaway");
		Dimension buttonSize = new Dimension(150, 50);
		takeaway.setPreferredSize(buttonSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 10);
		bottomPanel.add(takeaway, c);
		
		homeDelivery = new JButton("Home Delivery");
		buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize() + 2);
		homeDelivery.setFont(buttonFont);
		homeDelivery.setActionCommand("HomeDelivery");
		buttonSize = new Dimension(150, 50);
		homeDelivery.setPreferredSize(buttonSize);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 10, 0, 0);
		bottomPanel.add(homeDelivery, c);
		
		return orderTypePanel;
	}
	
	private JPanel createPhoneNumberPanel() {
		JPanel phoneNumberPanel = new JPanel();
		GridBagLayout phoneNumberPanelLayout = new GridBagLayout();
		phoneNumberPanel.setLayout(phoneNumberPanelLayout);
		
		JPanel topPanel = new JPanel();
		GridBagLayout topPanelLayout = new GridBagLayout();
		topPanel.setLayout(topPanelLayout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		phoneNumberPanel.add(topPanel, c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 10, 0, 0);
		backToMainMenu = new JButton("Back");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		backToMainMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
		backToMainMenu.setFont(buttonFont);
		backToMainMenu.setActionCommand("BackToMainMenuFromNewOrderPanel");
		backToMainMenu.setPreferredSize(backButtonSize);
		topPanel.add(backToMainMenu, c);
		
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(20, 0, 0, 0);
		Font headingFont = new Font(this.styleSettings.getDefaultFont(), Font.BOLD, 36);
		JLabel l = new JLabel("Ordering System");
		l.setFont(headingFont);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		topPanel.add(l, c);
		
		Font screenFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, 24);
		l = new JLabel("Enter Customer Phone Number");
		l.setFont(screenFont);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_END;
		topPanel.add(l, c);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0, 0, 0, 10);
		JPanel topPanelFiller = new JPanel();
		topPanelFiller.setPreferredSize(backButtonSize);
		topPanel.add(topPanelFiller, c);
		
		JPanel bottomPanel = new JPanel();
		GridBagLayout leftPanelLayout = new GridBagLayout();
		bottomPanel.setLayout(leftPanelLayout);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		phoneNumberPanel.add(bottomPanel, c);
		
		phoneNumberTextField = new JTextField();
		Font textFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		phoneNumberTextField.setFont(textFont);
		phoneNumberTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		phoneNumberTextField.setPreferredSize(textFieldSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 10);
		bottomPanel.add(phoneNumberTextField, c);
		
		confirmPhoneNumber = new JButton("Check Database");
		buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize() + 2);
		confirmPhoneNumber.setFont(buttonFont);
		confirmPhoneNumber.setActionCommand("ConfirmPhoneNumber");
		confirmPhoneNumber.setPreferredSize(new Dimension(150, 50));
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(20, 0, 0, 0);
		bottomPanel.add(confirmPhoneNumber, c);
		
		return phoneNumberPanel;
	}
	
	private JPanel createCustomerDetailsPanel() {
		return new JPanel();
	}
	
	private JPanel createOrderListPanel() {
		return new JPanel();
	}
	
	private JPanel createMenuItemPanel() {
		return new JPanel();
	}
	
	private JPanel createOrderSummaryPanel() {
		return new JPanel();
	}
	
	private StyleSettings styleSettings;
	private Database.Item[] menu;
	
	private String[] screens;
	private String currentScreen;
	
	public NewOrderDialog dialog;
	
	private CardLayout cardLayout;
	
	private JPanel orderTypePanel, phoneNumberPanel, customerDetailsPanel, orderListPanel, menuItemPanel, orderSummaryPanel;
	
	public JButton backToMainMenu, takeaway, homeDelivery, confirmPhoneNumber;
	public JTextField phoneNumberTextField;
	
	private Dimension backButtonSize, largeButtonSize, textFieldSize;

	public NewOrder(StyleSettings styleSettings, Database.Item[] menu) {
		super();
		this.styleSettings = styleSettings;
		this.menu = menu;
		this.dialog = new NewOrderDialog(this);
		this.backButtonSize = new Dimension(65, 25);
		this.largeButtonSize = new Dimension(120, 50);
		this.textFieldSize = new Dimension(300, 25);
		
		this.screens = new String[] {
				"OrderTypePanel",		// 0
				"PhoneNumberPanel",		// 1
				"CustomerDetailsPanel",	// 2
				"OrderListPanel",		// 3
				"MenuItemPanel",		// 4
				"OrderSummaryPanel"};	// 5
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		
		orderTypePanel = this.createOrderTypePanel();
		phoneNumberPanel = this.createPhoneNumberPanel();
		customerDetailsPanel = this.createCustomerDetailsPanel();
		orderListPanel = this.createOrderListPanel();
		menuItemPanel = this.createMenuItemPanel();
		orderSummaryPanel = this.createOrderSummaryPanel();
		
		cardLayout.addLayoutComponent(orderTypePanel, screens[0]);
		cardLayout.addLayoutComponent(phoneNumberPanel, screens[1]);
		cardLayout.addLayoutComponent(customerDetailsPanel, screens[2]);
		cardLayout.addLayoutComponent(orderListPanel, screens[3]);
		cardLayout.addLayoutComponent(menuItemPanel, screens[4]);
		cardLayout.addLayoutComponent(orderSummaryPanel, screens[5]);
		
		this.add(orderTypePanel);
		this.add(phoneNumberPanel);
		this.add(customerDetailsPanel);
		this.add(orderListPanel);
		this.add(menuItemPanel);
		this.add(orderSummaryPanel);
		
		currentScreen = screens[0];
		cardLayout.show(this, currentScreen);
	}
}
