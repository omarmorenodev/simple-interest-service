package com.test.app.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.app.common.WeeklySchedulerPayment;
import com.test.app.dto.LoanCalculatedResultDTO;
import com.test.app.dto.LoanSettingDTO;

import java.text.SimpleDateFormat;


public class SimpleInterestPaymentCalculatorServiceImpl implements ICalculatorInterestService {
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private ICalculatorAmount weeklyCalculatorService;
	
	@Override
	public List<LoanCalculatedResultDTO> calculatePayments(LoanSettingDTO loanDTO) {		
        List<String> calculatedDates = WeeklySchedulerPayment.calculateDatesByTerms(loanDTO.getTerms());        
        
        double weeklyAmount = weeklyCalculatorService.calculate(loanDTO);
        
        AtomicInteger counter = new AtomicInteger(1);
        
        List<LoanCalculatedResultDTO> result = calculatedDates.stream()
        		.map(calcDate -> new LoanCalculatedResultDTO(counter.getAndIncrement(), weeklyAmount, calcDate))
                .collect(Collectors.toList());
        
        return result;
	}
	
}
