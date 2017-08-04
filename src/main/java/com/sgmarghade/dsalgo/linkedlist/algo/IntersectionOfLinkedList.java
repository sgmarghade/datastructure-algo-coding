package com.sgmarghade.dsalgo.linkedlist.algo;

import com.sgmarghade.dsalgo.linkedlist.ds.Node;
import com.sgmarghade.dsalgo.linkedlist.utils.LinkedListUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * There wont be any common node unless its merged at that point.
 * List a -> 2,3,4,5,6,7
 * List b -> 9,0,4,5,6,7
 *
 * In Above example list is merged at node value 4
 */
public class IntersectionOfLinkedList {
    public static void main(String[] args) {
        new IntersectionOfLinkedList().run();
    }

    private void run() {
        Node list1 = LinkedListUtils.getInstance().createSinglyLinkedListFromArray(new int[]{2,3,4,5,6,7});
        Node list2 = LinkedListUtils.getInstance().createSinglyLinkedListFromArray(new int[]{9,0,4,5,6,7});
        Map<String, Node> map = new HashMap<String, Node>();

        Node traverse = list1;
        while(traverse != null) {
            map.put(traverse.data, traverse);
            traverse = traverse.next;
        }

        traverse = list2;
        Node matchedNode = null;

        while (traverse != null) {
            if(map.get(traverse.data) != null) {
                matchedNode = map.get(traverse.data);
                break;
            }

            traverse = traverse.next;
        }
        if(matchedNode != null) {
            System.out.println("Intersection value is "+matchedNode.data);
        }else {
            System.out.println("Sorry no value matched");
        }
    }
}
