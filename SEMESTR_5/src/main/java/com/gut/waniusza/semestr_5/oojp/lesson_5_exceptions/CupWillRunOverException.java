package com.gut.waniusza.semestr_5.oojp.lesson_5_exceptions;

public class CupWillRunOverException extends Exception {

	@Override
	public String getMessage() {
		return "WARNING: the cup will run over!";
	}

}
