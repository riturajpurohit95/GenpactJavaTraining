package com.BookCab;

import java.util.Scanner;

//import com.BookCab.dao.SQLDao;
import com.BookCab.model.Users;

public class Main {

	public static void main(String[] args) {
		
		
//		Connection conn = DBUtil.getConnection();
//		try {
//			if(conn!=null) {
//				System.out.println("Connected to database: "+conn.getCatalog());  
//			}
//			else {
//				System.out.println("Connection returned null.");
//			}
//		}catch(SQLException e) {
//			System.out.println("Connection failed. "+e.getMessage());
//		}
//		
//		SQLDao sql_dao = new SQLDao();
//		sql_dao.createTableUsers();
//		sql_dao.createTableDrivers();
//		sql_dao.createTableBooking();
//		sql_dao.createTableRoutes();
		
		
		Scanner sc = new Scanner(System.in);
		cabServices services = new cabServices();
		
		Users loggedIn = null;
		
		while(true) {
			System.out.println("\n---------   Cab Booking System   -----------");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. All routes");
			System.out.println("4. Book Cab (must login)");
			System.out.println("5. View Booking (must login)");
			System.out.println("6. MakePayment (must login)");
			System.out.println("7. Cancel Booking (must login)");
			System.out.println("8. Check all bookings (must login)");
			System.out.println("9. Logout");
			System.out.println("10. For Admin only (add driver)");
			System.out.println("0. Exit");
			
			System.out.println("Choose: ");
			String choice = sc.nextLine().trim();
			
			try {
				switch(choice) {
				case "1": services.registerUser(sc); break;
				case "2": loggedIn = services.userLogin(sc); break;
				case "3": services.allRoutes(); break;
				case "4": if (ensureLogin(loggedIn)) services.bookCab(sc, loggedIn); break;
				case "5": if (ensureLogin(loggedIn)) services.viewHistory(loggedIn); break;
				case "6": if (ensureLogin(loggedIn)) services.makePayment(sc, loggedIn); break;
				case "7": if (ensureLogin(loggedIn)) services.cancelBooking(sc, loggedIn); break;
				case "8": if (ensureLogin(loggedIn)) services.checkAllBookings(sc, loggedIn); break;
				case "9": loggedIn = null; System.out.println("Logged out."); break;
				
				case "10":
					System.out.println("Enter admin password: ");
					String pass = sc.nextLine().trim();
					if("admin123".equals(pass)) services.adminAddDriver(sc);
					else System.out.println("Wrong admin password.");
					break;
					
				case "0": System.out.println("Thankyou!"); sc.close(); System.exit(0); break;
				default: System.out.println("Invalid choice.");
				}
			}catch(Exception e) {
				System.err.println("Unexpected error: "+e.getMessage());
				e.printStackTrace();
			}
		}
	}
		
		
		private static boolean ensureLogin(Users users) {
			if(users == null) {
				System.out.println("You must login first.");
				return false;
			}
			return true;
		}
		

}
