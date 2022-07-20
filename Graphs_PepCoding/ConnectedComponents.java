package Graphs_PepCoding;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectedComponents {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }//Constructor
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[8];
        for (int i = 0; i <=7; i++)
            graph[i] = new ArrayList<>();

        graph[7].add(new Edge(7, 4, 10));
        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 10));
        graph[2].add(new Edge(2, 4, 10));
        graph[5].add(new Edge(5, 6, 10));

        graph[4].add(new Edge(4, 7, 10));
        graph[1].add(new Edge(1, 0, 10));
        graph[2].add(new Edge(2, 1, 10));
        graph[3].add(new Edge(3, 1, 10));
        graph[4].add(new Edge(4, 2, 10));
        graph[6].add(new Edge(6, 5, 10));


        boolean[] visited = new boolean[8];
        dfs(1,graph,visited);
        System.out.println(count);
}

    static int count;
    public static void dfs(int v,ArrayList<Edge>[] graph,boolean[] visited ){
        visited[v]=true;
        for(int i=0;i<8;i++){
            if (visited[i])continue;
            dfs(i,graph,visited);
            count++;
        }
    }
}
