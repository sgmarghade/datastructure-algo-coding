package com.sgmarghade.dsalgo.linkedlist;

import java.util.Scanner;

/**
 * Basic example of SinglyLinked list.
 * 1. Insert node :
 *     Create new node and assign head to new node and new node next to previous head.
 *
 * 2. Deleting node :
 *    Special case check if list is empty.
 *    If not , check if list has only 1 element
 *    If not start with loop with head.next != null;
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        new SinglyLinkedList().run();
    }

    private void run() {
        //Write logic here.
        Node head = null; //First node      head->[recent inserted node]->[]->[2nd node]->[1st inserted]
        Scanner sc = new Scanner(System.in);

        while (true) {
            printList(head);

            System.out.println("Enter your choices below : 1 for insert, 2 for delete");
            int command = sc.nextInt();

            if (command == 1) {
                //Add node to singly linked list
                //Create new node and attach head to it.
                System.out.println("Enter valid string data");
                String nextInput = sc.next();
                Node newNode = new Node(nextInput);

                newNode.next = head;
                head = newNode; //Attach node to head. head -> new node -> previous node

            } else if (command == 2) {
                System.out.println("Enter valid string data to delete");
                String stringToDelete = sc.next();

                //It can be 1st element
                if(head == null) {
                    System.out.println("No element found. List is empty");
                    continue;
                }

                //It can be head value.
                if(head.data.equalsIgnoreCase(stringToDelete)) {
                    head = head.next;
                    continue;
                }

                Node tracer = head;

                while(tracer.next != null) {
                    Node nodeToDelete = tracer.next;
                    if(nodeToDelete.data.equalsIgnoreCase(stringToDelete)) {
                        tracer.next = nodeToDelete.next;  //same as tracer.next.next
                        nodeToDelete.next = null; //Will be collected by GC
                    }else {
                        tracer = nodeToDelete; //same as tracer.next.next
                    }
                }


            } else {
                break;
            }
        }

        System.out.println("Final list is : ");
        printList(head);
    }

    private void printList(Node head) {
        System.out.println("Printing....");
        Node tracer = head;
        while (tracer != null) {
            System.out.print(tracer.data);
            System.out.print(" -- ");
            tracer = tracer.next;
        }
        System.out.println("");
    }
}
