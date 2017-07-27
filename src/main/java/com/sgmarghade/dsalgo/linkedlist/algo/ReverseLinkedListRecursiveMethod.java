package com.sgmarghade.dsalgo.linkedlist.algo;

import com.sgmarghade.dsalgo.linkedlist.ds.Node;
import com.sgmarghade.dsalgo.linkedlist.utils.LinkedListUtils;

public class ReverseLinkedListRecursiveMethod {
    private Node head;
    public static void main(String[] args) {
        new ReverseLinkedListRecursiveMethod().run();
    }

    private void run() {
        LinkedListUtils utils = LinkedListUtils.getInstance();
        head = utils.createSinglyLinkedList(10, 0, 1);
        System.out.println("Before reversal");
        utils.printSinglyLinkedList(head);

        reverseLinkedList(head);

        System.out.println("\n\n After reversal");
        utils.printSinglyLinkedList(head);
    }

    //Recursive call to reverseLinkedListFunction.
    private void reverseLinkedList(Node current) {
        if(current == null) {
            return;
        }


        //traverse till we reach last node and mark it as head.
        if(current.next == null) {
            head = current;
            return;
        }

        //traverse till we reach last node and mark it as head.
        //Before this step current next is pointing to next node.
        reverseLinkedList(current.next);
        //After this step current next is still pointing to next node.

        //once we reach last node, start pointing nodes in reverse direction.
        //Next node of current(current->next->next) will point to current node. and current next(current->next) will point to next node.
        //This is same as creating small circular linked list.
        current.next.next = current;

        //after this step circular linked list created will be broken and curret->next is null
        current.next = null;
    }
}
