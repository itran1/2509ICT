Functions are as listed below:

addItem(String name, int price) //Adds an item to the item menu

getItem(int index) // Gets an item at the specified index

getAllItems() //Gets all the items in the menu DB

updatePrice(int index, int newPrice) //Updates the item price at the given index

removeItem(int index) //Removes an item at the specified index and adjusts the index 

getCustomer(String number) //Finds the specified customer and returns a customer object

addCustomer(String number, String address, String financial) //Returns a customer object

getSize() //Returns an int representing the size of the database (all customers)