import java.util.ArrayList;
import java.util.List;

public class MinNumberOfVerticesToReachNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int inDegree[]=new int[n];
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer>edge:edges){
            int u=edge.get(0);
            int v=edge.get(1);
            adj.get(u).add(v);
        }
        for(int i=0;i<n;i++){
            for(int nbr:adj.get(i)){
                inDegree[nbr]++;
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}
