 // USING (BFS+INDEGREE ARRAY)--->KAHN'S ALGO
import java.util.*;
class TopoSort_BFS{
    public ArrayList<Integer> TopoSort_BFS(int V, int[][] edges) {
       
       ArrayList<Integer>ans=new ArrayList<>();
       List<List<Integer>>adj=new ArrayList<>();
       int[] indegree=new int[V];
       Queue<Integer>q=new LinkedList<>();
       
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       for(int[] edge:edges){
           int u=edge[0];
           int v=edge[1];
           adj.get(u).add(v);
       }
       for(int i=0;i<V;i++){
           for(int nei:adj.get(i)){
               indegree[nei]++;
           }
       }
       for(int i=0;i<V;i++){
           if(indegree[i]==0){
               q.offer(i);
           }
       }
       while(!q.isEmpty()){
           int node=q.poll();
           ans.add(node);
           for(int nei:adj.get(node)){
               indegree[nei]--;
               if(indegree[nei]==0){
                   q.offer(nei);
               }
           }
       }
       return ans;
        
    }
}