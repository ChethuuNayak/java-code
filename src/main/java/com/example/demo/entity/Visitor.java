package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visit")
public class Visitor{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name="visitor",nullable = false)
   private String visitorName;
   @Column(name="cardNumber")
   private int cardNo;
   @Column(name="date")
   private Date date;
   @Column(name="allow")
   private boolean allowStatus;
   
public Visitor() {
	super();
}
public Visitor(String visitorName, int cardNo, Date date, boolean allowStatus) {
	super();
	this.visitorName = visitorName;
	this.cardNo = cardNo;
	this.date = date;
	this.allowStatus = allowStatus;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getVisitorName() {
	return visitorName;
}
public void setVisitorName(String visitorName) {
	this.visitorName = visitorName;
}
public int getCardNo() {
	return cardNo;
}
public void setCardNo(int cardNo) {
	this.cardNo = cardNo;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public boolean isAllowStatus() {
	return allowStatus;
}
public void setAllowStatus(boolean allowStatus) {
	this.allowStatus = allowStatus;
}
   
}
