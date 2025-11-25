package com.BookCab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.BookCab.dao.BookingDetailsDao;
import com.BookCab.dao.BookingsDao;
import com.BookCab.dao.DriversDao;
import com.BookCab.dao.RoutesDao;
import com.BookCab.dao.UsersDao;
import com.BookCab.model.BookingDetails;
import com.BookCab.model.Bookings;
import com.BookCab.model.Drivers;
import com.BookCab.model.Routes;
import com.BookCab.model.Users;

public class cabServices  {
	
	private final UsersDao users_dao = new UsersDao();
	private final DriversDao drivers_dao = new DriversDao();
	private final BookingsDao bookings_dao = new BookingsDao();
	private final RoutesDao routes_dao = new RoutesDao();
	private final BookingDetailsDao booking_deails_dao = new BookingDetailsDao();
	
	// user registration
	public int registerUser(Scanner sc) throws SQLException{
		System.out.println("Enter name: ");
		String name = sc.nextLine().trim();
		System.out.println("Enter email: ");
		String email = sc.nextLine().trim();
		System.out.println("Enter phone: ");
		String phone = sc.nextLine().trim();
		System.out.println("Enter password: ");
		String pass = sc.nextLine();
		
		if(users_dao.findByEmail(email) != null) {
			System.out.println("Email already registered. Use login.");
			return -1;
		}
		
		Users users = new Users();
		users.setName(name);
		users.setEmail(email);
		users.setPhone(phone);
		users.setPassword(pass);
		
		int id = users_dao.createUser(users);
		if(id> 0) System.out.println("Registration successful. Your user id: "+id);
		return id;
	}
	
	
	
	//user login
	public Users userLogin(Scanner sc) throws SQLException {
		System.out.print("Enter email: ");
		String email = sc.nextLine().trim();
		System.out.print("Enter password: ");
		String pass = sc.nextLine();
		
		Users users = users_dao.findByEmail(email);
		if(users == null) {
			System.out.println("No user with that email. Register first.");
			return null;
		}
		
		if(!pass.equals(users.getPassword())) {
			System.out.println("Incorrect password.");
			return null;
		}
		System.out.println("Welcome, "+users.getName()+ "!");
		return users;
	}
	
	// all routes
	
