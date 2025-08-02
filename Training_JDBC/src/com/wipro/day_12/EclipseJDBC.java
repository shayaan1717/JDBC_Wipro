package com.wipro.day_12;
import java.sql.*;

public class EclipseJDBC {
	
	public static void main(String[] args) {
			String URL = "jdbc:mysql://localhost:3306/mydataentries";
			String user = "root";
			String pwd = "Iwillmakemoney100000$";
			
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				System.err.println("SQL driver not connected");
				e.printStackTrace();
			}
				
			try(Connection con = DriverManager.getConnection(URL , user , pwd);
					Statement st = con.createStatement())
			{
//			Creating Table
				String Using = "create table if not exists Library(LibID int Auto_Increment primary key, BookName varchar(100) , AuthorName varchar(100))";
				st.executeUpdate(Using);
//				System.out.println("Table Library has been created");
				
//			Inserting Values
				String val = "insert into Library(BookName , AuthorName) values(?,?)";
				try(PreparedStatement ps = con.prepareStatement(val)){
					ps.setString(1 , "Atmoic Habits");
					ps.setString(2 , "James Chase");
					ps.addBatch();
					
//					ps.setString(1, "Zero to One");
//					ps.setString(2, "Peter Thiel");
//					ps.addBatch();
//					
//				    ps.setString(1, "The Alchemist");
//				    ps.setString(2, "Paulo Coelho");
//				    ps.addBatch();
//
//				    ps.setString(1, "Ikigai");
//				    ps.setString(2, "Héctor García");
//				    ps.addBatch();
//
//				    ps.setString(1, "Rich Dad Poor Dad");
//				    ps.setString(2, "Robert Kiyosaki");
//				    ps.addBatch();
					
					int[] books = ps.executeBatch();
					System.out.printf("inserted rows %d \n", (int)java.util.stream.IntStream.of(books).filter(c -> c>0).count());	
				}
//			Printing The Values
				String query = "select * from Library";
				try(ResultSet rs = st.executeQuery(query)){
					while(rs.next()) {
						int LibID = rs.getInt(1);
						String BookName = rs.getString(2);
						String AuthorName = rs.getString(3);
						System.out.println("Library ID : "+LibID
								+"\n Book Name : "+BookName
								+"\n Author Name : "+AuthorName
								+"\n");
					}
				}
			
		}catch(SQLException e) {
			System.err.println("Data Operation Failed");
			e.printStackTrace();
		}
			
	}

}
