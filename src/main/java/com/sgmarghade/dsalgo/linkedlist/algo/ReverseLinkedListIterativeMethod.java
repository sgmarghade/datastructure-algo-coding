package com.sgmarghade.dsalgo.linkedlist.algo;

import com.sgmarghade.dsalgo.linkedlist.ds.Node;

/**
 * Magic happens in revereseLinkedList function.
 */
public class ReverseLinkedListIterativeMethod {
    public static void main(String[] args) {
        new ReverseLinkedListIterativeMethod().run();
    }

    private void run() {
        Node head = createLinkedList();
        System.out.println("Input linked list.");
        printLinkedList(head);

        head = revereseLinkedList(head);
        System.out.println("\n\nNew linked list");
        printLinkedList(head);
    }

    //All magic happens here..
    private Node revereseLinkedList(Node head) {
         Node curr = head;
         Node prev = null;
         Node next = null;

        while(curr != null) {
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         head = prev;

        return head;
    }

    private void printLinkedList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -- ");
            head = head.next;
        }
    }

    private Node createLinkedList() {
        Node head = null;
        for(int i = 0; i < 10; i++) {
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
