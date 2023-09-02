package com.flightTicket;

public class FlightDetails {
	private int flightId;
	private  String flightName;
	private String source;
	private String destination ;
	private int numberOfSeats;
	private int price;
	private int persionId;
	private String date;
	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlightDetails(int flightId,String flightName, String source,String destination,int numberOfSeats,int price,int persionId,String date) {
		super();
		this.flightId=flightId;
		this.flightName=flightName;
		this.source=source;
		this.destination=destination;
		this.numberOfSeats=numberOfSeats;
		this.price=price;
		this.persionId=persionId;
		this.date=date;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPersionId() {
		return persionId;
	}
	public void setPersionId(int persionId) {
		this.persionId = persionId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
