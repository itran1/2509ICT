package Database;

import java.io.*;
import java.util.*;

public class Database {
    private File database;
    private File menuDB;
    private File orderDB;
    
    //Loads the database or builds a new one if it doesn't exist
    public Database(){
        database = new File("customerDB.sv");
        menuDB = new File("menuDB.sv");
        orderDB = new File("orderDB.sv");
        
        if(!database.exists()){
            
            try {
                database.createNewFile(); //Create a new customerDB if one doesn't already exist
                menuDB.createNewFile(); //Create a new menuDB if one doesn't already exist
                orderDB.createNewFile(); //Create a new orderDB if one doesn't already exist
            } catch (IOException e){}
            
        }
    }
    
    //Adds a new item to the menu
    public void addItem(String name, int price){
        int size = getMenuSize(); //Check the size of the database to know the next available index
        
        try {
            PrintWriter output = new PrintWriter(new FileWriter(menuDB,true)); //Opens a new PrintWriter in append mode
            output.println(size);
            output.println(name);
            output.println(price);
            output.close(); //Closes the PrintWriter
        } catch (FileNotFoundException e){} catch (IOException e){}
            
    }
    
    //Gets an item from the DB
    public Item getItem(int index){
        try {
            Scanner in = new Scanner(menuDB);
            int currIndex;
            
            while(in.hasNextLine()){
                currIndex = Integer.parseInt(in.nextLine()); //Sets the current index to the index read from the file (for comparison against the function input)
                
                if(currIndex == index){
                    Item found = new Item(currIndex, in.nextLine(), Integer.parseInt(in.nextLine())); //if the index is found, make a new item object and return it
                    return found;
                } else {
                    //Ignore data
                    in.nextLine();
                    in.nextLine();
                }
            }
        } catch(FileNotFoundException e){}
        
        return null; //If the item doesn't exist, return null
    }
    
    //Gets all menu items from the menuDB
    public Item[] getAllItems(){
        
        try{
            Scanner in = new Scanner(menuDB);
            ArrayList<Item> items = new ArrayList<Item>();
            
            while(in.hasNextLine()){
                // in.nextLine(); //Throw
            	// need this number in constructor now
                items.add(new Item(Integer.parseInt(in.nextLine()), in.nextLine(), Integer.parseInt(in.nextLine())));
            }
            
            return items.toArray(new Item[items.size()]);
        } catch(FileNotFoundException e){}
        
        return null;
    }
    
    //Changes a menu item
    public void updateItem(int index, String newName, int newPrice){
        File temp = new File("update.temp");
        
        try{
            PrintWriter output = new PrintWriter(temp); //write to the temp file
            Scanner in = new Scanner(menuDB); //Read from the menuDB
            String updatePrice; //The price to update
            String updateName; // The name to update
            int currIndex;
            
            temp.createNewFile(); //Create the temp file for storage
            
            //Write the new updated database to a temporary file
            while(in.hasNextLine()){
                currIndex = Integer.parseInt(in.nextLine());
                output.println(currIndex);
                //output.println(in.nextLine());
                // print the newName instead
                
                updateName = in.nextLine();
                if(currIndex == index){
                	updateName = ""+newName;
                }
                output.println(updateName);
                
                updatePrice = in.nextLine();
                if(currIndex == index){
                	updatePrice = ""+newPrice;
                }
                output.println(updatePrice);
                
            }
            output.close();
            
            //Update the DB with the temp file
            output = new PrintWriter(menuDB);
            in = new Scanner(temp);
            
            while(in.hasNextLine()){
                output.println(in.nextLine());
            }
            output.close();
        } catch(IOException e){}
        
        temp.delete(); //Delete the temporary file
    }
    
