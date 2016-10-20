package Database;

import java.util.*;

public class Order {
	public Map<Item,Integer> items;
	public enum OrderType {TAKEAWAY, HOME_DELIVERY};
	private OrderType orderType;
	private Customer customer;
	private int total = 0; //Instantiated as to avoid null
	private String date;
	
	public Order(OrderType orderType) {
		this.items = new HashMap<Item, Integer>();
		this.orderType = orderType;
	}
	
	//Made for database reinitialisation
	public Order(String date, String orderType, int total, Customer customer){
		this(OrderType.valueOf(orderType));
		this.total = total;
		this.customer = customer;
		this.date = date;
	}
	
	public int getTotal(){
		int total = 0;
		Item[] keys = items.keySet().toArray(new Item[items.size()]);
		
		for(int i = 0; i<keys.length; i++){
			total += keys[i].getPrice()*items.get(keys[i]);
		}
		
		this.total = total;
		return total;
	}

	public void addItem(Item item, int q){
		items.put(item, q);
	}
	
	public void removeItem(Item item){
		items.remove(item);
	}
	
	public int getQuantity(Item item){
		return 	items.get(item);
	}
	
	public void setQuantity(Item item, int q) {
		items.put(item, q);
	}
	
	public void clearOrder(){
		items.clear();
	}
	
	public OrderType getOrderType() {
		return this.orderType;
	}
	
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
}