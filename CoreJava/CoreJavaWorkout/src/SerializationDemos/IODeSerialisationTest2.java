package SerializationDemos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class IODeSerialisationTest2 {

	public static void main(String[] args) {

		ObjectInputStream ois = null;
		String inputFile = "resources/trainers.db";
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");
		try {
			try {
				ois=new ObjectInputStream(new FileInputStream(inputFile));
				while(true) {
					Trainer trainer=(Trainer) ois.readObject();
					System.out.print("name:"+trainer.getName()+"\t");
					System.out.print("dob:"+dateFormat.format(trainer.getBirthday())+"\t");
					System.out.print("salary:"+trainer.getSalary()+"\t");
					System.out.print("gender:"+trainer.isGender()+"\t");
					System.out.println();
				}
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				System.out.println("End of File...");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
