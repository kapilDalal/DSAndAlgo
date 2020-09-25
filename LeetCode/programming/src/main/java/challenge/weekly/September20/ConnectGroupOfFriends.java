package challenge.weekly.September20;

import arrays.IntegerToRoman;
import challenge.weekly.September13.MinCost;

import java.util.*;

public class ConnectGroupOfFriends {

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
    static ArrayList<Edge> kruskalMst(ArrayList<Edge> edges, int v){

        Collections.sort(edges);

        ArrayList<Edge> result = new ArrayList<>();
        Integer[] parent = new Integer[v];
        for(int i=0;i<parent.length;i++)
            parent[i] = -1;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<edges.size() && set.size()<v;i++){

            int src = edges.get(i).src;
            int dest = edges.get(i).dest;

            int srcParent = findParent(parent, src);
            int destParent = findParent(parent, dest);

            if(srcParent!=destParent && !(set.contains(src) && set.contains(dest))){
                result.add(edges.get(i));



                union(parent,src,dest);
                set.add(src);
                set.add(dest);
            }


        }
        return result;
    }

    public int connectTwoGroups(List<List<Integer>> cost) {
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<cost.size();i++){
            for(int j=0;j<cost.get(0).size();j++){

                int w = cost.get(i).get(j);
                int s = i;
                int d = (cost.size())+j;
                Edge e = new Edge(s,d,w);
                edges.add(e);
            }
        }

        ArrayList<Edge> res = kruskalMst(edges, cost.size() + cost.get(0).size());
        int c = 0;

        for(Edge e : res)
            c += e.weight;
        return c;
    }

    public static void main(String[] args) {
        List<List<Integer>> costLists= new ArrayList<>();
       // [2,5,1],[3,4,7],[8,1,2],[6,2,4],[3,8,8]
        costLists.add(Arrays.asList(2,5,1));
        costLists.add(Arrays.asList(3,4,7));
        costLists.add(Arrays.asList(8,1,2));
        costLists.add(Arrays.asList(6,2,4));
        costLists.add(Arrays.asList(3,8,8));
        ConnectGroupOfFriends cg = new ConnectGroupOfFriends();
        System.out.println(cg.connectTwoGroups(costLists));
    }


}
