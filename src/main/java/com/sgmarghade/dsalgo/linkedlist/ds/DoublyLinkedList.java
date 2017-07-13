package com.sgmarghade.dsalgo.linkedlist.ds;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class DoublyLinkedList {
    public static void main(String[] args) {
        new DoublyLinkedList().run();
    }

    private void run() {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            printListForward(head);
            printListBackward(head);

            System.out.println("Enter your choices below : 1 for insert, 2 for delete");
            int command = sc.nextInt();

            if (command == 1) {
                //Add node to singly linked list
                //Create new node and attach head to it.
                System.out.println("Enter valid string data");
                String nextInput = sc.next();
                Node newNode = new Node(nextInput);

                newNode.next = head;

                //When it's 1st node. head will be null
                if(head == null) {
                    head = newNode;
                    continue;
                }

                head.prev = newNode;
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

                //When only we have head node (1 node)
                if(head.next == null && head.data.equalsIgnoreCase(stringToDelete)) {
                    head = null;
                    continue;
                }

                //It can be 1st node (head node)
                if(head.data.equalsIgnoreCase(stringToDelete)) {
                    Node nodeToDelete = head;
                    head = head.next;
                    head.prev = null;

                    nodeToDelete.next = null;
                    nodeToDelete.prev = null;
                    continue;
                }

                //Any other node other than head
                Node tracer = head;
                while(tracer.next != null) {
                    Node nodeToDelete = tracer.next;
                    if(nodeToDelete.data.equalsIgnoreCase(stringToDelete)) {
                        tracer.next = nodeToDelete.next;  //same as tracer.next.next

                        //NodeToDelete can be last node whose next is null
                        if(nodeToDelete.next != null) {
                            tracer.next.prev = tracer;
                        }

                        nodeToDelete.next = null; //Will be collected by GC
                        nodeToDelete.prev = null;
                    }else {
                        tracer = nodeToDelete; //same as tracer.next.next
                    }
                }


            } else {
                break;
            }
        }

        System.out.println("Final list is : ");
        printListForward(head);
        printListBackward(head);
    }


    private void printListForward(Node head) {
        System.out.println("Printing forward....");
        Node tracer = head;
        while (tracer != null) {
            System.out.print(tracer.data);
            System.out.print(" -- ");
            tracer = tracer.next;
        }
        System.out.println("");
    }

    private void printListBackward(Node head) {

        System.out.println("Printing backward....");
        Node tracer = head;

        if(tracer == null) {
            return;
        }

        //Take tracer to last node.
        while(tracer.next != null) {
            tracer = tracer.next;
        }

        while (tracer != null) {
            System.out.print(tracer.data);
            System.out.print(" -- ");
            tracer = tracer.prev;
        }
        System.out.println("");
    }
}
