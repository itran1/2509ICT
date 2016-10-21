package Database;

/**
 * The Class Customer.
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
     * @param phone the phone
     * @param address the address
     * @param financial the financial
     */
    public Customer(String phone,String address, String financial){
        this.phone = phone;
        this.address = address;
        this.financial = financial;
    }
    
    /**
     * Gets the details.
     *
     * @return the details
     */
    //Returns the details as an array
    public String[] getDetails(){
    	String financialReadable = financial.replace("|", " ");
        String[] combine = {phone, address, financialReadable};
        return combine;
    }
    
    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone(){
        return this.phone;
    }
}