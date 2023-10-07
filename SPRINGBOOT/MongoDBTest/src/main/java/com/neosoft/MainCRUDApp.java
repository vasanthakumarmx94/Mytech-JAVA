package com.neosoft;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;

public class MainCRUDApp {

	public static void main(String[] args) {
		try {
			// connect to mongoDB server
			final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			// MongoCredential credential=MongoCredential.createCredential("root","mydb1","root1");

			// connect to databse
			final MongoDatabase database = mongoClient.getDatabase("mydb");
			System.out.println("Database connected sucessfully");
			
			// Access collection
			MongoCollection<Document> collection = database.getCollection("emplyee");
			System.out.println("Size of Collection is:" + collection.countDocuments());

			// Adding a document ---------------------------------------------
		/*
			Document document1=new Document();
			Document document2=new Document();
			Document document3=new Document();
			document1.append("_id", 1).append("name","abc")
				.append("salary", 30000).append("deptno", 10).append("job","Sales Rep" );
			document2.append("_id", 2).append("name","xyz")
				.append("salary", 40000).append("deptno", 10).append("job","developerp" );
			document3.append("_id", 3).append("name","xyz")
				.append("salary", 40000).append("deptno", 10).append("job","developerp" );
			
			List<Document> documents=new ArrayList<Document>();
			   documents.add(document1);
			   documents.add(document2);
			   documents.add(document3);	
		    collection.insertMany(documents);
			System.out.println("collection added siz:" + collection.countDocuments());
		*/

			
			//---------------------------------------------------------------
			// update document :  print 3rd doc
			
		/*
			  Document third=collection.find(Filters.eq("_id",3)).first();
			  System.out.println(third.toJson());
			  
			  Document updatedDocument=new Document(); 
			  updatedDocument.append("_id",3).append("name","xyz") 
			  		.append("salary", 50000).append("deptno",10).append("job","Snr developer" );
			  
			  collection.updateOne(new Document("_id",3),new Document("$set",updatedDocument)); 
			  System.out.println("updated successfully");
			  
			  Document updateTird=collection.find(Filters.eq("_id",3)).first();
			  System.out.println(updateTird.toJson());
		*/
			 

			// ----------------------------------------------------
			// Deleting Document : Delete a Document with id>=2
			
			//collection.deleteMany(Filters.gte("_id", 2));
			//System.out.println("Document deleted with id>2");
			
			//-----------------------------------------------------
			// Fetch all Document:

		/*
			//MongoCursor<Document> cursor = collection.find().iterator();
			MongoCursor<Document> cursor2 = collection.find(Filters.gt("Salary", 25000)).iterator();
			try {
				while (cursor2.hasNext())
					System.out.println(cursor2.next().toJson());
			} catch (Exception e) {
				e.printStackTrace();
			}
			cursor2.close();
		*/
			
			//-------------------------------------------------------
		/*
			// Addition stuff:filters find
			MongoCursor<Document> cursor2 = collection.find(Filters.gt("Salary", 25000)).iterator();

			// insert one document
			collection.insertOne(new Document().append("_id", "1").append("name", "vasu"));

			collection.updateOne(Filters.eq("_id", 1), new Document("$set", new Document("Salary", 500)));

			System.out.println("inserted and updated");
			
		*/

			/*------------------------
			Document document4=new Document();
			Document document5=new Document();
			Document document6=new Document();
			Document document7=new Document();
			Document document8=new Document();
			document4.append("_id", 4).append("name","ram")
			.append("salary", 30000).append("deptno", 10).append("job","Sales Rep" );
			
			document5.append("_id", 5).append("name","Raj")
			.append("salary", 25000).append("deptno", 10).append("job","developerp" );
			
			document6.append("_id", 6).append("name","Varu")
			.append("salary", 28000).append("deptno", 10).append("job","Sales Rep" );
			
			document7.append("_id", 7).append("name","Vasu")
			.append("salary", 25000).append("deptno", 10).append("job","Tester" );
			
			document8.append("_id", 8).append("name","Varma")
			.append("salary", 23000).append("deptno", 11).append("job","manager" );
			List<Document> documents=new ArrayList<Document>();
			documents.add(document4);
			documents.add(document5);
			documents.add(document6);
			documents.add(document7);
			collection.insertMany(documents);
			System.out.println("inserted Many collection");
			System.out.println("collection added size:"+collection.countDocuments());
			
			-------------------------*/
			// 1.Delete the documents have salary >=25000 and job="Sales Rep".

			// collection.deleteMany(Filters.gte("Salary", 25000));
			

			// 2.Update all documents salary to 30000 have salary 25000.
				collection.updateMany(Filters.eq("salary", 30000), new Document("$set", new Document("salary", 25000)));
			
			// 3.Display all documents have job as 'manager' and salary < 50000.

		
			//MongoCursor<Document> cursor3 = collection.find(Filters.lt("Salary", 50000)).iterator();
			
			//Bson jobfilter = eq("job", "manager");
			//Bson salfilter = lt("salary", 50000);
			//FindIterable<Document> cursorfindIter = collection.find(and(salfilter, jobfilter));
				
			Bson jobfilter = and(eq("job", "manager"),lt("salary", 50000));
			FindIterable<Document> cursorfindIter = collection.find(jobfilter);
			
			MongoCursor<Document> corsor = cursorfindIter.iterator();
			System.out.println(corsor.next());
			try {
				while (corsor.hasNext())
					System.out.println(corsor.next().toJson());
			} catch (Exception e) {
				e.printStackTrace();
			}
			corsor.close();

			mongoClient.close();

		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ":" + e.getMessage());
		}
	}

}
