package com.neosoft;

import java.sql.*;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCTest {

	public static void main(String[] args) {
		// STEPS
		// register the driver
		// creating connection
		// use statement object to perform
		// closing resource or connection

		final String DB_url = "jdbc:mysql://localhost:3306/mydb";
		final String DB_USER = "root";
		final String DB_PASSWORD = "vasuraam@44";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		CallableStatement cst = null;

		try {
			// 1.register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded..");

			// 2.creating connection
			con = DriverManager.getConnection(DB_url, DB_USER, DB_PASSWORD);
			System.out.println("Connection established...");

			// use statement object to perform
			st = con.createStatement();
			// create table
			String createTableQuery = "CREATE TABLE IF NOT EXISTS Sample"
					+ "(sid INT AUTO_INCREMENT PRIMARY KEY, sname varchar(30) NOT NULL)";
			// System.out.println("Table creation:"+st.executeUpdate(createTableQuery));

			// insert int table

//			String insertQuery="INSERT INTO sample (sname)VALUES('vasu'),('Varu'),('Varsha')";
//			
//			System.out.println("Record Insertion:"+st.executeUpdate(insertQuery));

			// update the record

			String updateQuery = "UPDATE sample SET sname='RAM' where sid=1";
			// System.out.println("Record updation:"+st.executeUpdate(updateQuery));

			// delete the record
			String DeleteQuery = "DELETE FROM sample where sid=3";
			// System.out.println("Record Deletion:"+st.executeUpdate(DeleteQuery));

			// fetch records
			/*
			 * String selectQuery="SELECT * FROM sample"; rs=st.executeQuery(selectQuery);
			 * System.out.println("Sid     sname"); System.out.println("---------------");
			 * while(rs.next()){
			 * System.out.println(rs.getInt("sid")+"\t"+rs.getString("sname")); }
			 * rs.close();
			 */

			// using prepared statement - (pre-compiled SQL statement)
			// it executes parameterized query --this is more fast execution
//			System.out.println("----------------------------------------------");
//			String selectprepareqry="SELECT * FROM sample where sid=?";
//			pst=con.prepareStatement(selectprepareqry);	
//			pst.setInt(1, 2);// replace ? by ->2
//			rs=pst.executeQuery();
//			if(rs.next()) {
//				System.out.println(rs.getInt("sid")+"\t"+rs.getString("sname"));
//				
//			}
//			
//			pst.setInt(1, 1);
//			rs=pst.executeQuery();
//			if(rs.next()) {
//				System.out.println(rs.getInt("sid")+"\t"+rs.getString("sname"));
//				
//			}
//			rs.close();
//			pst.close();

			// using insetion using pst

//			String insertpstquery="INSERT INTO sample VALUES (?,?)";
//			pst=con.prepareStatement(insertpstquery);	
//			
//			pst.setInt(1, 3);
//			pst.setString(2, "Arun");
//			System.out.println("Prepared record insert:"+ pst.executeUpdate());
//			
//			pst.setInt(1, 5);
//			pst.setString(2, "Bhivi");
//			System.out.println("Prepared record insert:"+ pst.executeUpdate());
//			
//			pst.setInt(1, 6);
//			pst.setString(2, "Bharath");
//			System.out.println("Prepared record insert:"+ pst.executeUpdate());
//			
//			pst.close();

			// batch insertion using pst

//			String[] names=new String[] {
//					"vinu","Raam","karan","Manu"
//			};
//			
//			String insertpstquery="INSERT INTO sample(sname) VALUES (?)";
//			pst=con.prepareStatement(insertpstquery);
//			
//			for(String name:names) {
//				pst.setString(1, name);
//				pst.addBatch();
//			}
//			System.out.println("Records Added:"+pst.executeBatch().length);
//			pst.close();
//			

			// CallableStatement

//			String preparequerycall="CALL mydb.GetAllEmployeeDept(?)";
//			cst=con.prepareCall(preparequerycall);
//			cst.setInt(1, 20);
//			rs=cst.executeQuery();
//			while(rs.next()) {
//				System.out.print("EmpNo:"+rs.getInt("empno")+", Ename:"+rs.getString("ename"));
//				System.out.println(", EmpSal:"+rs.getInt("sal")+", Dloc:"+rs.getString("loc")+", DeptNo:"+rs.getInt("deptno"));
//			}
//			
			// rs.close();

			// getting metadata frpm result set

//			String selectQuery2="SELECT * FROM sample";
//			rs=st.executeQuery(selectQuery2);
//			ResultSetMetaData rsmd=rs.getMetaData();
//			
//			int column_counter=rsmd.getColumnCount();
//			System.out.println("No. of Cols:"+column_counter);
//			for(int i=1;i<=column_counter;i++) {
//				System.out.println(rsmd.getColumnName(i)+","+rsmd.getColumnTypeName(i));
//				
//			}
//			
//		
//			rs.close();

			// metadata getting from database

			DatabaseMetaData dbmd = (DatabaseMetaData) con.getMetaData();
			System.out.println("Driver Name:" + dbmd.getDriverName());
			System.out.println("Driver Version:" + dbmd.getDriverVersion());

			System.out.println("User Name:" + dbmd.getUserName());
			System.out.println("DB product Name:" + dbmd.getDatabaseProductName());
			System.out.println("DB Product version :" + dbmd.getDatabaseProductVersion());

			System.out.println("Table Names---------------------------");

			rs = dbmd.getTables(con.getCatalog(), null, null, null);
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}

			rs.close();

			System.out.println("Procedures--------------------------------");
			rs = dbmd.getProcedures(con.getCatalog(), null, null);
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
					System.out.println("Connection closed..");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
