package com.test.app.validator;

import java.io.Serializable;

public class ResultValidation implements Serializable {
	
	private boolean resultOk;
	private String message;
	
	public ResultValidation() {}
	
	public ResultValidation(boolean resultOk, String message) {
		this.resultOk = resultOk;
		this.message = message;
	}

	public boolean isResultOk() {
		return resultOk;
	}

	public void setResultOk(boolean resultOk) {
		this.resultOk = resultOk;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ResultValidation generateError(String msj) {
		setResultOk(false);
		setMessage(msj);
		return this;
	}
	
	public ResultValidation ok() {
		setResultOk(true);
		return this;
	}
}
