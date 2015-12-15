package com.gut.waniusza.semestr_5.oojp.col_5;

/**
 *
 * @author student
 */
public interface Movable {
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    default void move(double deltaX, double deltaY) {
        setX(getX() - deltaX);
        setY(getY() - deltaY);
    }   };
