package Graphs;

import java.util.*;

public class DetectCycleDirect {

}

/* Complete the function below */

class Solution1 {
    // Function to detect cycle in a directed graph.
    public boolean dfsCheck(int node, boolean[] vis, boolean[] dfsVis, ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;
        dfsVis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (dfsCheck(it, vis, dfsVis, adj))
                    return true;
            } else if (dfsVis[it])
                return true;
        }

        dfsVis[node] = false;
        return false;
    }

    public boolean isCyclicDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] dfsVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfsCheck(i, vis, dfsVis, adj))
                    return true;
            }
        }

        return false;
    }

    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];

        // finding indegree
        for (int i = 0; i < N; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            // adding nodes to queue with indegree = 0
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        int ind = 0;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            topo[ind++] = node;
            cnt++;
            // getting neighbour nodes of popped node and decreasing their
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        if (cnt == N)
            return false;
        return true;
    }
}