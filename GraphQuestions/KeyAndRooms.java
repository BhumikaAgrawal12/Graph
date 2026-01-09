import java.util.*;
class KeyAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int V=rooms.size();
        boolean[] visited=new boolean[V];
        List<Integer>ans=new ArrayList<>();
         dfs(rooms,visited,ans,0);
         return ans.size()==V;
    }
    void dfs(List<List<Integer>> rooms,boolean[] visited,List<Integer>ans,int node){
        visited[node]=true;
        ans.add(node);
        for(int nbr:rooms.get(node)){
            if(!visited[nbr]){
                dfs(rooms,visited,ans,nbr);
            }
        }
    }
}