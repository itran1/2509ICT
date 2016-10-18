package Database;

public class Item {
    private String name;
    private int price;		// in cents
    private int number;		// menu item number
    						// need to add get/set and update the calls in Database.java
    
    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    
    public void updatePrice(int price){
        this.price = price;
    }
    
    public int getPrice(){
        return price;
    }
    
    /* Added by David
     * 19/07/2016
     * Notes:
     * Editing screen needs this function.
     */
    public void updateName(String name) {
    	this.name = new String(name);
    }
    
    public String getName(){
        return name;
    }
    
    /* Added by David
     * 19/07/2016
     * Notes:
     * Editing screen needs this function.
     */
    public String toString() {
    	String readable = name + ": $" + Integer.toString(price/100) + "." + Integer.toString(price % 100);
    	if(price%100 == 0) {
    		readable += "0";
    	}
    	return readable;
    }
}