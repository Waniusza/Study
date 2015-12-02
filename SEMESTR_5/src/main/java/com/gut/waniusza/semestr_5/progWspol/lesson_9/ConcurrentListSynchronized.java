package com.gut.waniusza.semestr_5.progWspol.lesson_9;

public class ConcurrentListSynchronized {

    protected class Node {

        int value;
        Node previous;
        Node next;

        Node() {
        }

        public Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    protected final Node head;
    protected final Node tail;

    public ConcurrentListSynchronized() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    @Override
    public String toString() {
        String output = "ConcurrentList [";
        Node current = head;
        while (current.next != tail) {
            current = current.next;
            output += " " + current.value;
        }
        output += "]";
        return output;
    }

    public synchronized void insert(int value) {
        Node current = head;
        Node next = current.next;

        if (next == tail || next.value < value) {
            Node node = new Node(value, current, next);
            next.previous = node;
            current.next = node;
            return;
        }
        current = next;
        next = current.next;

    }

}
