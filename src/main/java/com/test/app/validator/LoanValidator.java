package com.test.app.validator;

import com.test.app.dto.LoanSettingDTO;

public class LoanValidator implements ILoanValidator {
	
    @Override
    public ResultValidation validate(LoanSettingDTO loanSetting) {
        ResultValidation result = new ResultValidation(false, null);

        if (loanSetting == null) {
            return result.generateError("No information was received to validate");
        }
        
        if (loanSetting.getAmount() < 1 || loanSetting.getAmount() > 999999) {
            return result.generateError("The range of allowed amount must be between 1 and 999999");
        }
        
        if (loanSetting.getTerms() < 4 || loanSetting.getTerms() > 52) {
            return result.generateError("The range of allowed terms must be between 4 and 52");
        }
        
        if (loanSetting.getRate() < 1 || loanSetting.getRate() > 100) {
            return result.generateError("The range of allowed rate must be between 1 and 100");
        }

        return result.ok();
    }
}
