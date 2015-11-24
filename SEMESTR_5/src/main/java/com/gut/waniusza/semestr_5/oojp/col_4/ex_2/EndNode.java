package com.gut.waniusza.semestr_5.oojp.col_4.ex_2;

/**
 *
 * @author student
 */
public class EndNode extends Node {

    Node lastNode;

    public EndNode(Node previousNode, Data value) {
        super();
        this.insert(value);
    }

    @Override
    public Node insert(Data newData) {

        Node newNode = new InternalNode(newData, this);
        this.lastNode = newNode;
        return this;
    }

    @Override
    public void print() {
        System.out.println("Hi! I',m last one Node, so I can't have Data :<");
        System.out.print("But last dataable(sounds nice) Node wouls say you ");
        lastNode.print();
    }
}
