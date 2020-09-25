package design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class HitCounter {


    HashMap<Integer,Integer> hits;
    /** Initialize your data structure here. */

    public HitCounter() {
        hits = new HashMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(hits.containsKey(timestamp)){
            hits.put(timestamp,hits.get(timestamp)+1);
        }else{
            hits.put(timestamp,1);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int cnt = 0;
        int t = timestamp-299;
        while(t!=timestamp+1){
            if(hits.containsKey(t)){
                cnt += hits.get(t);
            }
            t++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */