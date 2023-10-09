package fullStackdeveloper;
//RetrieveFlightsBasedonSourceandDestination/database.properties
1 #IF NEEDED, YOU CAN MODIFY THIS PROPERTY FILE
2 #ENSURE YOU ARE NOT CHANGING THE NAME OF THE PROPERTY
3 #YOU CAN CHANGE THE VALUE OF THE PROPERTY 
4 #LOAD THE DETAILS OF DRIVER CLASS, URL, USERNAME AND PASSWORD IN DB.java using this properties file only. 
5 #Do not hard code the values in DB.java.
6 
7 DB_DRIVER_CLASS=com.mysql.jdbc.Driver
8 DB_URL=jdbc:mysql://localhost:3306/XE
9 DB_USERNAME=root
10 DB_PASSWORD=
11 
RetrieveFlightsBasedonSourceandDestination/src/DB.java
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
//RetrieveFlightsBasedonSourceandDestination/src/Flight.java
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
RetrieveFlightsBasedonSourceandDestination/src/FlightManagementSystem.java
1 import java.sql.*;
2 import java.util.ArrayList;
3 
4 public class FlightManagementSystem{
5     public ArrayList<Flight> viewFlightsBySourceAndDestination(String source, String destination){
6         ArrayList<Flight> flights=new ArrayList<>();
7         
8         try{
9             Connection con=DB.getConnection();
10             PreparedStatement stmt=con.prepareStatement("SELECT * FROM Flight WHERE source = ? AND destination = ?");
11             stmt.setString(1, source);
12             stmt.setString(2, destination);
13             ResultSet rs=stmt.executeQuery();
14             
15             while(rs.next()){
16                 int flightId=rs.getInt("flightId");
17                 int noOfseats=rs.getInt("noOfseats");
18                 double flightFare=rs.getDouble("flightfare");
19                 
20                 Flight flight=new Flight(flightId, source, destination, noOfseats, flightFare);
21                 flights.add(flight);
22             }
23             con.close();
24         }catch (SQLException | ClassNotFoundException e){
25             e.printStackTrace();
26         }
27         return flights;
28     }
29 }
30 
31 
32 
33 
34 
RetrieveFlightsBasedonSourceandDestination/src/Main.java
1 import java.util.*;
2 public class Main{
3     public static void main(String[] args){
4         Scanner sc=new Scanner(System.in);
5         //Fill the Code
6 
7         System.out.println("Enter the source");
8         String source=sc.nextLine();
9         
10         System.out.println("Enter the destination");
11         String destination=sc.nextLine();
12          
13         FlightManagementSystem flightManagementSystem=new FlightManagementSystem();
14         ArrayList<Flight> flights=flightManagementSystem.viewFlightsBySourceAndDestination(source, destination);
15         
16         if(flights.isEmpty()){
17             System.out.println("No flights available for the given source and destination");
18         }else{
19             for(Flight flight:flights){
20                 System.out.println("Flight ID: " + flight.getFlightId());
21                 System.out.println("Source: " + flight.getSource());
22                 System.out.println("Destination: " + flight.getDestination());
23                 System.out.println("No of seats: " + flight.getNoOfSeats());
24                 System.out.println("Flight Fare: " + flight.getFlightFare());
25                 System.out.println();
26                 
27             }
28         }  
29     }
30 }
31 
