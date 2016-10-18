package ui;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

@SuppressWarnings("serial")
public class MenuItems extends JPanel {
	
	private void createNameLabel(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		Font textFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		JLabel l = new JLabel("Name:");
		l.setFont(textFont);
		l.setAlignmentX(Component.LEFT_ALIGNMENT);
		parent.add(l, c);
	}
	
	private void createNameTextField(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.insets = new Insets(0, 0, 20, 0);
		Font textFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		JTextField nameTextField = new JTextField();
		nameTextField.setFont(textFont);
		nameTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		nameTextField.setPreferredSize(textFieldSize);
		parent.add(nameTextField, c);
	}
	
	private void createPriceLabel(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		Font textFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		JLabel l = new JLabel("Price $(xx.xx):");
		l.setFont(textFont);
		l.setAlignmentX(Component.LEFT_ALIGNMENT);
		parent.add(l, c);
	}
	
	private void createPriceTextField(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		Font textFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		JTextField priceTextField = new JTextField();
		priceTextField.setFont(textFont);
		priceTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		priceTextField.setPreferredSize(textFieldSize);
		parent.add(priceTextField, c);
	}
	
	private void createSaveButton(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(20, 20, 0, 0);
		JButton saveMenuItem = new JButton("Save");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		saveMenuItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		saveMenuItem.setFont(buttonFont);
		saveMenuItem.setActionCommand("SaveMenuItem");
		saveMenuItem.setPreferredSize(largeButtonSize);
		parent.add(saveMenuItem, c);
	}
	
	private void createCancelButton(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(20, 20, 0, 0);
		JButton cancelMenuItem = new JButton("Cancel");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		cancelMenuItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancelMenuItem.setFont(buttonFont);
		cancelMenuItem.setActionCommand("CancelMenuItem");
		cancelMenuItem.setPreferredSize(largeButtonSize);
		parent.add(cancelMenuItem, c);
	}
	
	private void createRightPanel() {
		JPanel rightPanel = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.35;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		this.add(rightPanel, c);
		TitledBorder rightPanelTitle;
		rightPanelTitle = BorderFactory.createTitledBorder("Edit Menu Item");
		rightPanelTitle.setTitleFont(new Font(this.styleSettings.getDefaultFont(), Font.BOLD, this.styleSettings.getDefaultSize()));
		rightPanel.setBorder(rightPanelTitle);
		JPanel rightPanelContent = new JPanel();
		GridBagLayout rightPanelContentLayout = new GridBagLayout();
		rightPanelContent.setLayout(rightPanelContentLayout);

		rightPanelContent.setAlignmentY(CENTER_ALIGNMENT);
		rightPanelContent.setPreferredSize(new Dimension(300, 200));
		rightPanel.add(rightPanelContent);
		
		createNameLabel(rightPanelContent);
		createNameTextField(rightPanelContent);
		createPriceLabel(rightPanelContent);
		createPriceTextField(rightPanelContent);
		createSaveButton(rightPanelContent);
		createCancelButton(rightPanelContent);
	}
	
	private void createAddButton(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.weighty = 0.40;
		c.insets = new Insets(20, 20, 0, 0);
		JButton createNewMenuItem = new JButton("Create New");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		createNewMenuItem.setAlignmentX(Component.RIGHT_ALIGNMENT);
		createNewMenuItem.setFont(buttonFont);
		createNewMenuItem.setActionCommand("CreateNewMenuItem");
		createNewMenuItem.setPreferredSize(largeButtonSize);
		parent.add(createNewMenuItem, c);
	}
	
	private void createEditButton(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 0.20;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 20, 0, 0);
		JButton createNewMenuItem = new JButton("Edit");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		createNewMenuItem.setAlignmentX(Component.RIGHT_ALIGNMENT);
		createNewMenuItem.setFont(buttonFont);
		createNewMenuItem.setActionCommand("EditMenuItem");
		createNewMenuItem.setPreferredSize(largeButtonSize);
		parent.add(createNewMenuItem, c);
	}
	
	private void createDeleteButton(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 0.40;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.insets = new Insets(0, 20, 20, 0);
		JButton createNewMenuItem = new JButton("Delete");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		createNewMenuItem.setAlignmentX(Component.RIGHT_ALIGNMENT);
		createNewMenuItem.setFont(buttonFont);
		createNewMenuItem.setActionCommand("DeleteMenuItem");
		createNewMenuItem.setPreferredSize(largeButtonSize);
		parent.add(createNewMenuItem, c);
	}
	
	private void createMenuList(JPanel parent) {

		DefaultListModel<Database.Item> menuListModel = new DefaultListModel<Database.Item>();
		for(int i = 1; i <= 200; i++) {
			menuListModel.addElement(new Database.Item("Menu Item", i*10));
		}
		JList<Database.Item> menuList = new JList<Database.Item>(menuListModel);
		menuList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		menuList.setLayoutOrientation(JList.VERTICAL);
		menuList.setVisibleRowCount(-1);
		JScrollPane menuListScroller = new JScrollPane(menuList);
		menuListScroller.setPreferredSize(new Dimension(250, 300));
		menuListScroller.setViewportView(menuList);
		menuListScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(20, 20, 20, 0);
		parent.add(menuListScroller, c);
	}
	
	private void createLeftPanel() {
		JPanel leftPanel = new JPanel();
		GridBagLayout leftPanelLayout = new GridBagLayout();
		leftPanel.setLayout(leftPanelLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.65;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(leftPanel, c);
		
		createMenuList(leftPanel);
		createAddButton(leftPanel);
		createEditButton(leftPanel);
		createDeleteButton(leftPanel);
	}
	
	private void createTopPanelFiller(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0, 0, 0, 10);
		JPanel topPanelFiller = new JPanel();
		topPanelFiller.setPreferredSize(backButtonSize);
		parent.add(topPanelFiller, c);
	}
	
	private void createSubHeading(JPanel parent) {
		Font screenFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, 24);
		JLabel l = new JLabel("Edit Menu Items");
		l.setFont(screenFont);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_END;
		parent.add(l, c);
	}
	
	private void createMainHeading(JPanel parent) { 
		GridBagConstraints c = new GridBagConstraints();
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
		parent.add(l, c);
	}
	
	private void createBackButton(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 10, 0, 0);
		JButton backToMainMenu = new JButton("Back");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		backToMainMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
		backToMainMenu.setFont(buttonFont);
		backToMainMenu.setActionCommand("BackToMainMenu");
		backToMainMenu.setPreferredSize(backButtonSize);
		parent.add(backToMainMenu, c);
	}
	
	private void createTopPanel() {
		JPanel topPanel = new JPanel();
		GridBagLayout topPanelLayout = new GridBagLayout();
		topPanel.setLayout(topPanelLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1.0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		this.add(topPanel, c);
		
		createBackButton(topPanel);
		createMainHeading(topPanel);
		createSubHeading(topPanel);
		createTopPanelFiller(topPanel);
	}
	
	private void createMenuItemsPanel() {
		GridBagLayout menuItemsLayout = new GridBagLayout();
		this.setLayout(menuItemsLayout);
		
		createTopPanel();
		createLeftPanel();
		createRightPanel();
	}
	
	private StyleSettings styleSettings;
	private Dimension backButtonSize;
	private Dimension largeButtonSize;
	private Dimension textFieldSize;
	
	public MenuItems(StyleSettings styleSettings) {
		super();
		this.styleSettings = styleSettings;
		this.backButtonSize = new Dimension(65, 25);
		this.largeButtonSize = new Dimension(120, 50);
		this.textFieldSize = new Dimension(300, 25);
		createMenuItemsPanel();
	}

}
