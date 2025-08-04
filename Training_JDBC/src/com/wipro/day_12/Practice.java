package com.wipro.day_12;

import java.sql.*;
import java.sql.SQLException;

public class Practice {
	
	public static void main(String[] args) {
		
		try {
			String URL = "jdbc:mysql://localhost:3306/mydataentries";
			String user = "root";
			String pwd = "Iwillmakemoney100000$";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(URL, user , pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Students;");
			while(rs.next()) {
				int ID =  rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String grade = rs.getString(4);
				
				System.out.println("ID : "+ID+
						"\n Name of the Student : "+name
						+"\n Age : "+age
						+"\n Grade : "+grade
						+"\n");
			}
			con.close();
			st.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
