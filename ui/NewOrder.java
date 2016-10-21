package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import Database.Item;

@SuppressWarnings("serial")
public class NewOrder extends JPanel {
	
	public void updateIndexes(Database.Item[] menu) {
		menuListModel.removeAllElements();
		if(menu.length > 0) {
			for(int i = 0; i < menu.length; i++) {
				menuListModel.addElement(new Database.Item(i, menu[i].getName(), menu[i].getPrice()));
			}
		}
	}
	
	public void updateOrder() {
		orderListModel.removeAllElements();
		int i;
		String[] readable = this.order.getItems();
		for(i = 0; i < this.order.items.size(); i++) {
			orderListModel.addElement(readable[i]);
		}
	}
	
	public void cleanUp() {
		phoneNumberTextField.setText("");
		phoneNumberText.setText("");
		addressTextField.setText("");
		menuList.clearSelection();
		addMenuItem.setEnabled(false);
		editMenuItem.setEnabled(false);
		deleteMenuItem.setEnabled(false);
		finaliseOrder.setEnabled(false);
		menuSearchTextField.setText("");
		currentScreen = screens[0];
		this.cardLayout.show(this, currentScreen);
	}
	
	public void showOrderListPanel(Database.Customer customer) {
		this.customer = customer;
		phoneNumberOrderScreen.setText(this.customer.getDetails()[0]);
		addressOrderScreen.setText("<html><body style='width: 150'>" + this.customer.getDetails()[1] + "</body></html>");
		creditCardDetailsOrderScreen.setText("<html><body style='width: 150'>" + this.customer.getDetails()[2] + "</body></html>");
		currentScreen = screens[3];
		this.cardLayout.show(this, currentScreen);
		System.out.println("showing " + screens[3]);
	}
	
