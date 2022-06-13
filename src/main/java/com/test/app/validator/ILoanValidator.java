package com.test.app.validator;

import com.test.app.dto.LoanSettingDTO;

public interface ILoanValidator {
	
	public ResultValidation validate(LoanSettingDTO loanSetting);
}
