package com.sgmarghade.dsalgo.linkedlist.utils;

import com.sgmarghade.dsalgo.linkedlist.ds.Node;

public class LinkedListUtils {
    private static LinkedListUtils ourInstance = new LinkedListUtils();

    public static LinkedListUtils getInstance() {
        return ourInstance;
    }

    private LinkedListUtils() {

    }

    public void printSinglyLinkedList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -- ");
            head = head.next;
        }
    }

    public Node createSinglyLinkedList(int endValue, int startValue, int interval) {
        Node head = null;
        for(int i = startValue; i < endValue; i=i+interval) {
            Node newNode = new Node(i+"");
            if(head == null) {
                head = newNode;
            }else {
                Node current = head;
                while(current.next != null) {
                    current = current.next;
                }

                current.next = newNode;
            }
        }

        return head;
    }
}
