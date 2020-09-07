package challenge.weekly.september6;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveEdges {

    private static class Edge{
        int type;
        int u;
        int v;
        private ArrayList<Edge> edges;
        public Edge(){

        }
        private Edge(int type,int u,int v){
            this.type = type;
            this.u = u;
            this.v = v;
        }
        public void addEdges(int[][] edge){
            edges = new ArrayList<>();
            for(int i=0;i< edge.length;i++)
                edges.add(new Edge(edge[i][0],edge[i][1],edge[i][2]));
        }

        public ArrayList<Edge> getEdges(int type){
            ArrayList<Edge> e = new ArrayList<>();
            switch (type){
                case 1:
                    for(Edge edge : edges){
                        if(edge.type==1)
                            e.add(edge);
                    }
                    break;
                case 2:
                    for(Edge edge : edges){
                        if(edge.type==2)
                            e.add(edge);
                    }
                    break;
                default:
                    for(Edge edge : edges){
                        if(edge.type==3)
                            e.add(edge);
                    }
            }
            return e;
        }

    }

    private int traverse(int n,Edge edges,boolean firstPass){
        int count = 0;
        ArrayList<Edge> ti;
        if(firstPass)
            ti = edges.getEdges(1);
        else
            ti = edges.getEdges(2);
        ArrayList<Edge> t3 = edges.getEdges(3);

        t3.addAll(ti);

        boolean[] v = new boolean[n+1];
        Arrays.fill(v,false);

        for(Edge e : t3){

            if(v[e.u] && v[e.v]){
                if(e.type==3 && firstPass)
                    continue;
                count++;
            }
            v[e.u] = true;
            v[e.v] = true;

        }


        v[0] = true;
        for(int i=0;i<v.length;i++){
            if(!v[i])
                return -1;
        }
        return count;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count = 0;
        Edge e = new Edge();
        e.addEdges(edges);

        int count1 = traverse(n,e,true);
        if(count1==-1)
            return -1;
        count += count1;

        int count2 = traverse(n,e,false);
        if(count2==-1)
            return  -1;
        count+=count2;

        return count;
    }

    public static void main(String[] args) {
        RemoveEdges re = new RemoveEdges();
        int n = 13;
        int[][] edges = {{1,1,2},{2,1,3},{3,2,4},{3,2,5},{1,2,6},{3,6,7},{3,7,8},{3,6,9},{3,4,10},{2,3,11},{1,5,12},{3,3,13},{2,1,10},{2,6,11},{3,5,13},{1,9,12},{1,6,8},{3,6,13},{2,1,4},{1,1,13},{2,9,10},{2,1,6},{2,10,13},{2,2,9},{3,4,12},{2,4,7},{1,1,10},{1,3,7},{1,7,11},{3,3,12},{2,4,8},{3,8,9},{1,9,13},{2,4,10},{1,6,9},{3,10,13},{1,7,10},{1,1,11},{2,4,9},{3,5,11},{3,2,6},{2,1,5},{2,5,11},{2,1,7},{2,3,8},{2,8,9},{3,4,13},{3,3,8},{3,3,11},{2,9,11},{3,1,8},{2,1,8},{3,8,13},{2,10,11},{3,1,5},{1,10,11},{1,7,12},{2,3,5},{3,1,13},{2,4,11},{2,3,9},{2,6,9},{2,1,13},{3,1,12},{2,7,8},{2,5,6},{3,1,9},{1,5,10},{3,2,13},{2,3,6},{2,2,10},{3,4,11},{1,4,13},{3,5,10},{1,4,10},{1,1,8},{3,3,4},{2,4,6},{2,7,11},{2,7,10},{2,3,12},{3,7,11},{3,9,10},{2,11,13},{1,1,12},{2,10,12},{1,7,13},{1,4,11},{2,4,5},{1,3,10},{2,12,13},{3,3,10},{1,6,12},{3,6,10},{1,3,4},{2,7,9},{1,3,11},{2,2,8},{1,2,8},{1,11,13},{1,2,13},{2,2,6},{1,4,6},{1,6,11},{3,1,2},{1,1,3},{2,11,12},{3,2,11},{1,9,10},{2,6,12},{3,1,7},{1,4,9},{1,10,12},{2,6,13},{2,2,12},{2,1,11},{2,5,9},{1,3,8},{1,7,8},{1,2,12},{1,5,11},{2,7,12},{3,1,11},{3,9,12},{3,2,9},{3,10,11}};
        System.out.println(re.maxNumEdgesToRemove(n,edges));
    }

}
