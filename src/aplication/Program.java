package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner tcd = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number:");
		int numberRoom = tcd.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy");
		Date checkIn = sdf.parse(tcd.next());
		System.out.println("Check-out date (dd/MM/yyyy");
		Date checkout = sdf.parse(tcd.next());
		
		if(! checkout.after(checkIn)){
			System.out.println("error in reservation: Check-out must be after check-in date ");
		}else {
			Reservation reservation = new Reservation(numberRoom, checkIn, checkout);
			System.out.println(reservation);
			
			System.out.println("\n Enter to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy)");
			Date checkInU = sdf.parse(tcd.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			Date checkoutU = sdf.parse(tcd.next());
			
				String error = reservation.updateDates(checkInU, checkoutU);
				if(error != null) {
					System.out.println("Error in reservetion: " + error);
			}
				System.out.println(reservation);
		}
		tcd.close();
	}
}
