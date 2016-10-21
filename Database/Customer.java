package Database;

/**
 * The Customer Class.
 * @author Sean Doran, Christain Miles, David Moschner and Ian Tran
 */
public class Customer {
    
    /** The phone number of a customer. */
    private String phone;
    
    /** The address of a customer. */
    private String address;
    
    /** The CC details of a customer. */
    private String financial;
    
    /**
     * Instantiates a new customer.
     *
     * @param phone The phone number of a customer.
     * @param address The address of a customer.
     * @param financial The CC details of a customer.
     */
    public Customer(String phone,String address, String financial){
        this.phone = phone;
        this.address = address;
        this.financial = financial;
    }
    
    /**
     * Gets the Phone Number, Address and CC details as an array of Strings.
     *
     * @return The Phone Number, Address and CC details as an array of Strings.
     */
    //Returns the details as an array
    public String[] getDetails(){
    	String financialReadable = financial.replace("|", " ");
        String[] combine = {phone, address, financialReadable};
        return combine;
    }
    
    /**
     * Gets the phone number of a customer.
     *
     * @return The phone number of a customer.
     */
    public String getPhone(){
        return this.phone;
    }
}