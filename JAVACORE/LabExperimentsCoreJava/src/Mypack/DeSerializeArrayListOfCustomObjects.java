package Mypack;

import java.io.*;
import java.util.*;

public class DeSerializeArrayListOfCustomObjects {
	 
    public static void main(String[] args) {
 
        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        // creating List reference to hold AL values after de-serialization 
        List<Customer> listOfCustomers = null;
 
        try {
            // reading binary data
            fis = new FileInputStream("ArrayListOfCustomer.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfCustomers = (ArrayList<Customer>) ois.readObject();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
 
        System.out.println("ArrayList object de-serialized from "
                + "ArrayListOfCustomer.ser file\n");
 
        // iterating & printing ArrayList values to console
        for(Customer customer : listOfCustomers){
            System.out.println(customer);
        }
    }
}