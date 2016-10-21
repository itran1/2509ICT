package Database;

import java.util.*;

/**
 * The Order Class.
 * @author Sean Doran, Christain Miles, David Moschner and Ian Tran
 */
public class Order {
	
	/** The items in an order consisting of item name and quantity. */
	public Map<Item,Integer> items;
	
	/**
	 * The Enum OrderType.
	 */
	public enum OrderType {
/** The take away order type. Signifying that an order is take away. */
TAKEAWAY, 
 /** The home delivery order type. Signifying that an order is home delivery. */
 HOME_DELIVERY};
	
	/** The order type of an order being TAKEAWAY or HOME_DELIVERY. */
	private OrderType orderType;
	
	/** The customer who is connected to an order. */
	private Customer customer;
	
	/** The total amount of money made on all orders. */
	private int total;
	
	/** The date of an order. */
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
	 * @param date The date of an order.
	 * @param orderType The order type of an order being TAKEAWAY or HOME_DELIVERY.
	 * @param total The total amount of money made on all orders.
	 * @param customer The customer connected to an order.
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
	 * Gets the total amount of money made on all orders.
	 *
	 * @return The total amount of money made on all orders.
	 */
	public int getTotal(){
		return this.total;
	}
	
	/**
	 * Computes the total amount of money made on all orders.
	 *
	 * @return The total amount of money made on all orders.
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
	 * Adds an item into an order.
	 *
	 * @param item an item in an order.
	 * @param q The quantity of an item in an order.
	 */
	public void addItem(Item item, int q){
		items.put(item, q);
	}
	
	/**
	 * Removes an item from an order.
	 *
	 * @param item An item in an order.
	 */
	public void removeItem(Item item){
		items.remove(item);
	}
	
	/**
	 * Gets the quantity of an item in an order.
	 *
	 * @param item An item in an order.
	 * @return The quantity of the item needed for an order.
	 */
	public int getQuantity(Item item){
		return 	items.get(item);
	}
	
	/**
	 * Sets the quantity of an item in an order.
	 *
	 * @param item An item in an order. 
	 * @param q The quantity of an item in the order.
	 */
	public void setQuantity(Item item, int q) {
		items.put(item, q);
	}
	
	/**
	 * Removes all items from an order.
	 */
	public void clearOrder(){
		items.clear();
	}
	
	/**
	 * Gets the type order either being TAKEAWAY or HOME_DELIVERY.
	 *
	 * @return The order type being TAKEAWAY or HOME_DELIVERY.
	 */
	public OrderType getOrderType() {
		return this.orderType;
	}
	
	/**
	 * Sets the type order either being TAKEAWAY or HOME_DELIVERY.
	 *
	 * @param orderType The new order type being TAKEAWAY or HOME_DELIVERY.
	 */
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	/**
	 * Sets the date of an order as a String. 
	 *
	 * @param date The date of an order as a String. 
	 */
	public void setDate(String date){
		this.date = date;
	}
	
	/**
	 * Gets the customer connected to an order.
	 *
	 * @return The customer connected to an order.
	 */
	public Customer getCustomer(){
		return this.customer;
	}
	
	/**
	 * Gets an array of Strings containing items, quantities and subtotal.
	 *
	 * @return An Array of Strings containing items, quantities and subtotal.
	 */
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