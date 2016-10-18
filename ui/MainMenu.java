package ui;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	
	public JButton newOrder;
	public JButton editMenuItems;
	public JButton viewDailyReport;
	
	private StyleSettings styleSettings;
	
	public MainMenu(StyleSettings styleSettings) {
		super();
		setLayout(new GridBagLayout());
		this.styleSettings = styleSettings;
		
		Font headingFont = new Font(this.styleSettings.getDefaultFont(), Font.BOLD, 36);
		JLabel l = new JLabel("Ordering System");
		l.setFont(headingFont);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(20, 0, 0, 0);
		add(l, c);
		
		Font screenFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, 24);
		l = new JLabel("Main Menu");
		l.setFont(screenFont);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_END;
		add(l, c);
		
		newOrder = new JButton("New Order");
		Font buttonFont = new Font(this.styleSettings.getDefaultFont(), Font.PLAIN, this.styleSettings.getDefaultSize() + 2);
		newOrder.setFont(buttonFont);
		newOrder.setActionCommand("NewOrder");
		Dimension buttonSize = new Dimension(150, 50);
		newOrder.setPreferredSize(buttonSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 20);
		add(newOrder, c);
		
		editMenuItems = new JButton("Edit Menu Items");
		editMenuItems.setFont(buttonFont);
		editMenuItems.setActionCommand("EditMenuItems");
		editMenuItems.setPreferredSize(buttonSize);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		add(editMenuItems, c);
		
		viewDailyReport = new JButton("View Daily Report");
		viewDailyReport.setFont(buttonFont);
		viewDailyReport.setActionCommand("ViewDailyReport");
		viewDailyReport.setPreferredSize(buttonSize);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 20, 0, 0);
		add(viewDailyReport, c);
	}
}
