import java.util.*;
class Solution {
    public int PrimsAlgoMST(int V, int[][] edges) {
        // code here
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        boolean[] visited=new boolean[V];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int minWt=0;
        //ArrayList<int[]>MST_Path=new ArrayList<>();
        pq.offer(new int[]{0,0,0});//[node,parent,wt]
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int node=arr[0];
            int parent=arr[1];
            int wt=arr[2];
            if(!visited[node]){
                visited[node]=true;
                minWt+=wt;
               // MST_Path.add(new int[]{parent,node});
                for(int[] nbrNode:adj.get(node)){
                    int nbr=nbrNode[0];
                    int w=nbrNode[1];
                    if(!visited[nbr]){
                        pq.offer(new int[]{nbr,node,w});
                    }
                }
            }
        }
        // for(int[] edge:MST_Path){
        //     int u=edge[0];
        //     int v=edge[1];
        //     System.out.println(u+"->"+v);
        // }
        return minWt;
    }
    
}
