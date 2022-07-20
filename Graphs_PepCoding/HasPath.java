package Graphs_PepCoding;

import java.util.ArrayList;

public class HasPath {
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
        ArrayList<Edge>[] graph=new ArrayList[7];
        for (int i = 0; i < 7; i++)
            graph[i]=new ArrayList<>();

        graph[0].add(new Edge(0,1,10));
        graph[1].add(new Edge(1,2,10));
        graph[2].add(new Edge(2,3,10));
        graph[0].add(new Edge(0,3,40));
        graph[3].add(new Edge(3,4,2));
        graph[4].add(new Edge(4,5,3));
        graph[5].add(new Edge(5,6,3));
        graph[4].add(new Edge(4,6,8));

        graph[1].add(new Edge(1,0,10));
        graph[2].add(new Edge(2,1,10));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,0,10));
        graph[4].add(new Edge(4,3,2));
        graph[5].add(new Edge(5,4,3));
        graph[6].add(new Edge(6,5,3));
        graph[6].add(new Edge(6,4,8));

        int src=0;
        int dest=6;
        boolean[] visited=new boolean[7];
//        System.out.println(hasPath(graph,src,dest,visited));
//        printAllPath(graph,src,dest,visited,src+"");
        smallestPath(graph,src,dest,visited,0,"");
        System.out.println(smpAns);
        System.out.println(smpWt);
        largestPath(graph,src,dest,visited,0,"");
        System.out.println(larAns);
        System.out.println(larWt);
    }
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){
        if(src==dest)return true;

        visited[src]=true;
        for (Edge edge: graph[src]){
            if(!visited[edge.nbr]) {
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
                if (hasNbrPath) return true;
            }
        }
        return false;
    }

    private static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if(src==dest){
            System.out.println(psf);
            return;
        }
        visited[src]=true;
        for(Edge edge:graph[src]){
            if(!visited[edge.nbr]){
                printAllPath(graph,edge.nbr,dest,visited,psf+edge.nbr);
            }
        }
        visited[src]=false;
    }
    static String smpAns="";
   static int smpWt=Integer.MAX_VALUE;

    private static void smallestPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,int wt, String psf){
            if(src==dest){
                if(wt<smpWt){
                    smpAns=psf;
                    smpWt=wt;
                }
                return;
            }
            visited[src]=true;
            for(Edge e:graph[src]){
                if(!visited[e.nbr]){
                    smallestPath(graph,e.nbr,dest,visited,wt+e.wt,psf+e.nbr);
                }
            }
            visited[src]=false;
    }
    static String larAns="";
    static int larWt=Integer.MIN_VALUE;
    private static void largestPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,int wt, String psf){
            if(src==dest){
                if(wt>larWt){
                    larAns=psf;
                    larWt=wt;
                }
                return;
            }
            visited[src]=true;
            for(Edge e:graph[src]){
                if(!visited[e.nbr]){
                    smallestPath(graph,e.nbr,dest,visited,wt+e.wt,psf+e.nbr);
                }
            }
            visited[src]=false;
    }
}
