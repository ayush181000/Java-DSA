package Graphs;


import java.util.*;

public class DijkstrasAlgorithm {

    public static int[] shortestPath(int S, int V, ArrayList<ArrayList<Node>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, 10000);

        dist[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
        pq.add(new Node(S, 0));

        while (pq.size() > 0) {
            Node node = pq.poll();

            for (Node it : adj.get(node.getV())) {
                if (dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }

        return dist;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        int V = 5;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Node>());
        }

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));



        int[] dist = shortestPath(4, V, adj);
        System.out.println(Arrays.toString(dist));
    }


    static class Node implements Comparator<Node> {
        int V;
        int weight;

        public Node() {
        }

        public Node(int V, int weight) {
            this.V = V;
            this.weight = weight;
        }

        public int getV() {
            return this.V;
        }

        public int getWeight() {
            return this.weight;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.getWeight() < node2.getWeight()) return -1;
            else if (node1.getWeight() > node2.getWeight()) return 1;
            else return 0;
        }
    }
}
