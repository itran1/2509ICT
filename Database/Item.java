package Database;

/**
 * The Class Item.
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
     * @param number the number
     * @param name the name
     * @param price the price
     */
    public Item(int number, String name, int price){
    	this.number = number;
        this.name = name;
        this.price = price;
    }
    
    /**
     * Update price.
     *
     * @param price the price
     */
    public void updatePrice(int price){
        this.price = price;
    }
    
    /**
     * Gets the price.
     *
     * @return the price
     */
    public int getPrice(){
        return price;
    }
    
    /**
     * Update name.
     *
     * @param name the name
     */
    public void updateName(String name) {
    	this.name = new String(name);
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the number.
     *
     * @return the number
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