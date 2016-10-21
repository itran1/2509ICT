package Database;

/**
 * The Customer Class.
 * @author Sean Doran, Christain Miles, David Moschner and Ian Tran
 */
public class Customer {
    
    /** The phone. */
    private String phone;
    
    /** The address. */
    private String address;
    
    /** The financial. */
    private String financial;
    
    /**
     * Instantiates a new customer.
     *
     * @param phone The phone
     * @param address The address
     * @param financial The financial
     */
    public Customer(String phone,String address, String financial){
        this.phone = phone;
        this.address = address;
        this.financial = financial;
    }
    
    /**
     * Gets the Phone Number and Address and CC details.
     *
     * @return The Phone Number and Address and CC details as a single String
     */
    //Returns the details as an array
    public String[] getDetails(){
    	String financialReadable = financial.replace("|", " ");
        String[] combine = {phone, address, financialReadable};
        return combine;
    }
    
    /**
     * Gets the phone number.
     *
     * @return The phone number
     */
    public String getPhone(){
        return this.phone;
    }
}