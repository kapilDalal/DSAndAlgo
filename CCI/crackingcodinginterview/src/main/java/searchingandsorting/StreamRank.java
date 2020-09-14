package searchingandsorting;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class StreamRank {
    TreeMap<Integer,Integer> map = new TreeMap<>();

    public void track(int n){
        map.put(n,map.getOrDefault(n,0)+1);
    }

    public int getRank(int n){
        int rank = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getKey()>n)
                break;
            rank += next.getValue();
        }
        return rank-1;
    }

    public static void main(String[] args) {
        StreamRank sr = new StreamRank();
        int[] stream = {5,1,4,4,5,9,7,13,3};
        for(int i=0;i< stream.length;i++){
            sr.track(stream[i]);
        }
        System.out.println(sr.getRank(1));
        System.out.println(sr.getRank(3));
        System.out.println(sr.getRank(4));
    }




}
