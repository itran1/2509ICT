package ui;

import java.io.File;
import java.io.IOException;

public class SampleMenu {

	public SampleMenu() {
		super();
	}
	
	public static void loadSampleData() {
		File menuDB = new File("menuDB.sv");
		menuDB.delete();
		try {
			menuDB.createNewFile();
		} catch(IOException e) {
			
		}
		Database.Database db = new Database.Database();
		db.addItem("Chicken Spring Rolls (4 pack)", 790);
		db.addItem("Dim Sim (4 pack)", 790);
		db.addItem("Chicken Satay Sticks", 790);
		db.addItem("Coconut King Prawn (4 pack)", 890);
		db.addItem("Sesame Prawn Toast (4 pack)", 890);
		db.addItem("Chicken & Sweet Corn Soup", 590);
		db.addItem("Crab Meat & Sweet Corn Soup", 590);
		db.addItem("Chicken Rice Noodle Soup", 1190);
		db.addItem("BBQ Pork with Long & Short Soup", 1350);
		db.addItem("Vermicelli with Sugarcane Prawn", 1550);
		db.addItem("Vermicelli with Grilled Pork Chop", 1350);
		db.addItem("Grilled Chicken Rice Paper Wraps", 1750);
		db.addItem("Satay King Prawn Rice Paper Wraps", 1950);
		db.addItem("Chow Mein with Beef", 1650);
		db.addItem("Chow Mein with Chicken", 1650);
		db.addItem("Chow Mein with BBQ Pork", 1650);
		db.addItem("Chow Mein with King Prawns", 1650);
		db.addItem("Chow Mein with Combination", 1650);
		db.addItem("Hokkien Noodle with Beef", 1650);
		db.addItem("Hokkien Noodle with Chicken", 1650);
		db.addItem("Hokkien Noodle with BBQ Pork", 1650);
		db.addItem("Hokkien Noodle with King Prawns", 1650);
		db.addItem("Hokkien Noodle with Combination", 1650);
		db.addItem("Hofun Noodle with Beef", 1650);
		db.addItem("Hofun Noodle with Chicken", 1650);
		db.addItem("Hofun Noodle with BBQ Pork", 1650);
		db.addItem("Hofun Noodle with King Prawns", 1650);
		db.addItem("Hofun Noodle with Combination", 1650);
		db.addItem("Mongolian Beef", 1650);
		db.addItem("Honey Chicken", 1550);
		db.addItem("Deep Fried Crispy Chicken", 1650);
		db.addItem("Lemon Roast Duck", 1950);
		db.addItem("Curry Lamb", 1950);
		db.addItem("Sweet & Sour Pork", 1550);
		db.addItem("Filleted Fish Salt & Pepper", 1990);
		db.addItem("Deep Fried Whole Flounder (Sole Fish)", 2490);
		db.addItem("King Prawn in Salt & Pepper", 1950);
		db.addItem("Calamari in Salt & Pepper", 1850);
		db.addItem("Seafood Tofu and Vegetable", 1950);
		db.addItem("Crab Soft Shell in Salt & Pepper", 2050);
		db.addItem("Moreton Bay Bug with Chilli", 2950);
		db.addItem("Steamed Rice", 300);
		db.addItem("Special Fried Rice", 1150);
		db.addItem("Vegetable Omelette", 1250);
		db.addItem("Family Pack A (4 Spring Rolls, Honey Chicken, Mongolian Beef, Steamed Rice)", 3800);
		db.addItem("Family Pack B (6 Wontons, 4 Sesame Prawn Toast, Deep Fried Crispy Skin Chicken, Singapore Noodles, 2 Drink Cans)", 4700);
	}
}
