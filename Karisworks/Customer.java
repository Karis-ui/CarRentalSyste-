package karisworks.carrental;
public class Customer{
    private final int customerID;
    private final String name;
    
    public Customer(int customerID, String name){
        this.customerID = customerID;
        this.name = name;
    }
    public int getCustomerID(){return customerID;}
    public String getName(){return name;}
    
    @Override
    public String toString(){
        return name + "(ID:" + customerID +")";
    }
}