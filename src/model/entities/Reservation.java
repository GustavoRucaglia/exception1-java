package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static Date now = new Date();
	private Integer roomNumber;
	private Date chekin;
	private Date chekout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date chekin, Date chekout) {
		this.roomNumber = roomNumber;
		this.chekin = chekin;
		this.chekout = chekout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChekin() {
		return chekin;
	}

	public Date getChekout() {
		return chekout;
	}
	
	public long duration() {
		long diff = chekout.getTime() - chekin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	public String updateDates(Date chekin, Date chekout) {
		if(chekin.before(now) || chekout.before(now)) {
			return "error in reservation: Update must be after now";
		}
		if(! chekout.after(chekin)){
			return "error in reservation: Check-out must be after check-in date ";
		} else {
			this.chekin = chekin;
			this.chekout =chekout;
			return null;
		}
	}

	@Override
	public String toString() {
		return "Rom"
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(chekin)
				+ ", check-out "
				+ sdf.format(getChekout())
				+ ", "
				+ duration()
				+ " nights"
				;
	}
	
	
}
