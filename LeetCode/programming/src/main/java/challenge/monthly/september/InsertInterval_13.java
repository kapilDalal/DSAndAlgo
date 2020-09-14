package challenge.monthly.september;

import java.util.*;

public class InsertInterval_13 {


    static class Interval implements Comparable<Interval>{

        int start;
        int end;
        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Interval o) {
            return this.start-o.start;
        }
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<Interval> ins = new ArrayList<>();
        for(int i=0;i< intervals.length;i++){
            Interval in = new Interval(intervals[i][0],intervals[i][1]);
            ins.add(in);
        }
        ins.add(new Interval(newInterval[0],newInterval[1]));
        Collections.sort(ins);

        Deque<Interval> res = new LinkedList<>();
        res.add(ins.get(0));

        for(int i=1;i<ins.size();i++){
            Interval last = res.pollLast();
            Interval curr = ins.get(i);
            if(last.end >= curr.start && last.end>=curr.end){
                res.add(last);
                continue;
            }
            else if(last.end>=curr.start && last.end<= curr.end){
                last.end = curr.end;
                res.add(last);
            }else{
                res.add(last);
                res.add(curr);
            }
        }
        int[][] finalRes = new int[res.size()][2];
        int cnt = 0;
        while (res.size()>0){
            Interval interval = res.pollFirst();
            finalRes[cnt][0] = interval.start;
            finalRes[cnt][1] = interval.end;
            cnt++;
        }
        return finalRes;
    }

    public static void main(String[] args) {
        int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval={4,8};
        InsertInterval_13 ii = new InsertInterval_13();
        int[][] res = ii.insert(intervals,newInterval);
        System.out.print("[");
        for(int i=0;i<res.length;i++){
            System.out.print("["+res[i][0]+","+res[i][1]+"],");
        }
        System.out.println("]");
    }

}
