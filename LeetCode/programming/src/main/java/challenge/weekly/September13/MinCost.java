package challenge.weekly.September13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinCost {


    static public class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
                return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
            }
    }

    private static int findParent(Integer[] parent,int i) {

        if(parent[i]==-1)
            return i;
        return findParent(parent, parent[i]);
    }

    private static void union(Integer[] parent,int i,int j){
        int parentI = findParent(parent,i);
        int parentJ = findParent(parent, j);

        parent[parentI] = parentJ;

    }
    static ArrayList<Edge> kruskalMst(ArrayList<Edge> edges,int v){

        Collections.sort(edges);

        ArrayList<Edge> result = new ArrayList<>();
        Integer[] parent = new Integer[v];
        for(int i=0;i<parent.length;i++)
            parent[i] = -1;

        for(int i=0;i<edges.size();i++){

            int src = edges.get(i).src;
            int dest = edges.get(i).dest;

            int srcParent = findParent(parent, src);
            int destParent = findParent(parent, dest);

            if(srcParent!=destParent){
                result.add(edges.get(i));
                union(parent,src,dest);
            }


        }
        return result;
    }

    public int minCostConnectPoints(int[][] points) {
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                int s = i;
                int d = j;
                int w = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                Edge edge = new Edge(s,d,w);
                edges.add(edge);
            }
        }
        ArrayList<Edge> res = kruskalMst(edges, points.length);
        int cost = 0;

        for(Edge e : res)
            cost += e.weight;

        return cost;
    }

    public static void main(String[] args) {
        int points[][] = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int p1[][] = {{3,12},{-2,5},{-4,1}};
        MinCost mc = new MinCost();

        System.out.println(mc.minCostConnectPoints(p1));
    }




}
