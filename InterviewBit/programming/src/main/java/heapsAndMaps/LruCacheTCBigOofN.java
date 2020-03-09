package heapsAndMaps;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class LruCacheTCBigOofN {
	
	static public class Solution {
		
		static public class Data{
			int key;
			int value;	
			public Data(int key,int value){
				this.key = key;
				this.value = value;				
			}
		}
		
		Deque<Data> q = new LinkedList<>();
		int capacity;
		
		public Solution(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			int val = -1;
			Iterator<Data> iterator = q.iterator();
			while(iterator.hasNext()){
				Data next = iterator.next();
				if(next.key ==key){
					val = next.value;
					q.remove(next);
					q.addFirst(next);
					break;
				}
			}
			return val;
		}

		public void set(int key, int value) {
            boolean keyPresent = false;
            if(q.size()<capacity){
                Iterator<Data> iterator = q.iterator();
                while(iterator.hasNext()){
                    Data next = iterator.next();
                    if(next.key == key){
                        next.value = value;  
                        q.remove(next);
                        q.addFirst(next);
                        keyPresent = true;
                        break;
                    }
                }
                if(!keyPresent){
                    q.addFirst(new Data(key,value));
                }
            }else{
                Iterator<Data> iterator = q.iterator();
                while(iterator.hasNext()){
                    Data next = iterator.next();
                    if(next.key == key){
                        next.value = value;  
                        q.remove(next);
                        q.addFirst(next);
                        keyPresent = true;
                        break;
                    }
                }
                if(!keyPresent){
                    q.removeLast();
                    q.addFirst(new Data(key,value));
                }
            }
        }
	}

}
