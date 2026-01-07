import java.util.*;
class DijkstraAlgo {
    public int[] DijkstraAlgo(int V, int[][] edges, int src) {
        // code here
        int[] dist=new int[V];
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);//min heap->[node,distance] //sorted by distance
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int u=arr[0];
            int w=arr[1];
            if(w>dist[u]) continue;//skip outdated entries from the priority queue Because the same node can be inserted multiple times with different distances.
            
            for(int[] nbr:adj.get(u)){
                int v=nbr[0];
                int wt=nbr[1];
                if(w+wt<dist[v]){
                    dist[v]=w+wt;
                    pq.offer(new int[]{v,dist[v]});
                }
                
            }
        }
        return dist;
        
    }
}

