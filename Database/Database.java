import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private File database;
    
    //Loads the database or builds a new one if it doesn't exist
    public Database(){
        database = new File("database.sv");
        
        if(!database.exists()){
            
            try {
                database.createNewFile(); //Create a new DB if one doesn't already exist
            } catch (IOException e){}
            
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
        Customer newCustomer = new Customer(number, address, financial);
        
        try {
            PrintWriter output = new PrintWriter(new FileWriter(database,true));
            String[] details = newCustomer.getDetails(); //Add customers detail to an array
            
            for(int i = 0; i<details.length; i++){
                output.println(details[i]);
            }
            
            output.close(); //Closes the PrintWriter
            
            
            
        } catch (FileNotFoundException e){} catch (IOException e){}
        
    }
    //Gets the current size of the database
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