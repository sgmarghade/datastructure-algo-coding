package com.sgmarghade.dsalgo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swapnil on 20/11/16.
 * Given graph find out total number of hops available from startNode to endNode with limit of max weight (Assume weight is 1).
 * Eg Graph
 * A->B->C
 * A->C
 * C->A
 *
 * input : A,C,2
 * output : 2 (A->B->C && A->C)
 *
 * input : A,C,3
 * output : 3 (A->B->C && A->C && A->C->A->C)
 *
 */
public class Main {
    public static void main(String[] args) {
        //Ex

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        nodeA.addEdge(nodeB);
        nodeB.addEdge(nodeC);
        nodeA.addEdge(nodeC);
        nodeC.addEdge(nodeA);

        System.out.println("With max 1 hops : "+new Main().run(nodeA,nodeC,1));
        System.out.println("With max 2 hops : "+new Main().run(nodeA,nodeC,2));
        System.out.println("With max 3 hops : "+new Main().run(nodeA,nodeC,3));

        //(A->B->C), (A->C), (A->C-A->C), (A->B->C->A->B), (A->C->A->B->C)
        System.out.println("With max 4 hops : "+new Main().run(nodeA,nodeC,4));

    }

    public int run(Node startNode, Node toNode, int hopsAvailable) {

        int totalHops = 0;

        if (hopsAvailable <= 0) {
            return 0;
        }

        for (Node edge : startNode.getEdges()) {
            if (edge.getValue().equalsIgnoreCase(toNode.getValue())) {
                totalHops++;
            }

            totalHops += run(edge, toNode, hopsAvailable - 1);
        }


        return totalHops;
    }

    static class Node {

        private String value;
        private List<Node> edges = new ArrayList<Node>();

        public Node(String value) {
            this.value = value;
        }

        public void addEdge(Node toNode) {
            edges.add(toNode);
        }

        public List<Node> getEdges() {
            return edges;
        }

        public String getValue() {
            return value;
        }
    }
}
