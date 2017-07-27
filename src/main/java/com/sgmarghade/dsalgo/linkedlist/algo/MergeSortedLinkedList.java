package com.sgmarghade.dsalgo.linkedlist.algo;

import com.sgmarghade.dsalgo.linkedlist.ds.Node;
import com.sgmarghade.dsalgo.linkedlist.utils.LinkedListUtils;

public class MergeSortedLinkedList {
    public static void main(String[] args) {

        new MergeSortedLinkedList().run();

    }

    private void run() {

        LinkedListUtils utils = LinkedListUtils.getInstance();
        Node head1 = utils.createSinglyLinkedList(10, 0, 2);
        Node head2 = utils.createSinglyLinkedList(10, 1, 2);
        Node mergedHead = null;

        System.out.println("Before merge List1");
        utils.printSinglyLinkedList(head1);
        System.out.println("\n\nBefore merge List2");
        utils.printSinglyLinkedList(head2);

        //Continue till both head points to null
        while(head1 != null || head2 != null) {
            if(head1 == null) {
                //1st list is empty add all nodes from 2nd list
                mergedHead = addNodeToMergedList(head2, mergedHead);
                head2 = head2.next;
            }else if(head2 == null) {
                //2nd list is empty add all nodes from 1st list
                mergedHead = addNodeToMergedList(head1, mergedHead);
                head1 = head1.next;
            }else {
                //No list is empty. Just handle scenarios to compare values and add them.
                if(new Integer(head1.data) <= new Integer(head2.data)) {
                    mergedHead = addNodeToMergedList(head1, mergedHead);
                    head1 = head1.next;
                }else {
                    mergedHead = addNodeToMergedList(head2, mergedHead);
                    head2 = head2.next;
                }
            }
        }

        System.out.println("\n\nMerged list");
        utils.printSinglyLinkedList(mergedHead);
    }

    //Simple method to add node to list.
    private Node addNodeToMergedList(Node nodeToAdd, Node mergedHead) {
        if(mergedHead == null) {
            mergedHead = new Node(nodeToAdd.data);
        }else {
            Node tracer = mergedHead;
            while(tracer.next != null) {
                tracer = tracer.next;
            }
            tracer.next = new Node(nodeToAdd.data);
        }
        return mergedHead;
    }

}
