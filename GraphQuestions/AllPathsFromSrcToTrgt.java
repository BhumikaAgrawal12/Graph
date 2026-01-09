import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSrcToTrgt {
     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        int V=graph.length;
        current.add(0);
        dfs(graph,0,V-1,ans,current);
        return ans;
    }
    void dfs(int[][] graph,int src,int dst,List<List<Integer>>ans,List<Integer>current){
        if(src==dst){
            ans.add(new ArrayList(current));
            return;
        }
        for(int nbr:graph[src]){
            current.add(nbr);
            dfs(graph,nbr,dst,ans,current);
            current.remove(current.size()-1);
        }
    }
}
