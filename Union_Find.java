import java.util.*;

class UnionFind{ 
    int[] parent;
    int[] rank;
    UnionFind(int V){
        parent=new int[V+1];
        rank=new int[V+1];

        for(int i=0;i<=V;i++){
            parent[i]=i;      //initially hr node k liye whi uska parent hoga
        }
    }
   //This find function is searching for the leader(root node) of the current node.
    int find(int node){
        if(parent[node]==node){
            return node;
        }
        return find(parent[node]);
    }

    int findWithPathCompression(int node){
        if(parent[node]==node){
            return node;
        }
        //path compression
        parent[node]=findWithPathCompression(parent[node]);
        return parent[node];
    }


    boolean union(int u,int v){
        int parent_u=find(u);
        int parent_v=find(v);

        if(parent_u==parent_v){
            return false;
        }

        if(rank[parent_u]>rank[parent_v]){   //rank of u>rank of v
            parent[parent_v]=parent_u;
        }
        else if(rank[parent_v]>rank[parent_u]){  //rank of v>rank of u
            parent[parent_u]=parent_v;
        }
        else{                            //(rank of u==rank of v)
            parent[parent_v]=parent_u;  //agr dono ki rank same hai toh mene u ko v ka parent bna diya
            rank[parent_u]++;          //rank of u will increase.
        }                  
        return true;

    }
}

public class Union_Find{
    public static void main(String args[]){
        UnionFind uf=new UnionFind(4);
        uf.union(1,2);
        uf.union(1,3);  
        if(uf.union(2,4))
           System.out.println("Possible");
        else{
            System.out.println("Not possible");
        }
    }
}