	public void allRoutes() {
		routes_dao.showAllRoutes();
	}
	
	
	// Book a cab
	public void bookCab(Scanner sc, Users users) {
		try {
			
			List<String> vehicle_type = drivers_dao.getAvailableVehicleTypes();
			
			if(vehicle_type.isEmpty()) {
				System.out.println("No vehicles currently available. Try later.");
				return;
			}

			System.out.println("Available vehicles: ");
			for(String type : vehicle_type ){
				System.out.println("- "+type);
			}
			
			System.out.println("Enter vehicle type: ");
			String selectedType = sc.nextLine().trim();
			
			Drivers selected = drivers_dao.getDriverByType(selectedType);
			
			
			if(selected == null || !selected.isAvailability()) {
				System.out.println("Driver not available for ."+selectedType);
				return;
			}
			
			int driverId = selected.getDriver_id();
			
			System.out.println("Enter source: ");
			String source = sc.nextLine().trim();
			System.out.println("Enter destination: ");
			String destination = sc.nextLine().trim();
			
			
			double distanceEstimate = routes_dao.getDistanceFromDB(source, destination);
			
			double baseFare = 5.0;
			double fare = baseFare + distanceEstimate * 12;   //12 per km
			
			Bookings bookings = new Bookings();
			bookings.setUser_id(users.getUser_id());
			bookings.setDriver_id(driverId);
			bookings.setRoute_id(routes_dao.getRouteIdFromDB(source, destination));
			bookings.setSource(source);
			bookings.setDestination(destination);
			bookings.setFare(fare);
			bookings.setStatus("Booked");
			
			int bookingId = bookings_dao.createBooking(bookings);
			
			if (bookingId > 0) {
				drivers_dao.setAvailability(driverId, false);
				System.out.println("Booking successful. Booking ID: "+ bookingId+", Fare: Rs. "+ String .format("% .2f", fare)+", Driver details: "+selected.getName()+", "+selected.getVehicle_no());
				
			}else {
				System.out.println("Failed booking. Try again.");
			}
			}catch(SQLException e) {
				System.err.println("Booking error: "+e.getMessage());
			}catch(NumberFormatException e) {
				System.out.println("Invalid number input.");
			}
			
	}
	
	

	
	//View booking history
	public void viewHistory(Users users) throws SQLException {
		var list = bookings_dao.getBookingsByUser(users.getUser_id());
		if(list.isEmpty()) {
			System.out.println("No bookings yet.");
			return;
		}
		System.out.println("Your bookings: ");
		for(Bookings bookings : list) {
			System.out.println("ID: "+bookings.getBooking_id()+ " | Driver: "+bookings.getDriver_id()+ " | From: "+ bookings.getSource()+ " | To: "+bookings.getDestination()+" | Fare: Rs. "+String.format("% .2f", bookings.getFare())+" | Status: "+bookings.getStatus()+ " | Time: "+bookings.getBookingTime());
			
		}
	}
	
	
	//5. Cancel booking
	public void cancelBooking(Scanner sc, Users users) throws SQLException{
		try {
			System.out.println("Enter booking ID to cancel: ");
			int id = Integer.parseInt(sc.nextLine().trim());
			String currentStatus = bookings_dao.getBookingStatus(id, users.getUser_id());
			if(currentStatus == null) {
				System.out.println("No booking found with this id for your account.");
				return;
			}
			if(currentStatus.equalsIgnoreCase("Completed")) {
				System.out.println("Cannot cancel - ride is already completed.");
			}else if(currentStatus.equals("Cancelled")) {
				System.out.println("Already cancelled.");
			}else {
				bookings_dao.updateBookingStatus(id, "Cancelled");
				System.out.println("Booking Cancelled.");
			}
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

	
	// payment - ride completed
	public void makePayment(Scanner sc, Users loggedIn) throws SQLException{
		
		try {
			System.out.println("Enter booking ID to pay: ");
			int id = Integer.parseInt(sc.nextLine().trim());
			bookings_dao.updateBookingStatus(id, "Completed");
			System.out.println("Ride Completed.");
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//9. checkBookings 
	public void checkAllBookings(Scanner sc, Users loggedIn) {
		int userId = loggedIn.getUser_id();
		
		System.out.println("\n ------ View your bookings -------");
		System.out.println("1. All");
		System.out.println("2. Completed");
		System.out.println("2. Cancelled");
		System.out.println("3. Booked/Ongoing");
		System.out.println("Enter your choice: ");
		
		int choice = sc.nextInt();
		
		String statusFilter = null;
		
		switch(choice) {
		case 2 -> statusFilter = "Completed";
		case 3 -> statusFilter = "Cancelled";
		case 4 -> statusFilter = "Booked";
		}
		
		List<BookingDetails> list = booking_deails_dao.checkBookingsByUserId(userId,statusFilter);
		
		if(list.isEmpty()) {
			System.out.println("No bookings found!");
		}else{
			System.out.println("\n ----  Your bookings  -----");
			for(BookingDetails b : list) {
				b.display();
			}
		}
		
	}
	
	
	//	// Admin action - addDriver
	public void adminAddDriver(Scanner sc) throws SQLException {
		
		System.out.println("Driver name: ");
		String name = sc.nextLine().trim();
		
		System.out.println("Vehicle no: ");
		String vehicle_no = sc.nextLine().trim();
		
		System.out.println("Vehicle type (SUV / Sedan): ");
		String vehicle_type = sc.nextLine().trim();
		
		Drivers drivers = new Drivers();
		
		drivers.setName(name);
		drivers.setVehicle_no(vehicle_no);
		drivers.setVehicle_type(vehicle_type);
		drivers.setAvailability(true);
		
		int id = drivers_dao.addDriver(drivers);
		
		if (id > 0) {
			System.out.println("Driver added, id: "+id);
		}else {
			System.out.println("Failed.");
		}
	}
	
}
