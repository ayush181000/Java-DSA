package Graphs;

import java.util.*;

public class BipartiteGraph {

}

class Solution {
    public boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        color[node] = 1;

        while (!q.isEmpty()) {
            int nde = q.poll();

            for (int it : adj.get(nde)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[nde];
                    q.add(it);
                } else if (color[it] == color[nde]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                color[it] = 1 - color[node];
                if (!dfsCheck(adj, it, color))
                    return false;
            } else if (color[it] == color[node]) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                color[i] = 1;
                if (!dfsCheck(adj, i, color))
                    return false;
            }
        }

        return true;
    }
}