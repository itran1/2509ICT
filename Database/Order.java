package Database;

import java.util.*;

class Order{
public Map<Item,Integer> map = new HashMap<Item,Integer>();
public Database DB = new Database();

public void addOrder(int i, int q){
	map.put(DB.getItem(i),q);
}

public void removeOrder(Item i){
	map.remove(i);
}
public int getQuantity(Item i){
	return 	map.get(i);
}

public void clearOrder(){
	map.clear();
}
}