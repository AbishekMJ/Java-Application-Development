package fullStackdeveloper;
// demonstrate program for JDBC to Delete Flights
//DeleteflightUsingFlightID/src/DB.java
1 //DO NOT CHANGE THE CODE 
2 
3 import java.io.FileInputStream;
4 import java.io.IOException;
5 import java.sql.Connection;
6 import java.sql.DriverManager;
7 import java.sql.SQLException;
8 import java.util.Properties;
9 
10 public class DB {
11 
12 	private static Connection con = null;
13 	private static Properties props = new Properties();
14 	
15 
16     //ENSURE YOU DON'T CHANGE THE BELOW CODE WHEN YOU SUBMIT
17 	public static Connection getConnection() throws ClassNotFoundException, SQLException {
18 	    try{
19 			
20 			FileInputStream fis = null;
21 			fis = new FileInputStream("database.properties");
22 			props.load(fis);
23 			
24 			// load the Driver Class
25 			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
26 
27 			// create the connection now
28             con = DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USERNAME"),props.getProperty("DB_PASSWORD"));
29 	    }
30 	    catch(IOException e){
31 	        e.printStackTrace();
32 	    }
33 		return con;	
34 	}
35 }
36 	 	  	 	      	     	      	 	   	 	
37 
//DeleteflightUsingFlightID/src/Flight.java
1 public class Flight {
2 	
3 	private int flightId;
4 	private String source;
5 	private String destination;
6 	private int noOfSeats;
7 	private double flightFare;
8 	public int getFlightId() {
9 		return flightId;
10 	}
11 	public void setFlightId(int flightId) {
12 		this.flightId = flightId;
13 	}
14 	public String getSource() {
15 		return source;
16 	}
17 	public void setSource(String source) {
18 		this.source = source;
19 	}
20 	public String getDestination() {
21 		return destination;
22 	}
23 	public void setDestination(String destination) {
24 		this.destination = destination;
25 	}
26 	public int getNoOfSeats() {
27 		return noOfSeats;
28 	}
29 	public void setNoOfSeats(int noOfSeats) {
30 		this.noOfSeats = noOfSeats;
31 	}
32 	public double getFlightFare() {
33 		return flightFare;
34 	}
35 	public void setFlightFare(double flightFare) {
36 		this.flightFare = flightFare;
37 	}
38 	public Flight(int flightId, String source, String destination,
39 			int noOfSeats, double flightFare) {
40 		super();
41 		this.flightId = flightId;
42 		this.source = source;
43 		this.destination = destination;
44 		this.noOfSeats = noOfSeats;
45 		this.flightFare = flightFare;
46 	}
47 
48 	
49 
50 }
51 
52 
53 
54 
55 
56 
57 
58 
59 
//DeleteflightUsingFlightID/src/FlightManagementSystem.java
1 import java.sql.Connection;
2 import java.sql.PreparedStatement;
3 import java.sql.SQLException;
4 public class FlightManagementSystem{
5     public boolean deleteFlight(int flightId){
6         boolean isDeleted=false;
7         try{
8             Connection connection=DB.getConnection();
9             String query="DELETE FROM Flight WHERE flightId=?";
10             PreparedStatement preparedStatement=connection.prepareStatement(query);
11             preparedStatement.setInt(1, flightId);
12             
13             int rowsAffected=preparedStatement.executeUpdate();
14             if(rowsAffected>0){
15                 isDeleted=true;
16             }
17             connection.close();
18         }catch (ClassNotFoundException | SQLException e){
19             e.printStackTrace();
20         }
21         return isDeleted;
22     }
23     
24 }
//DeleteflightUsingFlightID/src/Main.java
1 import java.util.Scanner;
2 public class Main{
3     public static void main(String[] args){
4         Scanner sc=new Scanner(System.in);
5         //Fill the Code
6           FlightManagementSystem flightManagementSystem=new FlightManagementSystem();
7           
8           System.out.println("Enter the flight id");
9           int flightId=sc.nextInt();
10           
11           boolean isDeleted=flightManagementSystem.deleteFlight(flightId);
12           
13           if (isDeleted){
14               System.out.println("Flight details deleted successfully");
15           }else {
16               System.out.println("Flight not deleted. Check for the ID");
17           }
18 
19     }
20 }
21 