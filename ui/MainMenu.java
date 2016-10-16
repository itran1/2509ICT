package ui;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	
	public JButton newOrder;
	public JButton editMenuItems;
	public JButton viewDailyReport;
	
	public MainMenu() {
		super();
		setLayout(new GridBagLayout());
		
		Font headingFont = new Font("Comic Sans MS", Font.BOLD, 36);
		JLabel l = new JLabel("Ordering System");
		l.setFont(headingFont);
		l.setHorizontalAlignment(JLabel.CENTER);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_START;
		add(l, c);
		
		Font screenFont = new Font("Comic Sans MS", Font.PLAIN, 24);
		l = new JLabel("Main Menu");
		l.setFont(screenFont);
		l.setHorizontalAlignment(JLabel.CENTER);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.PAGE_START;
		add(l, c);
		
		newOrder = new JButton("New Order");
		Font buttonFont = new Font("Comic Sans MS", Font.PLAIN, 14);
		newOrder.setFont(buttonFont);
		newOrder.setActionCommand("neworder");
		Dimension buttonSize = new Dimension(150, 50);
		newOrder.setMinimumSize(buttonSize);
		newOrder.setMaximumSize(buttonSize);
		newOrder.setPreferredSize(buttonSize);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		add(newOrder, c);
		
		editMenuItems = new JButton("Edit Menu Items");
		editMenuItems.setFont(buttonFont);
		editMenuItems.setActionCommand("editmenuitems");
		editMenuItems.setMinimumSize(buttonSize);
		editMenuItems.setMaximumSize(buttonSize);
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
		viewDailyReport.setActionCommand("viewdailyreport");
		viewDailyReport.setMinimumSize(buttonSize);
		viewDailyReport.setMaximumSize(buttonSize);
		viewDailyReport.setPreferredSize(buttonSize);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		add(viewDailyReport, c);
	}
}
