import java.util.*;
class Solution {
    public ArrayList<Integer> TopoSort_DFS(int V, int[][] edges) {
        // code here
        boolean visited[]=new boolean[V];
        Stack<Integer>st=new Stack<>();
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adj,visited,st,i);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    void dfs(List<List<Integer>>adj,boolean visited[],Stack<Integer>st,int node){
        visited[node]=true;
        for(int nbr:adj.get(node)){
            if(!visited[nbr]){
                dfs(adj,visited,st,nbr);
            }
        }
        st.push(node);
    }
}