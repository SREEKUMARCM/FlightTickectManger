package com.flightTicket;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Flightdao {
	private String dbURL = "jdbc:mysql://localhost:3306/FlightTickectManger";
    private String userName = "root";
    private String password = "passOMKV4545";
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	private String no_of_seats;
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(dbURL,userName,password);
		}catch(SQLException e) {
			e.printStackTrace();
		 }
		return con;
		
	}
	public List<FlightDetails> search(String source, String destination,int numberOfSeats, String date) {
		
	    List<FlightDetails> flightList = new ArrayList<>();

	    System.out.println("************");
	    System.out.println(source);
	    System.out.println(destination);
	    System.out.println(numberOfSeats);
	    System.out.println(date);
	    
	    try (Connection con = getConnection()) {
	        String sql = "SELECT f_ID, FName, SourceName, destination,no_of_seats, price, P_id, DateOftravel FROM FlightDetails WHERE SourceName = ? AND destination = ? AND  no_of_seats  >= ?  AND DateOftravel = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, source);
	        ps.setString(2, destination);
	        ps.setInt(3, numberOfSeats);
	        ps.setString(4, date);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                int flightId = rs.getInt("f_ID");
	                String flightName = rs.getString("FName");
	                String sourceName = rs.getString("SourceName");
	                String destinationName = rs.getString("destination");
	                int seatCount=rs.getInt("no_of_seats");
	                int price =rs.getInt("price");
	                int personId = rs.getInt("P_id");
	                Date dateOfTravel = rs.getDate("DateOftravel");

	                FlightDetails flight = new FlightDetails(flightId, flightName, sourceName, destinationName,seatCount, price, personId,date);
	                flightList.add(flight);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    System.out.println("+++++++++++++++++");
	    System.out.println(flightList);
	    return flightList;
	}
	public String insert(PersonalDetails personal) {
		loadDriver(dbDriver);
		Connection con=getConnection();
		String result="data entered successfully";
		String sql="insert into PersonalDetaiils values(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,personal.getPersionId() );
			ps.setString(2,personal.getPersonName());
			ps.setInt(3,personal.getAge());
			ps.setString(4,personal.getGender());
			ps.setInt(5,personal.getfId() );
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 result="data is not entered";
			
		}
		
		return result;
	}
public List<FlightDetails> searchFid(int flightId) {
		
	    List<FlightDetails> flightList = new ArrayList<>();

	    System.out.println("************");
	    
	    try (Connection con = getConnection()) {
	        String sql = "SELECT * FROM FlightDetails WHERE f_ID = ? ";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, flightId);
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                int flightId1 = rs.getInt("f_ID");
	                String flightName = rs.getString("FName");
	                String sourceName = rs.getString("SourceName");
	                String destinationName = rs.getString("destination");
	                int seatCount=rs.getInt("no_of_seats");
	                int price =rs.getInt("price");
	                int personId = rs.getInt("P_id");
	                String dateOfTravel = rs.getString("DateOftravel");

	                FlightDetails flight = new FlightDetails(flightId1, flightName, sourceName, destinationName,seatCount, price, personId,dateOfTravel);
	                flightList.add(flight);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    System.out.println("++++++---------+++++");
	    System.out.println(flightList);
	    return flightList;
	}
public String insertPayment(Paymentdetailsclass payment) {
	loadDriver(dbDriver);
	Connection con=getConnection();
	String result="data entered successfully";
	String sql="insert into PaymentDetails values(?,?,?)";
	PreparedStatement ps;
	try {
		ps=con.prepareStatement(sql);
		ps.setInt(1,payment.getfId());
		ps.setInt(2,payment.getPid());
		ps.setInt(3,payment.getAmount());
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 result="data is not entered";
		
	}
	
	return result;
}
public List<Adminclass> searchAdmin() {
	
    List<Adminclass> adminList = new ArrayList<>();

    try (Connection con = getConnection()) {
        String sql = "SELECT * from AdminDetails";
        PreparedStatement ps = con.prepareStatement(sql);
      
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String adminName = rs.getString("name");
                String password = rs.getString("password");

                Adminclass admin = new Adminclass(adminName,password);
                adminList.add(admin);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return adminList;
}
public List<FlightDetails> searchFlight() {
    List<FlightDetails> flightList = new ArrayList<>();

 
    try (Connection con = getConnection()) {
        String sql = "SELECT f_ID, FName, SourceName, destination,no_of_seats, price, P_id, DateOftravel FROM FlightDetails";
        PreparedStatement ps = con.prepareStatement(sql);
       

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int flightId = rs.getInt("f_ID");
                String flightName = rs.getString("FName");
                String sourceName = rs.getString("SourceName");
                String destinationName = rs.getString("destination");
                int seatCount=rs.getInt("no_of_seats");
                int price =rs.getInt("price");
                int personId = rs.getInt("P_id");
                String dateOfTravel = rs.getString("DateOftravel");

                FlightDetails flight = new FlightDetails(flightId, flightName, sourceName, destinationName,seatCount, price, personId,dateOfTravel);
                flightList.add(flight);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return flightList;
}
public List<PersonalDetails> searchPersonal() {
	
    List<PersonalDetails> peronalList = new ArrayList<>();

    System.out.println("************");
    
    try (Connection con = getConnection()) {
        String sql = "SELECT * FROM PersonalDetaiils";
        PreparedStatement ps = con.prepareStatement(sql);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int personalId = rs.getInt("P_id");
                String flightName = rs.getString("Pname");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                int fId=rs.getInt("f_ID");

                PersonalDetails personal = new PersonalDetails(personalId,flightName,age,gender,fId);
                peronalList.add(personal);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

   
    return peronalList;
}
public String updatePassword(String name,String password, String newPassword) {
	System.out.println(name);
	System.out.println(password);
	System.out.println(newPassword);
    String sql = "UPDATE AdminDetails SET password = ? WHERE name = ? AND password = ?";

    try (Connection con = getConnection(); 
         PreparedStatement ps = con.prepareStatement(sql)) {

     
        ps.setString(1, newPassword); 
        ps.setString(2, name); 
        ps.setString(3, password); 
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            
            return "Password updated successfully";
        } else {
            
            return "Password update failed. Name and current password do not match.";
        }
    } catch (SQLException e) {
        e.printStackTrace();
       
        return "Error updating password: " + e.getMessage();
    }
}

}
