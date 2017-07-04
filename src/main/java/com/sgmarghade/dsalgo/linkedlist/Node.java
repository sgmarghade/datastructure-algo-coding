package com.sgmarghade.dsalgo.linkedlist;

public class Node {
    public String data;
    public Node next;
    public Node prev; //Used for doubly linked list.

    public Node(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }
}
