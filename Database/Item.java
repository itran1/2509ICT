package Database;

/**
 * The Item Class.
 * @author Sean Doran, Christain Miles, David Moschner and Ian Tran
 */
public class Item {
    
    /** The name of of a menu item as a String. */
    private String name;
    
    /** The price of a menu item as an Integer. */
    private int price;		// in cents
    
    /** The number of a menu item as an Integer. */
    private int number;
    
    /**
     * Instantiates a new menu item.
     *
     * @param number The number of a menu item as an Integer.
     * @param name The name of a menu item as a String.
     * @param price The price of a menu item as a Integer.
     */
    public Item(int number, String name, int price){
    	this.number = number;
        this.name = name;
        this.price = price;
    }
    
    /**
     * Updates the price of a menu item as an Integer.
     *
     * @param price The price of a menu item as an Integer.
     */
    public void updatePrice(int price){
        this.price = price;
    }
    
    /**
     * Gets the price of a menu item as an Integer.
     *
     * @return The price of a menu item as an Integer.
     */
    public int getPrice(){
        return price;
    }
    
    /**
     * Updates the name of a menu item as a String.
     *
     * @param name The name of a menu item as a String.
     */
    public void updateName(String name) {
    	this.name = new String(name);
    }
    
    /**
     * Gets the name of a menu item as a String.
     *
     * @return The name of a menu item as a String.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets The number of a menu item as an Integer.
     *
     * @return The number of a menu item as an Integer.
     */
    public int getNumber() {
    	return this.number;
    }
    
    /**
     * To string.
     *
     * @return A readable String of Item number, name and price.
     */
    public String toString() {
    	String readable = getNumber() + ": " + name + " - $" + Integer.toString(price/100) + "." + Integer.toString(price % 100);
    	if(price%100 == 0) {
    		readable += "0";
    	}
    	return readable;
    }
}