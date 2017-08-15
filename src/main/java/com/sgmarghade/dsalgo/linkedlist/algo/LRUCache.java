package com.sgmarghade.dsalgo.linkedlist.algo;

import com.sgmarghade.dsalgo.linkedlist.ds.Node;
import com.sgmarghade.dsalgo.linkedlist.utils.LinkedListUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement LRU cache using Doubly linked list and hashmap.
 * Last node in doubly linkedlist is the node to be removed when Cache is full.
 */
public class LRUCache {
    public static void main(String[] args) {
        //SIze of cache
        new LRUCache().run(8);
    }

    private void run(int limit) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Map<String, Node> map = new HashMap<String, Node>();

        for(int i = 0; i < 200; i++) {
            String randomValue = ""+(int)(Math.random() * 10);
            System.out.println("\n************** Accessed value : "+randomValue);

            //Logic
            if(map.containsKey(randomValue)) {
                String val = map.get(randomValue).data;
                linkedList.removeNode(map.get(randomValue));

                Node newNode = new Node(val);
                linkedList.addNode(newNode);

                map.put(randomValue, newNode);
            }else {
                Node node = new Node(randomValue);
                map.put(randomValue, node);
                if(linkedList.totalNodes < limit) {
                   linkedList.addNode(node);
                }else {
                    System.out.println("Limit reached");
                    //Remove reference from map.
                    map.remove(linkedList.tail.data);
                    //Remove tail as it's LRU value.
                    linkedList.removeTail();
                    //Add new node
                    linkedList.addNode(node);
                }
            }

            LinkedListUtils.getInstance().printSinglyLinkedList(linkedList.head);
        }
    }
}


class DoublyLinkedList {
    public int totalNodes = 0;
    public Node head;
    public Node tail;

    public DoublyLinkedList() {

    }

    public Node addNode(Node newNode) {
        totalNodes++;
        if(head == null) {
            head = newNode;
            tail = newNode;
        }else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }

        return newNode;
    }

    //This node has same reference as node when it was created.
    public void removeNode(Node node) {



        totalNodes--;

        //Node is head.
        if(node.data.equalsIgnoreCase(head.data)) {
            head = node.next;
            if(head != null) {
                head.prev = null;
            }
            node.next = null;
            node.prev = null;
            //Node is tail.
        }else if(node.data.equalsIgnoreCase(tail.data)) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
        }else {
            //Node is in between.
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
    }

    public void removeTail() {
        Node toRemove = tail;
        tail = toRemove.prev;
        toRemove.prev = null;
        tail.next = null;
    }
}
