package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
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
	public void updateDates(Date chekin, Date chekout) {
		this.chekin = chekin;
		this.chekout =chekout;
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
