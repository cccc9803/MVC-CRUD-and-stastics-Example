package com.test.model;

import java.sql.Connection;

import com.test.util.DbUtil;

public class Charge {
	private int idCharge;
	private String date;
	private String subject;
	private String reason;
	private String cost;
	private String note;

	
	public int getIdCharge() {
		return idCharge;
	}
	public void setIdCharge(int idCharge) {
		this.idCharge = idCharge;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
