package com.test.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.dto.LoanCalculatedResultDTO;
import com.test.app.dto.LoanSettingDTO;
import com.test.app.response.ResponseHandler;
import com.test.app.service.ICalculatorInterestService;
import com.test.app.validator.ILoanValidator;
import com.test.app.validator.ResultValidation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class SimpleInterestController {
	
	Logger logger = LoggerFactory.getLogger(SimpleInterestController.class);
	
	@Autowired
	private ILoanValidator validatorService;
	
	@Autowired
	private ICalculatorInterestService calculatorService;
	
	@PostMapping("/health")
	@ApiOperation(notes = "This function takes the current date as a base and calculates the next payments for the loan", value = "Calculate the payment breakdown for loans")
	@ApiResponses({ 
		@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Success"),
		@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Bad request"),
		@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "An error ocurred")
	})
	public ResponseEntity<Object> calculate(@RequestBody LoanSettingDTO loanDTO	) {
		try {
			ResultValidation resultValidation = validatorService.validate(loanDTO);
			
			if(!resultValidation.isResultOk()) {
				return ResponseHandler.generateResponse(resultValidation.getMessage(),
						HttpStatus.BAD_REQUEST, null);
			}
			
			List<LoanCalculatedResultDTO> paymentsBreakdown = calculatorService.calculatePayments(loanDTO);
			
			return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, paymentsBreakdown);
			
		} catch (Exception e) {
			logger.error("An error ocurred", e);
			return ResponseHandler.generateResponse("An error ocurring during operation",
					HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
}
