package heapAndHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



public class EmployeeCountUnderEmployeeUsingHash {
	
	static class MultiValueMap {
		Map<Character, List<Character>> map = null;

		public MultiValueMap() {
			map = new HashMap<Character, List<Character>>();
			;
		}

		public void insert(Character key, Character val) {
			if (map.containsKey(key)) {
				List<Character> list = map.get(key);
				list.add(val);
				map.put(key, list);

			} else {
				ArrayList<Character> list = new ArrayList<Character>();
				list.add(val);
				map.put(key, list);
			}
		}

		public Set<Character> getKeys() {
			return map.keySet();
		}

		public List<Character> getValue(Character key) {
			return map.get(key);
		}

	}
	
	static void count(MultiValueMap map){
		Queue<Character> q1 = new LinkedList<Character>();
		Queue<Character> q2 = new LinkedList<Character>();
		
		
		Set<Character> keys = map.getKeys();
		Iterator<Character> iterator = keys.iterator();
		
		while(iterator.hasNext()){
			Character man = iterator.next();
			List<Character> employees = map.getValue(man);
			q1.addAll(employees);
			
			while(!q1.isEmpty()){
				Character emp = q1.poll();
				q2.add(emp);
				if(keys.contains(emp)){
					List<Character> employees1 = map.getValue(emp);
					q1.addAll(employees1);
				}
			}
			
			System.out.println(man+"\t"+q2.size());
			q2.clear();
			
		}
	}
	
	public static void main(String[] args) {
		
		MultiValueMap map = new MultiValueMap();
		
		map.insert('C', 'A');
		map.insert('C', 'B');
		map.insert('F', 'C');
		map.insert('F', 'E');
		map.insert('E', 'D');
		
		count(map);
		
	}

}
