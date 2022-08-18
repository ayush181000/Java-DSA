package Graphs;

import java.util.Comparator;

public class Node implements Comparator<Node> {
    private int V;
    private int weight;

    public Node(int V, int weight) {
        this.V = V;
        this.weight = weight;
    }

    public Node() {

    }

    public int getV() {
        return this.V;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compare(Node n1, Node n2) {
        if (n1.getWeight() < n2.getWeight()) return -1;
        else if (n1.getWeight() > n2.getWeight()) return 1;
        else return 0;
    }
}