package challenge.monthly.october;

import java.util.*;

public class MaxDistance_1 {

    public int maxDistance(List<List<Integer>> arrays) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(List<Integer> l : arrays)
        {
            q.add(l.get(l.size()-1));
        }

        int diff = Integer.MIN_VALUE;

        for(List<Integer> l : arrays)
        {
            int f = l.get(0);
            int s = l.get(l.size()-1);
            int temp = Integer.MIN_VALUE;

            if(q.peek()==s)
                temp = q.poll();

            diff = Math.max(diff,Math.abs(f-q.peek()));
            if(temp!=Integer.MIN_VALUE)
                q.add(temp);
        }
        return diff;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        arrays.add(Arrays.asList(1, 2, 3));
        arrays.add(Arrays.asList(4,5));
        arrays.add(Arrays.asList(1,2,3));
        MaxDistance_1 md = new MaxDistance_1();
        System.out.println(md.maxDistance(arrays));
    }

}
