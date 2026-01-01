import java.util.*;

// undirected graph cycle detection (using DFS)
class CycleDetection {
    public boolean cycleDetectDFS(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adj=new ArrayList<>();
         for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        //int[] parent=new int[adj.size()];
        boolean visited[]=new boolean[V];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int parent=-1;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCycle(visited,adj,i,parent)) 
                    return true;
            }
        }
        return false;
    }
    boolean isCycle(boolean[] visited,List<List<Integer>>adj,int node,int parent){
        visited[node]=true;
        for(int nbr:adj.get(node)){
            if(!visited[nbr]){
                if(isCycle(visited,adj,nbr,node)){
                    return true;
                }
            }
            else if(nbr!=parent){
                return true;
            }
        }
        return false;
        
    }
}

 //Using BFS

// class Solution {
//     public boolean isCycle(int V, int[][] edges) {
//         // Code here
       
        
//         List<List<Integer>>adj=new ArrayList<>();
//          for(int i = 0; i < V; i++){
//             adj.add(new ArrayList<>());
//         }
//         //int[] parent=new int[adj.size()];
//         boolean visited[]=new boolean[V];
//         for(int[] edge:edges){
//             int u=edge[0];
//             int v=edge[1];
//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }
//         int parent=-1;
//         for(int i=0;i<V;i++){
//             if(!visited[i]){
//                 if(isCycle(adj,visited,i,parent)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     boolean isCycle(List<List<Integer>>adj,boolean[] visited,int node,int parent){
//         Queue<int[]>q=new LinkedList<>();
//         visited[node]=true;
//         q.offer(new int[]{node,parent});
//         while(!q.isEmpty()){
//             int[] arr=q.poll();
//             int curr_node=arr[0];
//             int curr_parent=arr[1];
//             for(int nbr:adj.get(curr_node)){
//                 if(!visited[nbr]){
//                     visited[nbr]=true;
//                     q.add(new int[]{nbr,curr_node});
//                 }
//                 else if(nbr!=curr_parent){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }