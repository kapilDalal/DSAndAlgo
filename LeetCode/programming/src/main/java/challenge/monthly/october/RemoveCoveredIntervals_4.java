package challenge.monthly.october;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveCoveredIntervals_4 {
    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int s,int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Interval o) {
            if(this.start==o.start)
                return o.end-this.end;
            return this.start-o.start;
        }
    }
    public int removeCoveredIntervals(int[][] intervals) {
        ArrayList<Interval> intervalList = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            Interval in = new Interval(intervals[i][0],intervals[i][1]);
            intervalList.add(in);
        }
        Collections.sort(intervalList);
        int i=0;
        while (i<intervalList.size()-1){
            Interval f = intervalList.get(i);
            Interval s = intervalList.get(i+1);
            if(s.end<=f.end){
                intervalList.remove(s);
            }
            else
                i++;
        }
        return intervalList.size();
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals_4 rc = new RemoveCoveredIntervals_4();
        int[][] intervals = {{1,2},{1,4},{3,4}};
        System.out.println(rc.removeCoveredIntervals(intervals));
    }


}
