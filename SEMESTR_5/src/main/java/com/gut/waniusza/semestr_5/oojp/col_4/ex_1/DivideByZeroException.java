
package com.gut.waniusza.semestr_5.oojp.col_4.ex_1;

/**
 *
 * @author student
 */

public class DivideByZeroException extends Exception {

    public DivideByZeroException() {
        super();
    }

    @Override
    public String getMessage() {
        return "WARNING: you tried to divide by zero!";
    }
}
