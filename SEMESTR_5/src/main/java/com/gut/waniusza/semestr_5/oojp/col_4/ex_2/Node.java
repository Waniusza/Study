package com.gut.waniusza.semestr_5.oojp.col_4.ex_2;

/**
 *
 * @author student
 */
public abstract class Node {

    Data value;
    Node nextNode;

    public Node() {
    }

    public abstract Node insert(Data newData);

    public abstract void print();

}
