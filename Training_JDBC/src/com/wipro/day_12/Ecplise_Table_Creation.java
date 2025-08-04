package com.wipro.day_12;
import java.sql.*;


public class Ecplise_Table_Creation {

	public static void main(String[] args) throws SQLException {
		String URL = "jdbc:mysql://localhost:3306/mydataentries";
		String user = "root";
		String pwd = "Iwillmakemoney100000$";
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("My Sql Driver not connected !");
		}
		
		try(Connection con = DriverManager.getConnection(URL, user, pwd);
				Statement st = con.createStatement()){
			
			String comment = "CREATE TABLE IF NOT EXISTS Friends (" +
	                 "id INT NOT NULL AUTO_INCREMENT, " +
	                 "name VARCHAR(100), " +
	                 "role VARCHAR(100), " +
	                 "PRIMARY KEY (id))";
			st.executeUpdate(comment);
			System.out.println("Table Friends has been Created");
			
			
			String values = "insert into Friends (name , role) values(? , ?)";
			try(PreparedStatement ps = con.prepareStatement(values)){
				
//				ps.setString(1, "Phoebe");
//				ps.setString(2, "Joey's Backup");
//				ps.addBatch();
				
//				ps.setString(1, "Rachel");
//				ps.setString(2, "Problematic Girl");
//				ps.addBatch();
//				
//				ps.setString(1, "Joey");
//				ps.setString(2, "How you doin?");
//				ps.addBatch();
//				
//				ps.setString(1, "Ross");
//				ps.setString(2, "Palaeontologist");
//				ps.addBatch();
				
				ps.setString(1, "Chandler");
				ps.setString(2, "Sarcastic Commentor");
				ps.addBatch();
				
				ps.setString(1, "Monica");
				ps.setString(2, "Cleaner");
				ps.addBatch();
				
				
				
				
				int FriendsArr[] = ps.executeBatch();
				System.out.printf("\n Inserted Rows %d ",
					(int)java.util.stream.IntStream.of(FriendsArr).filter(c -> c>0).count());	
			}
		}
		catch (SQLException e) {
			System.out.println("Data Operation Failed");
			e.printStackTrace();
		}
		
	}
}
