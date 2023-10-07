package Basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionDemo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//String str=null;
		//System.out.println(str.length());//Terminated
	try {
		//unchecked
		int a=10,b=0;
		if(b==0)
			throw new ArithmeticException("Bshould not be 0");
		int result=a/b;
		System.out.println(result);//Termination (arithmetic pointer
		
		//int[] myarray= {10,20,30};
		//System.out.println(myarray[4]);//termination(IndexOutOfBound Exception
		}
	catch(ArithmeticException e) {	//Exception is parent
		System.err.println("can not  divide by Zero!!: "+e.getMessage());
	}
	catch(Exception e) {// if you use pare exception the use at last catch
		//parent exception handle any type of exceptions
		System.out.println("Something went wrong: ");
	}
	finally {//closing resource,free resources,closing db connection
		System.out.println("Im always there");
	}
	
	//for throws checked exception
	File file=new File("/file.txt");
	FileReader fileReader=new FileReader(file);
	
	
		System.out.println("End");

	}

}
