package com.neosoft;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import com.mysql.cj.jdbc.Blob;

public class JDBCTestWithImage {

	public static void main(String[] args) {

		final String DB_url = "jdbc:mysql://localhost:3306/mydb";
		final String DB_USER = "root";
		final String DB_PASSWORD = "vasuraam@44";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			// 1.register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded..");

			// 2.creating connection
			con = DriverManager.getConnection(DB_url, DB_USER, DB_PASSWORD);
			System.out.println("Connection established...");

			// create table profile
//			String createTableQuery="CREATE TABLE IF NOT EXISTS profile"+
//			"(sid INT AUTO_INCREMENT PRIMARY KEY, photo MEDIUMBLOB NOT NULL)";
//			
//			pst=con.prepareStatement(createTableQuery);
//			System.out.println("Table creation:"+pst.executeUpdate());
//			pst.close();

//			File pic = new File("D:\\pf1.png");
//			FileInputStream fis = new FileInputStream(pic);
//			pst = con.prepareStatement("INSERT INTO profile(photo)VALUE(?)");
//			// pst.setBinaryStream(1, fis,(int)pic.length());
//			pst.setBlob(1, fis, (int) pic.length());
//			System.out.println("Image Insertion:" + pst.executeUpdate());
//
//			pst.close();s

			// retrive image

			pst = con.prepareStatement("SELECT * from profile WHERE sid=?");
			pst.setInt(1, 2);
			rs = pst.executeQuery();
			byte b[];
			Blob blob;
			if (rs.next()) {
				File file = new File("D:\\IMAGES\\img" + rs.getInt(1) + ".png");
				FileOutputStream fos = new FileOutputStream(file);
				blob = (Blob) rs.getBlob(2); // getBlob("photo")//
				b = blob.getBytes(1, (int) blob.length());
				fos.write(b);
				System.out.println("image downloaded at:" + file.getPath());
			}
			
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

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
