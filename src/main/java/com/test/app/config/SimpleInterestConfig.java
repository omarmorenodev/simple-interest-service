package com.test.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.app.service.ICalculatorInterestService;
import com.test.app.service.SimpleInterestPaymentCalculatorServiceImpl;
import com.test.app.validator.ILoanValidator;
import com.test.app.validator.LoanValidator;

@Configuration
public class SimpleInterestConfig {
	
	@Bean
	public ILoanValidator loanValidator() {
		return new LoanValidator();
	}
	
	@Bean
	public ICalculatorInterestService calculatorService() {
		return new SimpleInterestPaymentCalculatorServiceImpl();
	}
}
