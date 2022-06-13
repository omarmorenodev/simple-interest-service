package com.test.app.service;

import java.util.List;

import com.test.app.dto.LoanCalculatedResultDTO;
import com.test.app.dto.LoanSettingDTO;

public interface ICalculatorInterestService {
	public List<LoanCalculatedResultDTO> calculatePayments(LoanSettingDTO loanDTO);
}
