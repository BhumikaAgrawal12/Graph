import java.util.*;
class BipartiteGraph {
    public boolean possibleBipartition(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer>q=new LinkedList<>();
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                color[i]=0;
                q.add(i);
            }
            while(!q.isEmpty()){
                int node=q.poll();
                for(int nbr:adj.get(node)){
                    if(color[nbr]==-1){
                        color[nbr]=1-color[node];
                        q.add(nbr);
                    }
                    else if(color[node]==color[nbr]){
                        return false;
                    }
                }
            }

        }
        return true;

    }
}