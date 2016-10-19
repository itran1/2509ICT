package Database;

public class Item {
    private String name;
    private int price;		// in cents
    private int number;
    
    public Item(int number, String name, int price){
    	this.number = number;
        this.name = name;
        this.price = price;
    }
    
    public void updatePrice(int price){
        this.price = price;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void updateName(String name) {
    	this.name = new String(name);
    }
    
    public String getName(){
        return name;
    }
    
    public int getNumber() {
    	return this.number;
    }
    
    public String toString() {
    	String readable = getNumber() + ": " + name + " - $" + Integer.toString(price/100) + "." + Integer.toString(price % 100);
    	if(price%100 == 0) {
    		readable += "0";
    	}
    	return readable;
    }
}