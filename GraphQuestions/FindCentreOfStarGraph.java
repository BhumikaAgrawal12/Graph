import java.util.ArrayList;
import java.util.List;

public class FindCentreOfStarGraph {
    public int findCenter(int[][] edges) {
        int V=edges.length+1;
        ArrayList<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(v);
        }
        for(int i=1;i<=V;i++){
            if(adj.get(i).size()==V-1){
                return i;
            }
        }
        return -1;
    }
}
