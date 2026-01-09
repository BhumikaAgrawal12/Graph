import java.util.*;
public class CheapestFlightsWithinKstops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        ArrayList<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:flights){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new int[]{v,wt});
        }
        Queue<int[]>q=new LinkedList<>();//remove element on the basis of its stops which is usually +1 everytime so we dont need priority queue here
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        q.add(new int[]{src,0,0});  //{node,wt,stops}
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int u=arr[0];
            int wt=arr[1];
            int stops=arr[2];
            if(stops>k){
                continue;
            }
            for(int[] nbr:adj.get(u)){
                int v=nbr[0];
                int w=nbr[1];
                if(w+wt<dist[v]){
                    dist[v]=w+wt;
                    q.add(new int[]{v,dist[v],stops+1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}