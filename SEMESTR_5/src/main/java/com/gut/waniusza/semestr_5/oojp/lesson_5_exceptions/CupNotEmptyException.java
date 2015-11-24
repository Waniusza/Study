package com.gut.waniusza.semestr_5.oojp.lesson_5_exceptions;

public class CupNotEmptyException extends Exception {

	@Override
	public String getMessage() {
		return "WARNING: the cup is not empty!";
	}

}
