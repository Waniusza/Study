package com.gut.waniusza.semestr_5.oojp.col_4.ex_2;

/**
 *
 * @author student
 */
public class InternalNode extends Node{

    Data data;
    Node nextNode;
    
    public InternalNode(Data data, Node nextNode) {
        data = data;
        nextNode = nextNode;
    }

    @Override
    public Node insert(Data newData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
