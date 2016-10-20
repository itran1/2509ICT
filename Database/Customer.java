package Database;

public class Customer {
    private String phone;
    private String address;
    private String financial;
    
    public Customer(String phone,String address, String financial){
        this.phone = phone;
        this.address = address;
        this.financial = financial;
    }
    
    //Returns the details as an array
    public String[] getDetails(){
    	String financialReadable = financial.replace("|", " ");
        String[] combine = {phone, address, financialReadable};
        return combine;
    }
    
    public String getPhone(){
        return this.phone;
    }
}