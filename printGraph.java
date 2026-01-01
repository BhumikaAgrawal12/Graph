//Given an undirected graph with V nodes and E edges, create and return an adjacency list of the graph. 0-based indexing is followed everywhere.(GFG)

import java.util.*;
class printGraph{
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}

//Input:
// V = 5, E = 7
// edges = [[0,1], [0,4], [4,1], [4,3], [1,3], [1,2], [3,2]]

// Output: 
// [[1,4], [0,2,3,4], [1,3], [1,2,4], [0,1,3]]