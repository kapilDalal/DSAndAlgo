package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {

	static public  class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		public UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		HashSet<UndirectedGraphNode> visited = new HashSet<>();
		HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();		
		q.add(node);
		
		while(!q.isEmpty()) {			
			UndirectedGraphNode polledNode = q.poll();
			map.put(polledNode, new UndirectedGraphNode(polledNode.label));
			visited.add(polledNode);
			List<UndirectedGraphNode> neighbors = polledNode.neighbors;			
			for(UndirectedGraphNode neighbour : neighbors) {
				if(!visited.contains(neighbour))
					q.add(neighbour);
			}
		}
		
		return null;
	    
	}
	
	

}
