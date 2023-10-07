package SerializationDemos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class IOSerialisationTest {

	public static void main(String[] args) {

		List<Trainer> trainers = new ArrayList<Trainer>();
		// trainers.add(10);

		ObjectOutputStream oos = null;
		String outputFile = "resources/trainers.db";
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");
		try {
			oos = new ObjectOutputStream(new FileOutputStream(outputFile));
			trainers.add(new Trainer("vasu", dateFormat.parse("02-16-2019"), true, 300, 000.6f));
			trainers.add(new Trainer("Kiran", dateFormat.parse("05-20-2019"), true, 500, 000.4f));
			trainers.add(new Trainer("Raj", dateFormat.parse("02-26-2021"), true, 200, 000.3f));

			for (Trainer trainer : trainers)
				oos.writeObject(trainer);
			System.out.println("serialization done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
