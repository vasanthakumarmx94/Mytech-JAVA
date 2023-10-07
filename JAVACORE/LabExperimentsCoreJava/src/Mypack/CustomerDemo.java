package Mypack;

import java.io.*;
import java.util.*;

public class CustomerDemo {

	public static void main(String[] args) {
		// create List & ArrayList reference to store customers
        List<Customer> listOfCustomers = new ArrayList<Customer>();
 
        // create customer objects using constructor initialization
        Customer napoleon = new Customer(1814, "Napoleon Bonaparte", 52);
        Customer mussolini = new Customer(1943, "Benito Mussolini", 62);
        Customer hitler = new Customer(1945, "Adolf Hitler", 56);
        Customer stalin = new Customer(1952, "Joseph Stalin", 75);
 
        // add customer objects to ArrayList
        listOfCustomers.add(hitler);
        listOfCustomers.add(stalin);
        listOfCustomers.add(mussolini);
        listOfCustomers.add(napoleon);
 
 
        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
 
        try {
            // for writing or saving binary data
            fos = new FileOutputStream("ArrayListOfCustomer.ser");
 
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
 
            // writing or saving ArrayList values to stream
            oos.writeObject(listOfCustomers);
            oos.flush();
            oos.close();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
 
        System.out.println("ArrayList of Customer objects saved to "
                + "ArrayListOfCustomer.ser file");
    }
	

}
