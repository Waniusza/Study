package com.gut.waniusza.semestr_5.oojp.col_4.ex_1;

/**
 *
 * @author student
 */
public class Division {

    public static double divideBy(double a, double b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }
}
