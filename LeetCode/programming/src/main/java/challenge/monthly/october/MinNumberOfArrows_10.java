package challenge.monthly.october;

import java.util.ArrayList;
import java.util.Collections;

public class MinNumberOfArrows_10 {
    static class Interval implements Comparable<Interval>{
        int s;
        int e;
        public Interval(int s,int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Interval o) {
            if(this.s==o.s)
                return this.e-o.e;
            if(this.s>o.s)
                return 1;

            return -1;
        }
    }

    public int findMinArrowShots(int[][] points) {
        ArrayList<Interval> intervals = new ArrayList<>();

        for(int i=0;i< points.length;i++){
            Interval in = new Interval(points[i][0],points[i][1]);
            intervals.add(in);
        }
        Collections.sort(intervals);

        int i=0;
        while(i<intervals.size()-1){
            Interval f = intervals.get(i);
            Interval s = intervals.get(i+1);
            if(f.e>=s.s){
                f.e = Math.min(f.e,s.e);
                f.s = Math.max(f.s,s.s);
                intervals.remove(i+1);
            }else{
                i++;
            }
        }


        return intervals.size();
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
                //{{-2147483646,-2147483645},{2147483646,2147483647}};
        MinNumberOfArrows_10 ma = new MinNumberOfArrows_10();
        System.out.println(ma.findMinArrowShots(points));
    }
}