	public void showCustomerDetailsPanel(String phoneNumber) {
		this.customer = new Database.Customer(phoneNumber, "", "");
		phoneNumberText.setText(phoneNumber);
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
		backToMainMenuFromCustomerDetailsScreen = new JButton("Back");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		backToMainMenuFromCustomerDetailsScreen.setAlignmentX(Component.LEFT_ALIGNMENT);
		backToMainMenuFromCustomerDetailsScreen.setFont(buttonFont);
		backToMainMenuFromCustomerDetailsScreen.setActionCommand("BackToMainMenuFromNewOrderPanel");
		backToMainMenuFromCustomerDetailsScreen.setPreferredSize(backButtonSize);
		topPanel.add(backToMainMenuFromCustomerDetailsScreen, c);
		
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
		backToMainMenuFromPhoneNumberScreen = new JButton("Back");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		backToMainMenuFromPhoneNumberScreen.setAlignmentX(Component.LEFT_ALIGNMENT);
		backToMainMenuFromPhoneNumberScreen.setFont(buttonFont);
		backToMainMenuFromPhoneNumberScreen.setActionCommand("BackToMainMenuFromNewOrderPanel");
		backToMainMenuFromPhoneNumberScreen.setPreferredSize(backButtonSize);
		topPanel.add(backToMainMenuFromPhoneNumberScreen, c);
		
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
		GridBagLayout bottomPanelLayout = new GridBagLayout();
		bottomPanel.setLayout(bottomPanelLayout);
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
		JPanel customerDetailsPanel = new JPanel();
		GridBagLayout customerDetailsPanelLayout = new GridBagLayout();
		customerDetailsPanel.setLayout(customerDetailsPanelLayout);
		
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
		customerDetailsPanel.add(topPanel, c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 10, 0, 0);
		backToMainMenuFromOrderTypeScreen = new JButton("Back");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		backToMainMenuFromOrderTypeScreen.setAlignmentX(Component.LEFT_ALIGNMENT);
		backToMainMenuFromOrderTypeScreen.setFont(buttonFont);
		backToMainMenuFromOrderTypeScreen.setActionCommand("BackToMainMenuFromNewOrderPanel");
		backToMainMenuFromOrderTypeScreen.setPreferredSize(backButtonSize);
		topPanel.add(backToMainMenuFromOrderTypeScreen, c);
		
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
		l = new JLabel("Enter Customer Details");
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
		GridBagLayout bottomPanelLayout = new GridBagLayout();
		bottomPanel.setLayout(bottomPanelLayout);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		customerDetailsPanel.add(bottomPanel, c);
		
		JPanel bottomLeftPanel = new JPanel();
		GridBagLayout bottomLeftPanelLayout = new GridBagLayout();
		bottomLeftPanel.setLayout(bottomLeftPanelLayout);
		TitledBorder bottomLeftPanelTitle;
		bottomLeftPanelTitle = BorderFactory.createTitledBorder("Customer Details");
		Font textFont = new Font(styleSettings.getDefaultFont(), Font.PLAIN, styleSettings.getDefaultSize());
		bottomLeftPanelTitle.setTitleFont(textFont);
		bottomLeftPanel.setBorder(bottomLeftPanelTitle);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		bottomPanel.add(bottomLeftPanel, c);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		phoneNumberLabel.setFont(textFont);
		phoneNumberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(phoneNumberLabel, c);
		
		phoneNumberText = new JLabel();
		phoneNumberText.setFont(textFont);
		phoneNumberText.setAlignmentX(Component.LEFT_ALIGNMENT);
		phoneNumberText.setBorder(BorderFactory.createLineBorder(Color.black));
		phoneNumberText.setPreferredSize(textFieldSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(phoneNumberText, c);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(textFont);
		addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(addressLabel, c);
		
		addressTextField = new JTextField();
		addressTextField.setFont(textFont);
		addressTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		addressTextField.setPreferredSize(textFieldSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 0, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(addressTextField, c);
		
		JPanel bottomRightPanel = new JPanel();
		GridBagLayout bottomRightPanelLayout = new GridBagLayout();
		bottomRightPanel.setLayout(bottomRightPanelLayout);
		TitledBorder bottomRightPanelTitle;
		bottomRightPanelTitle = BorderFactory.createTitledBorder("Payment Details");
		bottomRightPanelTitle.setTitleFont(textFont);
		bottomRightPanel.setBorder(bottomRightPanelTitle);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_END;
		bottomPanel.add(bottomRightPanel, c);
		
		JLabel creditCardTypeLabel = new JLabel("Credit Card Type:");
		creditCardTypeLabel.setFont(textFont);
		creditCardTypeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(creditCardTypeLabel, c);
		
		creditCardType = new JComboBox<String>(creditCardTypes);
		creditCardType.setSelectedIndex(0);
		creditCardType.setFont(textFont);
		creditCardType.setAlignmentX(Component.LEFT_ALIGNMENT);
		creditCardType.setPreferredSize(textFieldSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(creditCardType, c);
		
		JLabel creditCardNumberLabel = new JLabel("Credit Card Number:");
		creditCardNumberLabel.setFont(textFont);
		creditCardNumberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(creditCardNumberLabel, c);
		
		creditCardNumberTextField = new JTextField();
		creditCardNumberTextField.setFont(textFont);
		creditCardNumberTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		creditCardNumberTextField.setPreferredSize(textFieldSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(creditCardNumberTextField, c);
		
		JLabel creditCardExpiryLabel = new JLabel("Credit Card Expiry:");
		creditCardExpiryLabel.setFont(textFont);
		creditCardExpiryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(creditCardExpiryLabel, c);
		
		creditCardExpiryMonth = new JComboBox<String>(months);
		creditCardExpiryMonth.setSelectedIndex(0);
		creditCardExpiryMonth.setFont(textFont);
		creditCardExpiryMonth.setAlignmentX(Component.LEFT_ALIGNMENT);
		creditCardExpiryMonth.setPreferredSize(new Dimension(105, 25));
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(creditCardExpiryMonth, c);
		
		creditCardExpiryYear = new JComboBox<String>(years);
		creditCardExpiryYear.setSelectedIndex(0);
		creditCardExpiryYear.setFont(textFont);
		creditCardExpiryYear.setAlignmentX(Component.LEFT_ALIGNMENT);
		creditCardExpiryYear.setPreferredSize(new Dimension(105, 25));
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(creditCardExpiryYear, c);
		
		JPanel footer = new JPanel();
		footer.setLayout(new BorderLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 100, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		bottomPanel.add(footer, c);
		
		confirmCustomerDetails = new JButton("Confirm");
		confirmCustomerDetails.setFont(buttonFont);
		confirmCustomerDetails.setActionCommand("ConfirmCustomerDetails");
		confirmCustomerDetails.setPreferredSize(largeButtonSize);
		footer.add(confirmCustomerDetails, BorderLayout.CENTER);
		
		return customerDetailsPanel;
	}
	
	private JPanel createOrderListPanel() {
		JPanel orderListPanel = new JPanel();
		GridBagLayout orderListPanelLayout = new GridBagLayout();
		orderListPanel.setLayout(orderListPanelLayout);
		
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
		orderListPanel.add(topPanel, c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 10, 0, 0);
		backToMainMenuFromOrderListScreen = new JButton("Back");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		backToMainMenuFromOrderListScreen.setAlignmentX(Component.LEFT_ALIGNMENT);
		backToMainMenuFromOrderListScreen.setFont(buttonFont);
		backToMainMenuFromOrderListScreen.setActionCommand("BackToMainMenuFromNewOrderPanel");
		backToMainMenuFromOrderListScreen.setPreferredSize(backButtonSize);
		topPanel.add(backToMainMenuFromOrderListScreen, c);
		
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
		l = new JLabel("Enter Order Items");
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
		GridBagLayout bottomPanelLayout = new GridBagLayout();
		bottomPanel.setLayout(bottomPanelLayout);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		orderListPanel.add(bottomPanel, c);
		
		JPanel bottomLeftPanel = new JPanel();
		GridBagLayout bottomLeftPanelLayout = new GridBagLayout();
		bottomLeftPanel.setLayout(bottomLeftPanelLayout);
		TitledBorder bottomLeftPanelTitle;
		bottomLeftPanelTitle = BorderFactory.createTitledBorder("Customer Details");
		Font textFont = new Font(styleSettings.getDefaultFont(), Font.PLAIN, styleSettings.getDefaultSize());
		bottomLeftPanelTitle.setTitleFont(textFont);
		bottomLeftPanel.setBorder(bottomLeftPanelTitle);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.33;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		bottomPanel.add(bottomLeftPanel, c);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		phoneNumberLabel.setFont(textFont);
		phoneNumberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(phoneNumberLabel, c);
		
		phoneNumberOrderScreen = new JLabel();
		phoneNumberOrderScreen.setFont(textFont);
		phoneNumberOrderScreen.setAlignmentX(Component.LEFT_ALIGNMENT);
		phoneNumberOrderScreen.setBorder(BorderFactory.createLineBorder(Color.black));
		phoneNumberOrderScreen.setPreferredSize(smallTextFieldSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(phoneNumberOrderScreen, c);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(textFont);
		addressLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(addressLabel, c);
		
		addressOrderScreen = new JLabel();
		addressOrderScreen.setFont(textFont);
		addressOrderScreen.setAlignmentX(Component.LEFT_ALIGNMENT);
		addressOrderScreen.setBorder(BorderFactory.createLineBorder(Color.black));
		addressOrderScreen.setPreferredSize(largeLabelSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(addressOrderScreen, c);
		
		JLabel creditCardDetailsLabel = new JLabel("Payment Details:");
		creditCardDetailsLabel.setFont(textFont);
		creditCardDetailsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(creditCardDetailsLabel, c);
		
		creditCardDetailsOrderScreen = new JLabel();
		creditCardDetailsOrderScreen.setFont(textFont);
		creditCardDetailsOrderScreen.setAlignmentX(Component.LEFT_ALIGNMENT);
		creditCardDetailsOrderScreen.setBorder(BorderFactory.createLineBorder(Color.black));
		creditCardDetailsOrderScreen.setPreferredSize(largeLabelSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomLeftPanel.add(creditCardDetailsOrderScreen, c);

		JPanel bottomMiddlePanel = new JPanel();
		GridBagLayout bottomMiddlePanelLayout = new GridBagLayout();
		bottomMiddlePanel.setLayout(bottomMiddlePanelLayout);
		TitledBorder bottomMiddlePanelTitle;
		bottomMiddlePanelTitle = BorderFactory.createTitledBorder("Menu");
		bottomMiddlePanelTitle.setTitleFont(textFont);
		bottomMiddlePanel.setBorder(bottomMiddlePanelTitle);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.33;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		bottomPanel.add(bottomMiddlePanel, c);
		
		l = new JLabel("Select menu item by number:");
		l.setFont(textFont);
		l.setAlignmentX(Component.LEFT_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomMiddlePanel.add(l, c);
		
		menuSearchTextField = new JTextField();
		menuSearchTextField.setFont(textFont);
		menuSearchTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuSearchTextField.setPreferredSize(new Dimension(70, 25));
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.0;
		c.insets = new Insets(0, 0, 20, 20);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomMiddlePanel.add(menuSearchTextField, c);
		
		searchMenuByNumber = new JButton("Select");
		searchMenuByNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
		searchMenuByNumber.setFont(buttonFont);
		searchMenuByNumber.setActionCommand("SearchMenuByNumber");
		searchMenuByNumber.setPreferredSize(smallButtonSize);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(0, 0, 20, 0);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomMiddlePanel.add(searchMenuByNumber, c);
		
		menuListModel = new DefaultListModel<Database.Item>();
		updateIndexes(this.menu);
		menuList = new JList<Database.Item>(menuListModel);
		menuList.setFont(new Font(styleSettings.getDefaultFont(), Font.BOLD, styleSettings.getDefaultSize()));
		menuList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		menuList.setLayoutOrientation(JList.VERTICAL);
		menuList.setVisibleRowCount(-1);
		JScrollPane menuListScroller = new JScrollPane(menuList);
		menuListScroller.setPreferredSize(new Dimension(200, 300));
		menuListScroller.setViewportView(menuList);
		menuListScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomMiddlePanel.add(menuListScroller, c);
		
		JPanel bottomRightPanel = new JPanel();
		GridBagLayout bottomRightPanelLayout = new GridBagLayout();
		bottomRightPanel.setLayout(bottomRightPanelLayout);
		TitledBorder bottomRightPanelTitle;
		bottomRightPanelTitle = BorderFactory.createTitledBorder("Order");
		bottomRightPanelTitle.setTitleFont(textFont);
		bottomRightPanel.setBorder(bottomRightPanelTitle);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.34;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_END;
		bottomPanel.add(bottomRightPanel, c);
		
		orderListModel = new DefaultListModel<String>();
		orderList = new JList<String>(orderListModel);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		orderList.setLayoutOrientation(JList.VERTICAL);
		orderList.setVisibleRowCount(-1);
		JScrollPane orderListScroller = new JScrollPane(orderList);
		orderListScroller.setPreferredSize(new Dimension(200, 300));
		orderListScroller.setViewportView(orderList);
		orderListScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.insets = new Insets(0, 0, 0, 20);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(orderListScroller, c);
		
		addMenuItem = new JButton("Add");
		addMenuItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		addMenuItem.setFont(buttonFont);
		addMenuItem.setActionCommand("AddMenuItemToOrder");
		addMenuItem.setPreferredSize(largeButtonSize);
		addMenuItem.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.weighty = 0.33;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		bottomRightPanel.add(addMenuItem, c);
		
		editMenuItem = new JButton("Edit");
		editMenuItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		editMenuItem.setFont(buttonFont);
		editMenuItem.setActionCommand("EditMenuItemInOrder");
		editMenuItem.setPreferredSize(largeButtonSize);
		editMenuItem.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.weighty = 0.33;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		bottomRightPanel.add(editMenuItem, c);
		
		deleteMenuItem = new JButton("Delete");
		deleteMenuItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteMenuItem.setFont(buttonFont);
		deleteMenuItem.setActionCommand("DeleteMenuItemFromOrder");
		deleteMenuItem.setPreferredSize(largeButtonSize);
		deleteMenuItem.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.weighty = 0.33;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		bottomRightPanel.add(deleteMenuItem, c);
		
		finaliseOrder = new JButton("Finalise");
		finaliseOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		finaliseOrder.setFont(buttonFont);
		finaliseOrder.setActionCommand("FinaliseOrder");
		finaliseOrder.setPreferredSize(largeButtonSize);
		finaliseOrder.setEnabled(false);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.insets = new Insets(12, 0, 0, 20);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		bottomRightPanel.add(finaliseOrder, c);
		
		return orderListPanel;
	}
	
	private JPanel createMenuItemPanel() {
		return new JPanel();
	}
	
	private JPanel createOrderSummaryPanel() {
		return new JPanel();
	}
	
	private StyleSettings styleSettings;
	private Database.Item[] menu;
	private Database.Customer customer;
	public Database.Order order;
	
	private String[] screens;
	private String currentScreen;
	
	public NewOrderDialog dialog;
	
	private CardLayout cardLayout;
	private JPanel orderTypePanel, phoneNumberPanel, customerDetailsPanel, orderListPanel, menuItemPanel, orderSummaryPanel;
	public JButton backToMainMenuFromOrderTypeScreen, backToMainMenuFromPhoneNumberScreen, backToMainMenuFromCustomerDetailsScreen, backToMainMenuFromOrderListScreen,
		takeaway, homeDelivery, confirmPhoneNumber, confirmCustomerDetails, searchMenuByNumber, addMenuItem, editMenuItem, deleteMenuItem, finaliseOrder;
	public JTextField phoneNumberTextField, addressTextField, creditCardNumberTextField, menuSearchTextField;
	public JLabel phoneNumberText, phoneNumberOrderScreen, addressOrderScreen, creditCardDetailsOrderScreen;
	public JComboBox creditCardType, creditCardExpiryMonth, creditCardExpiryYear;
	private String[] creditCardTypes;
	private String[] months;
	private String[] years;
	public JList<Database.Item> menuList;
	public JList<String> orderList; 
	public DefaultListModel<Database.Item> menuListModel;
	public DefaultListModel<String> orderListModel; 
	private Dimension backButtonSize, smallButtonSize, largeButtonSize, textFieldSize, smallTextFieldSize, largeLabelSize;

	public NewOrder(StyleSettings styleSettings, Database.Item[] menu) {
		super();
		this.styleSettings = styleSettings;
		this.menu = menu;
		this.customer = new Database.Customer("", "", "");
		this.order = new Database.Order();
		this.dialog = new NewOrderDialog(this);
		this.backButtonSize = new Dimension(65, 25);
		this.largeButtonSize = new Dimension(120, 50);
		this.smallButtonSize = new Dimension(75, 24);
		this.textFieldSize = new Dimension(300, 25);
		this.smallTextFieldSize = new Dimension(200, 25);
		this.largeLabelSize = new Dimension(200, 50);
		
		this.screens = new String[] {
				"OrderTypePanel",		// 0
				"PhoneNumberPanel",		// 1
				"CustomerDetailsPanel",	// 2
				"OrderListPanel",		// 3
				"MenuItemPanel",		// 4
				"OrderSummaryPanel"};	// 5
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		
		this.creditCardTypes = new String[]{"VISA", "Master Card", "American Express"};
		this.months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		this.years = new String[50];
		int i;
		for(i = 0; i < 50; i++) {
			years[i] = new String("");
			years[i] += (i + 2016);
		}
		
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
