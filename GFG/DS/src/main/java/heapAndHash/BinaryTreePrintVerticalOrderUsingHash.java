package heapAndHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BinaryTreePrintVerticalOrderUsingHash {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	static class MultiValueMap {
		Map<Integer, List<Integer>> map = null;

		public MultiValueMap() {
			map = new HashMap<Integer, List<Integer>>();
			;
		}

		public void insert(int key, int val) {
			if (map.containsKey(key)) {
				List<Integer> list = map.get(key);
				list.add(val);
				map.put(key, list);

			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(val);
				map.put(key, list);
			}
		}

		public Set<Integer> getKeys() {
			return map.keySet();
		}

		public List<Integer> getValue(int key) {
			return map.get(key);
		}

	}

	static void storeVerticalOrderInMap(Node node, int depth, MultiValueMap map) {
		if (node == null)
			return;
		storeVerticalOrderInMap(node.left, depth - 1, map);
		if (node != null) {
			map.insert(depth, node.data);
		}
		storeVerticalOrderInMap(node.right, depth + 1, map);

	}

	static void printVerticalOrder(MultiValueMap map) {
		ArrayList<Integer> list = new ArrayList<Integer>(map.getKeys());
		Collections.sort(list);
		for (Integer key : list) {
			System.out.println(map.getValue(key));
		}
	}
	
	static void verticalOrder(Node node){
		MultiValueMap map = new MultiValueMap();
		storeVerticalOrderInMap(node, 0, map);
		printVerticalOrder(map);
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1); 
	    root.left = new Node(2); 
	    root.right = new Node(3); 
	    root.left.left = new Node(4); 
	    root.left.right = new Node(5); 
	    root.right.left = new Node(6); 
	    root.right.right = new Node(7); 
	    root.right.left.right = new Node(8); 
	    root.right.right.right = new Node(9); 
	    root.right.right.left= new Node(10); 
	    root.right.right.left.right= new Node(11); 
	    root.right.right.left.right.right= new Node(12); 
	    
	    verticalOrder(root);
		
	}

}
