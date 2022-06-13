package com.test.app.dto;

public class LoanSettingDTO {
	
	private double amount;
    
    private int terms;
    
    private double rate;

    public LoanSettingDTO(double amount, int terms, double rate) {
        this.amount = amount;
        this.terms = terms;
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
