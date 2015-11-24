package com.gut.waniusza.semestr_5.oojp.col_4.ex_1;

/**
 *
 * @author student
 */
public class DivisionTest {
    public static void main(String[] args) {
        double x = 2.3;
        double y = 0.0;
        try {
            System.out.println("x/y="+Division.divideBy(x,y));
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
}
