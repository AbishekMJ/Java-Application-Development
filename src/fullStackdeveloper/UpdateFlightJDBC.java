package fullStackdeveloper;
// update Flight JDBC Program
//UpdateFlightFareforaFlight/src/DB.java
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
//UpdateFlightFareforaFlight/src/Flight.java
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
47 }
48 
49 
50 
51 
52 
53 
54 
55 
56 
57 
58 
//UpdateFlightFareforaFlight/src/FlightManagementSystem.java
1 import java.sql.Connection;
2 import java.sql.PreparedStatement;
3 import java.sql.SQLException;
4 import java.lang.ClassNotFoundException;
5 
6 public class FlightManagementSystem{
7     
8     
9     public boolean updateFlightFare(int flightId, double flightFare){
10        boolean isUpdated=false;
11         try{
12             Connection con=DB.getConnection();
13            PreparedStatement stmt=con.prepareStatement("UPDATE Flight SET flightfare = ? WHERE flightId = ?");
14            
15             stmt.setDouble(1, flightFare);
16             stmt.setInt(2, flightId);
17             
18             int rowsAffected=stmt.executeUpdate();
19             if(rowsAffected>0){
20                 isUpdated=true;
21             }
22             con.close();
23             
24         }catch (ClassNotFoundException | SQLException e){
25             e.printStackTrace();
26     
27         }
28         return isUpdated;
29     }
30 }
//UpdateFlightFareforaFlight/src/Main.java
1 import java.util.Scanner;
2 public class Main{
3     public static void main(String[] args){
4         Scanner sc=new Scanner(System.in);
5         //Fill the Code
6         
7         System.out.println("Enter the flightId");
8         int flightId=sc.nextInt();
9         
10         System.out.println("Enter the flightFare to be updated");
11         double flightFare=sc.nextDouble();
12         
13         FlightManagementSystem flightManagementSystem=new FlightManagementSystem();
14         boolean isUpdated=flightManagementSystem.updateFlightFare(flightId, flightFare);
15         
16         if(isUpdated){
17             System.out.println("Flight Fare updated successfully");
18         }else{
19            System.out.println("Flight fare not updated. Check for the ID"); 
20         }
21    sc.close();
22    
23     }
24 }
25 
26 	 	  	 	      	     	      	 	   	 	
27 