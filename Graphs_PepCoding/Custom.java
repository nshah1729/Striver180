package Graphs_PepCoding;

import java.util.ArrayList;

public class Custom {
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge( int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }

    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge>[] graph=new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i]=new ArrayList<>();
        }
//        graph
    }
}
