package com.test.app.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.test.app.dto.LoanSettingDTO;

@Service
public class WeeklyCalculatorAmount implements ICalculatorAmount {

	@Override
	public double calculate(LoanSettingDTO loanDTO) {		
		double total = loanDTO.getAmount() + (loanDTO.getAmount() * (loanDTO.getRate()/100));        
		double weeklyAmount = total/loanDTO.getTerms();
		
		BigDecimal bdWeekly = BigDecimal.valueOf(weeklyAmount);
        bdWeekly = bdWeekly.setScale(2, RoundingMode.HALF_UP);
        return bdWeekly.doubleValue();
	}

}
