package com.sgmarghade.dsalgo.linkedlist.algo;

import com.sgmarghade.dsalgo.linkedlist.ds.Node;
import com.sgmarghade.dsalgo.linkedlist.utils.LinkedListUtils;
/**
 * Magic happens in revereseLinkedList function.
 */
public class ReverseLinkedListIterativeMethod {
    public static void main(String[] args) {
        new ReverseLinkedListIterativeMethod().run();
    }

    private void run() {
        Node head = LinkedListUtils.getInstance().createSinglyLinkedList(10, 0, 1);
        System.out.println("Input linked list.");
        LinkedListUtils.getInstance().printSinglyLinkedList(head);

        head = revereseLinkedList(head);
        System.out.println("\n\nNew linked list");
        LinkedListUtils.getInstance().printSinglyLinkedList(head);
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

}
