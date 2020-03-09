package heapsAndMaps;

import java.util.HashMap;
import java.util.LinkedList;

public class LruCacheOptimised {
	
	static public class Solution {
	    	
	        
	    	HashMap<Integer,Integer> qPtr = new HashMap<>();
	    	LinkedList<Integer> q = new LinkedList<>();
	        
	        int capacity;
	        
	        public Solution(int capacity) {
	            this.capacity = capacity;
	            
	        }

	        public int get(int key) {
	            int val = -1;
	            
	            return val;
	        }

	        public void set(int key, int value) {
	            
	        }
	}

	
	

}
