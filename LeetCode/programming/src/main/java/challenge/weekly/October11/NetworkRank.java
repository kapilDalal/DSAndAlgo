package challenge.weekly.October11;

import java.util.ArrayList;

public class NetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for(int i=0;i<n;i++)
            l.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            int s = roads[i][0];
            int d = roads[i][1];
            l.get(s).add(d);
            l.get(d).add(s);
        }
        /*int m1 = 0;
        int i1 = 0;
        int i2 = 0;
        int m2 = -1;
        for(int i=0;i<l.size();i++){
            if(l.get(i).size()>m1){
                m2 = m1;
                m1 = l.get(i).size();
                i2 = i1;
                i1 = i;
            }else if(l.get(i).size()>m2){
                m2 = l.get(i).size();
                i2 = i;
            }
        }
        ArrayList<Integer> l1 = l.get(i1);
        ArrayList<Integer> l2 = l.get(i2);
        if(l1.contains(i2) && l2.contains(i1))
            l1.remove(0);*/
        int max = 0;
        for(int i=0;i<l.size()-1;i++){
            ArrayList<Integer> l1 = l.get(i);
            for(int j=0;j<l.size();j++){

                ArrayList<Integer> l2 = l.get(j);
                if(l1.contains(j) && l2.contains(i))
                    max = Math.max(l1.size()+l2.size()-1,max);
                else
                    max = Math.max(l1.size()+l2.size(),max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
        NetworkRank nr = new NetworkRank();
        System.out.println(nr.maximalNetworkRank(8,roads));
    }
}
