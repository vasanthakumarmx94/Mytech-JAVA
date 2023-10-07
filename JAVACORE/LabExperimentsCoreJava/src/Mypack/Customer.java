package Mypack;

import java.io.Serializable;

public class Customer implements Serializable {
 
    // SerialVersionUID
    private static final long serialVersionUID = 19L;
 
    // member variables
    int customerId;
    String customerName;
    int customerAge;
 
    // 3-arg parameterized constructor
    public Customer(int customerId, String customerName,
            int customerAge) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
    }
 
    // overriding toString() method
    @Override
    public String toString() {
        return "Customer ["
                + "customerId=" + customerId + ","
                + " customerName=" + customerName + ","
                + " customerAge=" + customerAge
                + "]";
    }
}
