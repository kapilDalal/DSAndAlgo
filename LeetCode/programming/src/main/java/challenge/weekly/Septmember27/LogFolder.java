package challenge.weekly.Septmember27;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LogFolder {

    public int minOperations(String[] logs) {
        int cnt = 0;

        for(int i=0;i<logs.length;i++){
            String str = logs[i];
            char ch = str.charAt(0);
            if(ch=='.'){
                char ch1 = str.charAt(1);
                if(ch1=='.'){
                    if(cnt>0)
                        cnt--;
                }
            }else{
                //handle main case
                cnt++;

            }

        }

        return cnt;
    }
    public int maximumRequests(int n, int[][] requests) {

        HashMap<Integer,Integer> in = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> out = new HashMap<Integer,Integer>();

        for(int i=0;i<requests.length;i++){
            int ic = requests[i][0];
            int og = requests[i][1];
            if(in.containsKey(ic)){
                in.put(ic,in.get(ic)+1);
            }else{
                in.put(ic,1);
            }

            if(out.containsKey(og)){
                out.put(og,out.get(og)+1);

            }else{
                out.put(og,1);
            }
        }
        int cnt = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = in.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            Integer key = next.getKey();

            if(out.containsKey(key)){
                cnt += Math.min(value,out.get(key));
            }
        }

        return cnt;

    }


    public static void main(String[] args) {

    }

}
