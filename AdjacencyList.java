// Adjacency list + Directed/Undirected graph + print graph

import java.util.*;
public class AdjacencyList{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int n=sc.nextInt();
        System.out.println("Enter number of edges:");
        int m=sc.nextInt();
        Graph g=new Graph();
        System.out.println("Enter " + m + " edges (u v):");
        for(int i=0;i<m;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            //for undirected graph-->0    for directed graph-->1
            g.addEdge(u,v,0);//assuming for undirected graph
        }
        g.printAdjacencyList();
    }
}
class Graph{
    Map<Integer,List<Integer>> adj=new HashMap<>();
    void addEdge(int u,int v,int direction ){
        adj.putIfAbsent(u,new ArrayList<>());
        adj.get(u).add(v);
        if(direction==0){
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(v).add(u);
        }
        
    }
    void printAdjacencyList(){
        for(Map.Entry<Integer,List<Integer>> entry:adj.entrySet()){
            System.out.print(entry.getKey()+"->");
            for(int nbr:entry.getValue()){
                System.out.print(nbr+" ");
            }
            System.out.println();
        }
    }
}
