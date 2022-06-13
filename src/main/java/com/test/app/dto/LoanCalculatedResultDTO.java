package com.test.app.dto;

import java.util.Date;

public class LoanCalculatedResultDTO {
	
	private int paymentNumber;
    
    private double amount;
    
    private String paymentDate;

	public LoanCalculatedResultDTO(int paymentNumber, double amount, String paymentDate) {
		super();
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public int getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
}
