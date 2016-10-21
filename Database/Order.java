package Database;

import java.util.*;

/**
 * The Class Order.
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
	
	/** The total. */
	private int total = 0; //Instantiated as to avoid null
	
	/** The date. */
	private String date;
	
	/**
	 * Instantiates a new order.
	 */
	public Order() {
		this.items = new HashMap<Item, Integer>();
		
	}
	
	/**
	 * Instantiates a new order.
	 *
	 * @param date the date
	 * @param orderType the order type
	 * @param total the total
	 * @param customer the customer
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
	 * Gets the total.
	 *
	 * @return the total
	 */
	public int getTotal(){
		return this.total;
	}
	
	/**
	 * Compute total.
	 *
	 * @return the int
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
	 * @param item the item
	 * @param q the q
	 */
	public void addItem(Item item, int q){
		items.put(item, q);
	}
	
	/**
	 * Removes the item.
	 *
	 * @param item the item
	 */
	public void removeItem(Item item){
		items.remove(item);
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @param item the item
	 * @return the quantity
	 */
	public int getQuantity(Item item){
		return 	items.get(item);
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param item the item
	 * @param q the q
	 */
	public void setQuantity(Item item, int q) {
		items.put(item, q);
	}
	
	/**
	 * Clear order.
	 */
	public void clearOrder(){
		items.clear();
	}
	
	/**
	 * Gets the order type.
	 *
	 * @return the order type
	 */
	public OrderType getOrderType() {
		return this.orderType;
	}
	
	/**
	 * Sets the order type.
	 *
	 * @param orderType the new order type
	 */
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date){
		this.date = date;
	}
	
	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer(){
		return this.customer;
	}
}