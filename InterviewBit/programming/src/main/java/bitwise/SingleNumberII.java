package bitwise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SingleNumberII {
	
	public int singleNumber(final List<Integer> A) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<A.size();i++){
            int ele = A.get(i);
            if(map.containsKey(ele)){
                int val = map.get(ele);
                map.put(ele,val+1);
                continue;
            }
            map.put(ele,1);
        }
        
        Set<Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Entry<Integer, Integer>> it = entrySet.iterator();
        
        while(it.hasNext()){
            Entry<Integer,Integer> entry = it.next();
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
        
    }
	
	public int singleNumberOptimised(final List<Integer> A) {
        int num = 0;
        int count = 0;
        for(int i=0;i<32;++i) {
            count = 0;
            for(int a : A) {
                if((a & 1 << i) != 0) {
                    count++;
                }
            }
            if(count%3 != 0) {
                num+=1<<i;
            }
        }
        return num;
    }

}
