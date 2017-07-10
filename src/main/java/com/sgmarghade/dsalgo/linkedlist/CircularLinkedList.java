package com.sgmarghade.dsalgo.linkedlist;

import java.util.Scanner;

/**
 * Beginning node position does not matter in this case.
 */
public class CircularLinkedList {
    public static void main(String[] args) {
        new CircularLinkedList().run();
    }

    private void run() {
        Node head = null;
        Scanner sc = new Scanner(System.in);

        while(true) {
            printListForward(head);

            System.out.println("Enter your choices below : 1 for insert, 2 for delete");
            int command = sc.nextInt();

            if(command == 1) {
                System.out.println("Enter valid string data");
                String nextInput = sc.next();

                Node newNode = new Node(nextInput);

                //Special condition when there is no node.
                if(head == null) {
                    head = newNode;
                    newNode.next = head;
                    continue;
                }

                //Just traverse the next ndoe and assign value.
                Node tracer = head.next;
                head.next = newNode;
                newNode.next = tracer;

            }else if(command == 2) {
                System.out.println("Enter valid string data to delete");
                String stringToDelete = sc.next();

                //No node exists
                if(head == null) {
                    System.out.println("List is empty");
                    continue;
                }

                //Special case when head = node = single node
                if(head.next == head && head.data.equalsIgnoreCase(stringToDelete)) {
                    head = null;
                    continue;
                }

                Node tracer = head; //We need this reference to avoid infinite loop.

                //Traverse till we find element.
                while(tracer.next != head && !tracer.next.data.equalsIgnoreCase(stringToDelete)) {
                    tracer = tracer.next;
                }

                //Here check if tracer.data is matching

                if(tracer.next.data.equalsIgnoreCase(stringToDelete)) {
                    Node nodeToDelete = tracer.next;
                    tracer.next = nodeToDelete.next;
                    nodeToDelete.next = null;
                }

                //Assign back head to tracer. It's circular linked list, head position doesnt matter
                head = tracer;

            }else {
                break;
            }
        }

        System.out.println("Final List");
        printListForward(head);
    }

    private void printListForward(Node head) {
        if(head == null ){
            System.out.println("List is empty");
            return;
        }

        System.out.println("Printing..!");
        Node tracer = head;

        do{
            System.out.print(tracer.data +" -- ");
            tracer = tracer.next;
        }while(tracer != head);
    }
}
