package Database;

import java.util.*;

class Order {
	public Map<Item,Integer> items;
	public enum OrderType {TAKEAWAY, HOME_DELIVERY};
	private OrderType orderType;
	
	public Order() {
		items = new HashMap<Item,Integer>();
	}
	
	public Order(OrderType orderType) {
		this();
		this.orderType = orderType;
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
}