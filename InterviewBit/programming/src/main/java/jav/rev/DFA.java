package jav.rev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class DFA {
	private static class Node{
		int nodeNumber;
		int val;
		public Node(int num,int val) {
			this.nodeNumber = num;
			this.val = val;
		}
	}
	
	private static class Graph {
        int numOfVertices;
        LinkedList<Node>[] adjList;
 
        public Graph(int v) {
            this.numOfVertices = v;
            this.adjList = new LinkedList[v];
            for (int i = 0; i < v; i++)
                this.adjList[i] = new LinkedList<Node>();
        }
 
        public void addEdge(int i, int j,int val) {
        	Node node = new Node(j,val);
            this.adjList[i].add(node);           
        }
    }
	int cnt;
	public int automata(int[] A, int[] B, int[] C, int D, int E) {
		Graph g = new Graph(A.length);
		
		for(int i=0;i<A.length;i++) {
			g.addEdge(i, A[i], 0);
		}
		
		for(int i=0;i<B.length;i++) {
			g.addEdge(i, B[i], 1);
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<C.length;i++)
			set.add(C[i]);
		
		cnt = 0;
		traverse(g,set,D,E,new ArrayList<String>(),"",D);
		
		return cnt;
	}
	private void traverse(Graph g, HashSet<Integer> set, int index, int size, ArrayList<String> l, String str,int prev ) {
		// TODO Auto-generated method stub
		if(str.length()==size) {
			if((!l.contains(str)) && set.contains(prev) ) {
				l.add(str);
				cnt++;
			}
		}
		Iterator<Node> iterator = g.adjList[index].iterator();
		
		while(iterator.hasNext()) {
			Node next = iterator.next();
			if(str.length()<size) {
				str = str + next.val;				
				traverse(g, set, next.nodeNumber, size, l, str,next.nodeNumber);				
				str = str.substring(0, str.length()-1);
			}
		}
	}
	public static void main(String[] args) {
		DFA d = new DFA();
		int res = d.automata(new int[] {0, 2, 1}, new int[] {1,0,2}, new int[] {0}, 0, 2);
		System.out.println(res);
	}

}
