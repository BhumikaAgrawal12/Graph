import java.util.*;

public class Kruskals_MST {

    public static void main(String[] args) {

        // Example graph: edges = {u, v, weight}
        int V =9 ;
        int[][] edges = {
                {0, 1, 4},
                {0, 7, 8},
                {1, 2, 8},
                {1, 7, 11},
                {2, 3, 7},
                {2, 8, 2},
                {2, 5, 4},
                {3, 4, 9},
                {3, 5, 14},
                {4, 5, 10},
                {5, 6, 2},
                {6, 7, 1},
                {6, 8, 6},
                {7, 8, 7}
        };

        int mstCost = kruskalsMST(V, edges);
        System.out.println("Minimum Spanning Tree Cost = " + mstCost);
    }

    // ---------- KRUSKAL'S ALGORITHM ----------
    public static int kruskalsMST(int V, int[][] edges) {

        UnionFind uf = new UnionFind(V);
        int minCost = 0;

        // sort edges by weight
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (uf.union(u, v)) {
                minCost += wt;
            }
        }

        return minCost;
    }
}

// ---------- DISJOINT SET UNION (UNION-FIND) ----------
class UnionFind {

    int[] parent;
    int[] rank;

    UnionFind(int V) {
        parent = new int[V];
        rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    // Path compression
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    boolean union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return false;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }

        return true;
    }
}
