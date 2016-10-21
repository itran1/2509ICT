package Database;

import java.util.*;

/**
 * The Order Class .
 * @author Sean Doran, Christain Miles, David Moschner and Ian Tran
 */
public class Order {
	
	/** The items. */
	public Map<Item,Integer> items;
	
	/**
	 * The Enum OrderType.
	 */
	public enum OrderType {
/** The takeaway. */
TAKEAWAY, 
 /** The home delivery. */
 HOME_DELIVERY};
	
	/** The order type. */
	private OrderType orderType;
	
	/** The customer. */
	private Customer customer;
	
	/** The total price of all orders. */
	private int total;
	
	/** The date of the order. */
	private String date;
	
	/**
	 * Instantiates a new order.
	 */
	public Order() {
		this.items = new HashMap<Item, Integer>();
		this.total = 0;
	}
	
	/**
	 * Instantiates a new order.
	 *
	 * @param date The date
	 * @param orderType the order type
	 * @param total The total
	 * @param customer The customer
	 */
	//Made for database reinitialisation
	public Order(String date, String orderType, int total, Customer customer){
		this();
		this.orderType = OrderType.valueOf(orderType);
		this.total = total;
		this.customer = customer;
		this.date = date;
	}
	
	/**
	 * Gets the daily total of orders.
	 *
	 * @return The total
	 */
	public int getTotal(){
		return this.total;
	}
	
	/**
	 * Computes the daily total of orders.
	 *
	 * @return The int
	 */
	public int computeTotal(){
		int total = 0;
		Item[] keys = items.keySet().toArray(new Item[items.size()]);
		
		for(int i = 0; i<keys.length; i++){
			total += keys[i].getPrice()*items.get(keys[i]);
		}
		
		this.total = total;
		return total;
	}

	/**
	 * Adds the item.
	 *
	 * @param item The item
	 * @param q The quantity
	 */
	public void addItem(Item item, int q){
		items.put(item, q);
	}
	
	/**
	 * Removes the item.
	 *
	 * @param item The item
	 */
	public void removeItem(Item item){
		items.remove(item);
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @param item the item
	 * @return The quantity of the item needed for the order
	 */
	public int getQuantity(Item item){
		return 	items.get(item);
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param item the item
	 * @param q The quantity
	 */
	public void setQuantity(Item item, int q) {
		items.put(item, q);
	}
	
	/**
	 * Removes all items from the order.
	 */
	public void clearOrder(){
		items.clear();
	}
	
	/**
	 * Gets the type order. the order Type being TAKEAWAY or HOME_DELIVERY
	 *
	 * @return The order type
	 */
	public OrderType getOrderType() {
		return this.orderType;
	}
	
	/**
	 * Sets the type order . the order Type being TAKEAWAY or HOME_DELIVERY
	 *
	 * @param orderType The new order type
	 */
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	/**
	 * Sets the date as a String. 
	 *
	 * @param date The new date
	 */
	public void setDate(String date){
		this.date = date;
	}
	
	/**
	 * Gets the customer.
	 *
	 * @return The customer
	 */
	public Customer getCustomer(){
		return this.customer;
	}
	
	public String[] getItems() {
		int i;
		String[] readable = new String[items.size()];
		Item[] keys = items.keySet().toArray(new Item[items.size()]);
		for(i = 0; i < keys.length; i++) {
			readable[i] = this.getQuantity(keys[i]) + "x " + keys[i].getNumber() + ": " + keys[i].getName() + " - $";
			int price = keys[i].getPrice();
			int subTotal = price * getQuantity(keys[i]);
			readable[i] += Integer.toString(subTotal/100) + "." + Integer.toString(subTotal % 100);
	    	if(subTotal%100 == 0) {
	    		readable[i] += "0";
	    	}
		}
		return readable;
	}
}