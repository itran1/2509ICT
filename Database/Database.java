import java.io.*;
import java.util.Scanner;

public class Database {
    private File database;
    private File menuDB;
    
    //Loads the database or builds a new one if it doesn't exist
    public Database(){
        database = new File("DB.sv");
        menuDB = new File("menuDB.sv");
        
        if(!database.exists()){
            
            try {
                database.createNewFile(); //Create a new DB if one doesn't already exist
                menuDB.createNewFile();
            } catch (IOException e){}
            
        }
    }
    
    //Adds a new item to the menu
    public void addItem(String name, int price){
        int size = getMenuSize();
        
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
                currIndex = Integer.parseInt(in.nextLine());
                
                if(currIndex == index){
                    Item found = new Item(in.nextLine(), Integer.parseInt(in.nextLine()));
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
    //Changes a menu item
    public void updatePrice(int index, int newPrice){
        File temp = new File("update.temp");
        
        try{
            PrintWriter output = new PrintWriter(temp); 
            Scanner in = new Scanner(menuDB); //Read from the menuDB
            String update; //The price to update
            int nextNum;
            
            temp.createNewFile(); //Create the temp file for storage
            
            while(in.hasNextLine()){
                nextNum = Integer.parseInt(in.nextLine());
                output.println(nextNum);
                output.println(in.nextLine());
                update = in.nextLine();
                
                if(nextNum == index){
                    update = ""+newPrice;
                }
                
                output.println(update);
                
            }
            
            output.close();
            output = new PrintWriter(menuDB);
            in = new Scanner(temp);
            
            while(in.hasNextLine()){
                output.println(in.nextLine());
            }
            output.close();
            temp.delete(); //Delete the temporary file
        } catch(IOException e){}
    }
    //Removes a menu item
    public void removeItem(int index){
        
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
                Customer found = new Customer(scan.next(number), scan.next(), scan.next());
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