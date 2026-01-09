import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(v).add(u);
        }
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int nbr:adj.get(i)){
                indegree[nbr]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] ans=new int[V];
        int idx=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[idx++]=node;
            for(int nbr:adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        if(idx!=V){
            return new int[]{};
        }
        return ans;
    }
}
