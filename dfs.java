import java.util.*;
class dfs {
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
         // code here
        int V=adj.size();
        boolean[] visited=new boolean[V];
        ArrayList<Integer>ans=new ArrayList<>();
        DFS(adj,ans,visited,0);
        return ans;
    }
    public static void DFS(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>ans,boolean[] visited,int node){
        visited[node]=true;
        ans.add(node);
        for(int nbr:adj.get(node)){
            if(!visited[nbr]){
                visited[nbr]=true;
                DFS(adj,ans,visited,nbr);
            }
        }
    }
    
}
//T.C.=O(V+E)
//S.C.=O(V)+O(H) for recursion stack