    //Removes a menu item
    public void removeItem(int index){
        File temp = new File("update.temp");
        
        try {
            PrintWriter output = new PrintWriter(temp);
            Scanner input = new Scanner(menuDB);
            
            //Remove the item from the database and save into a temp file
            while(input.hasNextLine()){
                int currIndex = Integer.parseInt(input.nextLine());
                
                if(currIndex == index){
                    //Throw
                    input.nextLine();
                    input.nextLine();
                } else if(currIndex > index){
                    output.println(currIndex-1); //Lower the index as 1 item has been removed
                    output.println(input.nextLine());
                    output.println(input.nextLine());
                } else {
                    output.println(currIndex);
                    output.println(input.nextLine());
                    output.println(input.nextLine());
                }
                
            }
            output.close();
            
            //Update the DB with the temp file
            output = new PrintWriter(menuDB);
            input = new Scanner(temp);
            
            while(input.hasNextLine()){
                output.println(input.nextLine());
            }
            output.close();
            
        } catch(FileNotFoundException e){}
        
        temp.delete();
    }
    
    //Adds the orders to the database
    public void addOrder(Order order, String date){
        
        try{
            PrintWriter output = new PrintWriter(new FileWriter(orderDB,true)); //Opens a new PrintWriter in append mode
            
            output.println(order.getCustomer().getPhone());
            output.println(date);
            output.println(order.getOrderType());
            output.println(order.computeTotal());
            output.close();
            
        } catch(IOException e){}
        
    }
    
    //Gets all orders based on the customer number
    public Order[] getCustomerOrder(String number){
        try {
            Scanner in = new Scanner(orderDB);
            String currNumber;
            ArrayList<Order> orders = new ArrayList<Order>();
            
            while(in.hasNextLine()){
                currNumber = in.nextLine();
                
                if(currNumber.equals(number)){
                    orders.add(new Order(in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine()), getCustomer(currNumber)));
                } else {
                    //Throw
                    in.nextLine();
                    in.nextLine();
                    in.nextLine();
                }
            }
            
            return orders.toArray(new Order[orders.size()]);
        } catch(FileNotFoundException e){}
        
        return null;
        
    }
    
    //Gets all orders based on the date
    public Order[] getOrders(String date){
        try {
            ArrayList<Order> orders = new ArrayList<Order>();
            Scanner in = new Scanner(orderDB);
            String currNumber;
            String currDate;
            
            while(in.hasNextLine()){
                currNumber = in.nextLine();
                currDate = in.nextLine();
                
                if(currDate.equals(date)){
                    orders.add(new Order(currDate, in.nextLine(), Integer.parseInt(in.nextLine()), getCustomer(currNumber)));
                } else {
                    //Throw
                    in.nextLine();
                    in.nextLine();
                    in.nextLine();
                }
            }
            
            return orders.toArray(new Order[orders.size()]);
        } catch(FileNotFoundException e){}
        
        return null;
        
    }
    
    //Gets the size of the menuDB
    public int getMenuSize(){
        int size = 0;
        
        try{
            Scanner in = new Scanner(menuDB);
            while(in.hasNextLine()){
                //Throw away
                in.nextLine();
                in.nextLine();
                in.nextLine();
                
                size++;
            }
            
            return size;
        } catch (FileNotFoundException e){
            return 0;
        }
    }
    
    //Returns a customer if they exist, otherwise returns a null value
    public Customer getCustomer(String number){
        try{
            
            Scanner scan = new Scanner(database);
            boolean scanResult = false;
            
            while(scan.hasNextLine()){
                if(scan.hasNext(number)){
                    scanResult = true;
                    break;
                }
                scan.nextLine();
            }
            
            if(scanResult){
                Customer found = new Customer(scan.nextLine(), scan.nextLine(), scan.nextLine());
                return found;
            } else {
                return null;
            }
            
        } catch (FileNotFoundException e){
            return null;
        }
    }
    
    //Adds a customer to the database
    public void addCustomer(String number, String address, String financial){
        try {
            PrintWriter output = new PrintWriter(new FileWriter(database,true)); //Opens a new PrintWriter in append mode
            output.println(number);
            output.println(address);
            output.println(financial);
            
            output.close(); //Closes the PrintWriter
            
            
            
        } catch (FileNotFoundException e){} catch (IOException e){}
        
    }
    
    //Gets the current size of the customer database
    public int getSize(){
        try {
            Scanner scan = new Scanner(database);
            int users = 0;
            while(scan.hasNextLine()){
                scan.nextLine();
                users++;
            }
            return users/3;
        } catch (FileNotFoundException e){
            return 0;
        }
    }
    
}