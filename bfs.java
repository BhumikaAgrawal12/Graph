
import java.util.*;
class bfs {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int V=adj.size();
        int[] visited=new int[V];
        // for(int i=0;i<V;i++){                  //you can use this loop for disconnected graph....here we are assuming connected graph
        //     if(visited[i]==0){
                BFS(visited,adj,ans,0);//i=current node
        //     }
        // }
        return ans;
    }
    public static void BFS(int[] visited,ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ans,int node){
        Queue<Integer>q=new LinkedList<>();
        q.offer(node);
        visited[node]=1;
        while(!q.isEmpty()){
            int front_node=q.poll();
            ans.add(front_node);
            for(int nbr:adj.get(front_node)){
                if(visited[nbr]==0){
                    q.add(nbr);
                    visited[nbr]=1;
                }
            }
        }
        
    }
}

//T.C.=O(V+E)
//S.C.=O(V)