public class AdjacencyMatrix {
    public static void main(String args[]){
        int V=5;
        int[][] edges={
            {0,1}, {0,4}, {4,1}, {4,3}, {1,3}, {1,2}, {3,2}
        };
        int[][] mat=new int[V][V];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            mat[u][v]=1;
            mat[v][u]=1; //for undirected graph
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
