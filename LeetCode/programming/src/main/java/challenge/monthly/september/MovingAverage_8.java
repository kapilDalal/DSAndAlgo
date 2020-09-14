package challenge.monthly.september;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage_8 {

    int size = -1;
    Queue<Integer> q;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage_8(int size) {
        this.size = size;
        this.sum = 0;

        q = new LinkedList<>();
    }

    public double next(int val) {
        if(q.size()<size){
            sum += val;
            q.add(val);
            return sum/q.size();
        }
        sum -= q.poll();
        sum += val;
        q.add(val);
        return sum/q.size();
    }


}
