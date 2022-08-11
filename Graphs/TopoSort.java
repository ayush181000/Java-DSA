package Graphs;

import java.util.*;

public class TopoSort {

}

// DFS TOPO SORT

class Solution {
    // Function to return list containing vertices in Topological order.
    public int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
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

        int ind = 0;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            topo[ind++] = node;

            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }
}
