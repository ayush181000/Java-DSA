package Graphs;

import java.util.*;

public class ShortestPathUndirectedGraph {


    public static void main(String[] args) {
        int v = 8;

        // Adjacency list for storing which vertices are connected
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source
        // and destination vertex as argument and forms
        // an edge between them.
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        int source = 0;

        System.out.println(Arrays.toString(shortestPath(v, adj, source)));
    }

    public static int[] shortestPath(int V, ArrayList<ArrayList<Integer>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, 1000000000);
        Queue<Integer> q = new LinkedList<>();

        dist[src] = 0;
        q.add(src);


        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }

            }
        }

        return dist;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
}
