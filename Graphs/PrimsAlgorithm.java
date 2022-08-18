package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    public static void primsAlgo(ArrayList<ArrayList<Node>> adj, int n) {
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean mstSet[] = new boolean[n];

        Arrays.fill(key, 100000);
        Arrays.fill(parent, -1);
        Arrays.fill(mstSet, false);

        key[0] = 0;

        for (int i = 0; i < n - 1; i++) {

            int mini = Integer.MAX_VALUE, u = 0;
            for (int v = 0; v < n; v++) {
                if (!mstSet[v] && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }

            mstSet[u] = true;

            for (Node it : adj.get(u)) {
                if (!mstSet[it.getV()] && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                }
            }

        }

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i);
        }

    }

    public static void primesAlgoEfficient(ArrayList<ArrayList<Node>> adj, int n) {
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean mstSet[] = new boolean[n];

        Arrays.fill(key, 100000);
        Arrays.fill(parent, -1);
        Arrays.fill(mstSet, false);

        PriorityQueue<Node> pq = new PriorityQueue<>(n, new Node());

        key[0] = 0;
        pq.add(new Node(0, key[0]));

        for (int i = 0; i < n - 1; i++) {

            int u = pq.poll().getV();
            mstSet[u] = true;


            for (Node it : adj.get(u)) {
                if (!mstSet[it.getV()] && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }

        }

        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        primesAlgoEfficient(adj, n);
    }
}
