package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIController implements ActionListener {
	//private Model model;
	// need model here for other screens
	// this includes customers and menu items
	
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
		
		styleSettings = new StyleSettings();
		
		views = new JPanel[] {
				(JPanel)new MainMenu(styleSettings),
				(JPanel)new MainMenu(styleSettings), // replace with order screen
				(JPanel)new MenuItems(styleSettings)
				// other screens added here
		};
		
		((MainMenu)views[0]).newOrder.addActionListener(this);
		((MainMenu)views[0]).editMenuItems.addActionListener(this);
		((MainMenu)views[0]).viewDailyReport.addActionListener(this);
		
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
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand().equals(screens[2])) {
			currentScreen = screens[2];
			cardLayout.show(cardPanel, currentScreen);
		}
		
	}

}
