package ui;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

@SuppressWarnings("serial")
public class MenuItems extends JPanel {
	
	public void updateIndexes(Database.Item[] menu) {
		
		
		menuListModel.removeAllElements();
		if(menu.length > 0) {
			for(int i = 0; i < menu.length; i++) {
				menuListModel.addElement(new Database.Item(i, menu[i].getName(), menu[i].getPrice()));
			}
		}
	}
	
	public void enableEditing(boolean enabled) {
		this.nameLabel.setEnabled(enabled);
		this.nameTextField.setEnabled(enabled);
		this.priceLabel.setEnabled(enabled);
		this.priceTextField.setEnabled(enabled);
		this.saveMenuItem.setEnabled(enabled);
		this.cancelMenuItem.setEnabled(enabled);
	}
	
	public void cleanUp() {
		enableEditing(false);
		this.menuList.clearSelection();
		this.nameTextField.setText("");
		this.priceTextField.setText("");
	}
	
	private void createNameLabel(JPanel parent) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		Font textFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(textFont);
		nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		nameLabel.setEnabled(false);
		parent.add(nameLabel, c);
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
		nameTextField = new JTextField();
		nameTextField.setFont(textFont);
		nameTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		nameTextField.setPreferredSize(textFieldSize);
		nameTextField.setEnabled(false);
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
		priceLabel = new JLabel("Price $(xx.xx):");
		priceLabel.setFont(textFont);
		priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		priceLabel.setEnabled(false);
		parent.add(priceLabel, c);
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
		priceTextField = new JTextField();
		priceTextField.setFont(textFont);
		priceTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		priceTextField.setPreferredSize(textFieldSize);
		priceTextField.setEnabled(false);
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
		saveMenuItem = new JButton("Save");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		saveMenuItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		saveMenuItem.setFont(buttonFont);
		saveMenuItem.setActionCommand("SaveMenuItem");
		saveMenuItem.setPreferredSize(largeButtonSize);
		saveMenuItem.setEnabled(false);
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
		cancelMenuItem = new JButton("Cancel");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		cancelMenuItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancelMenuItem.setFont(buttonFont);
		cancelMenuItem.setActionCommand("CancelMenuItem");
		cancelMenuItem.setPreferredSize(largeButtonSize);
		cancelMenuItem.setEnabled(false);
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
		createNewMenuItem = new JButton("Create New");
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
		editMenuItem = new JButton("Edit");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		editMenuItem.setAlignmentX(Component.RIGHT_ALIGNMENT);
		editMenuItem.setFont(buttonFont);
		editMenuItem.setActionCommand("EditMenuItem");
		editMenuItem.setPreferredSize(largeButtonSize);
		editMenuItem.setEnabled(false);
		parent.add(editMenuItem, c);
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
		deleteMenuItem = new JButton("Delete");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize());
		deleteMenuItem.setAlignmentX(Component.RIGHT_ALIGNMENT);
		deleteMenuItem.setFont(buttonFont);
		deleteMenuItem.setActionCommand("DeleteMenuItem");
		deleteMenuItem.setPreferredSize(largeButtonSize);
		deleteMenuItem.setEnabled(false);
		parent.add(deleteMenuItem, c);
	}
	
	private void createMenuList(JPanel parent) {

		menuListModel = new DefaultListModel<Database.Item>();
		updateIndexes(this.menu);
		
		menuList = new JList<Database.Item>(menuListModel);
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
		backToMainMenu = new JButton("Back");
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
	
	private Database.Item[] menu;
	private StyleSettings styleSettings;
	
	public MenuItemsDialog dialog;
	
	private Dimension backButtonSize;
	private Dimension largeButtonSize;
	private Dimension textFieldSize;
	
	public JButton backToMainMenu;
	public JButton createNewMenuItem;
	public JButton editMenuItem;
	public JButton deleteMenuItem;
	public JButton saveMenuItem;
	public JButton cancelMenuItem;
	
	public JLabel nameLabel;
	public JLabel priceLabel;
	
	public JTextField nameTextField;
	public JTextField priceTextField;
	
	public JList<Database.Item> menuList;
	public DefaultListModel<Database.Item> menuListModel; 
	
	public boolean creatingNew;
	public boolean editingExisting;
	
	public MenuItems(StyleSettings styleSettings, Database.Item[] menu) {
		super();
		this.styleSettings = styleSettings;
		this.menu = menu;
		this.dialog = new MenuItemsDialog(this);
		this.backButtonSize = new Dimension(65, 25);
		this.largeButtonSize = new Dimension(120, 50);
		this.textFieldSize = new Dimension(300, 25);
		this.creatingNew = false;
		this.editingExisting = false;
		createMenuItemsPanel();
	}

}
