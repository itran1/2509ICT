package Database;

/**
 * The Item Class.
 * @author Sean Doran, Christain Miles, David Moschner and Ian Tran
 */
public class Item {
    
    /** The name. */
    private String name;
    
    /** The price. */
    private int price;		// in cents
    
    /** The number. */
    private int number;
    
    /**
     * Instantiates a new item.
     *
     * @param number The number
     * @param name The name
     * @param price The price
     */
    public Item(int number, String name, int price){
    	this.number = number;
        this.name = name;
        this.price = price;
    }
    
    /**
     * Updates the item price.
     *
     * @param price The item price
     */
    public void updatePrice(int price){
        this.price = price;
    }
    
    /**
     * Gets the item price.
     *
     * @return The item price
     */
    public int getPrice(){
        return price;
    }
    
    /**
     * Updates the item name.
     *
     * @param name The item name
     */
    public void updateName(String name) {
    	this.name = new String(name);
    }
    
    /**
     * Gets the item name.
     *
     * @return The item name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets The item number.
     *
     * @return The item number
     */
    public int getNumber() {
    	return this.number;
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
    	String readable = getNumber() + ": " + name + " - $" + Integer.toString(price/100) + "." + Integer.toString(price % 100);
    	if(price%100 == 0) {
    		readable += "0";
    	}
    	return readable;
    }
}