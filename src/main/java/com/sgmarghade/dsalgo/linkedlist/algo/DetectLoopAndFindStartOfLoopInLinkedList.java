package com.sgmarghade.dsalgo.linkedlist.algo;

import com.sgmarghade.dsalgo.linkedlist.ds.Node;

/**
 * Say pointer S(slow) and F(fast) be the at head node.
 * Move S by 1 and F by 2 nodes at a time and check if they are on same node.
 * If yes -> means there is loop in linked list.
 * if loop found move S to head again and move S and F 1 node at a time , they will meet at the start of loop.
 *
 * Explanation of logic : http://www.ideserve.co.in/learn/find-intersection-of-two-linked-lists
 */
public class DetectLoopAndFindStartOfLoopInLinkedList {
    public static void main(String[] args) {
        new DetectLoopAndFindStartOfLoopInLinkedList().run();
    }

    private void run() {
        Node head = createCyclicLoop();
        Node S = head;  // Slow node moves by 1
        Node F = head;  //Fast node moves by 2
        do {
           S = S.next;
           F = F.next.next;
        }while(S != null && F != null && S != F);

        if(S == null || F == null) {
            System.out.println("Not loop in linked list");
            return;
        }

        System.out.println("Loop found in linked list");
        S = head;
        do {
            S = S.next;
            F = F.next;
        }while(S != F);

        System.out.println("Common node value is : "+S.data);
    }

    private Node createCyclicLoop() {
        Node node1 = new Node("1");
        Node node2 = new Node("9");
        Node node3 = new Node("4");
        Node node4 = new Node("2");

        Node node5 = new Node("3");
        Node node6 = new Node("7");

        Node node7 = new Node("2");
        Node node8 = new Node("9");


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node6;  //This is the loop .

        return node1;
    }
}
