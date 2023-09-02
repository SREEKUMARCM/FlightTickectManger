package com.flightTicket;

public class Paymentdetailsclass {
	private int fId;
	private int pid;
	private int amount;
	public Paymentdetailsclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Paymentdetailsclass(int fId,int pid,int amount) {
		super();
		this.fId=fId;
		this.pid=pid;
		this.amount=amount;
	
	}
}
