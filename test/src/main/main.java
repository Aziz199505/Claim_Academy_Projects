package main;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.sql.*; 


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		int[] list = {3,4,5,5};
		
		LinkedList<Integer> newList = convert(list);
		
		System.out.println(newList);
		
		Person person = new Person("Aziz","Sobirov",45);
		
		
		System.out.println(person.toString());
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","Watsec123!");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from test.person");
			 
			while(rs.next())  {
				String lastName = rs.getString("lastName");  
				System.out.println(lastName);

			}
			
			con.close();  

		}catch(Exception e) {
			System.out.println(e);
		}
		  
		

	}
	
	public static LinkedList<Integer> convert(int[] arr) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 0; i < arr.length ; i++) {
			list.add(arr[i]);
		}
		return list;
	}
	
	

}


