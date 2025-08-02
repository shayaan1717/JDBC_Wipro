package com.wipro.day_12;

import java.sql.*;

public class Jdbc {
	
	public static void main(String[] args) throws SQLException	,  ClassNotFoundException{
		
//		Setting Up the Connection
			String url = "jdbc:mysql://localhost:3306/MyDataEntries";
			String username = "root";
			String pwd = "Iwillmakemoney100000$";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
//		Getting the Connection
			Connection con = DriverManager.getConnection(url , username , pwd);
			Statement st = con.createStatement();
			
			
//		Finding the Table from the DataBase
			String query = "select * from cars;";
			ResultSet rs = st.executeQuery(query);
			
			
//		Getting the data
			while(rs.next()) {
				int ID =  rs.getInt(1);
				String name = rs.getString(2);
				int modelNo = rs.getInt(3);
				System.out.println("ID : " +ID+ "\n Name of the car : "+name+"\n Model Number : "+modelNo );
			}
			
			con.close();
			st.close();
			
			
	}
}
			

	
