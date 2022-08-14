package Graphs;

import java.util.*;

class Pair {
    int first;
    int second;

    public Pair(int f, int s) {
        first = f;
        second = s;
    }
}

public class ShortestPathDirectedWeighted {
    public static void main(String[] args) {
        int v = 6;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Pair>());
        }

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));

        System.out.println(Arrays.toString(shortestPath(v, adj, 0)));
    }

    public static void topologicalSortUtil(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj) {
        visited[node] = true;
        for (Pair it : adj.get(node)) {
            if (visited[it.first] == false) {
                topologicalSortUtil(it.first, visited, stack, adj);
            }
        }
        stack.add(node);
    }

    public static int[] shortestPath(int V, ArrayList<ArrayList<Pair>> adj, int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topologicalSortUtil(i, vis, stack, adj);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    if (dist[node] + it.second < dist[it.first]) {
                        dist[it.first] = dist[node] + it.second;
                    }
                }
            }
        }


        return dist;
    }
}
