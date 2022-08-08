package Graphs;

import java.util.*;

public class BFS {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (vis[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);

                    for (Integer it : adj.get(node)) {
                        if (!vis[it]) {
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {

    }
}
