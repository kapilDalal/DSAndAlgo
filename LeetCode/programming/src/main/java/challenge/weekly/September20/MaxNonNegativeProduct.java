package challenge.weekly.September20;

import java.util.ArrayList;
import java.util.Collections;

public class MaxNonNegativeProduct {

    public int maxProductPath(int[][] grid) {

        ArrayList<Long>[][] lists = new ArrayList[grid.length][grid[0].length];

        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                lists[i][j] = new ArrayList<>();
            }
        }
        lists[0][0].add((long) grid[0][0]);

        for(int i=1;i<grid.length;i++){
            grid[i][0] *= grid[i-1][0];
            lists[i][0].add((long) grid[i][0]);
        }
        for (int j=1;j< grid[0].length;j++){
            grid[0][j] *= grid[0][j-1];
            lists[0][j].add((long) grid[0][j]);
        }

        for(int i=1;i< grid.length;i++){
            for(int j=1;j< grid[0].length;j++){
                int num = grid[i][j];
                ArrayList<Long> n = new ArrayList<>();
                n.addAll(lists[i-1][j]);
                n.addAll(lists[i][j-1]);
                for(int k=0;k<n.size();k++){
                    n.set(k,n.get(k)*num);
                }
                ArrayList<Long> n1 =new ArrayList<>();
                Collections.sort(n);
                n1.add(n.get(0));
                n1.add(n.get(n.size()-1));
                lists[i][j] = n1;
            }
        }

        ArrayList<Long> finalList = lists[grid.length - 1][grid[0].length - 1];
        Collections.sort(finalList);
        int res = (int) ((finalList.get(finalList.size()-1))%1000000007);
        return res<0?-1:res;
    }

    public static void main(String[] args) {
        MaxNonNegativeProduct mn = new MaxNonNegativeProduct();
        int[][] grid = {{1,-2,1},
                        {1,-2,1},
                        {3,-4,1}};
        System.out.println(mn.maxProductPath(grid));
    }

}
