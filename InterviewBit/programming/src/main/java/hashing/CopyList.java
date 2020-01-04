package hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class CopyList {
	
	
	  
	  static class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  }
	 
	  static public RandomListNode copyRandomList(RandomListNode head) {	  		  
		  HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		  RandomListNode nHead = new RandomListNode(-1);
		  RandomListNode temp = nHead;
		  while(head!=null){
			  nHead.next = new RandomListNode(head.label);
			  map.put(head, nHead.next);
			  nHead = nHead.next;
			  head = head.next;			  
		  }
		  Set<Entry<RandomListNode, RandomListNode>> entrySet = map.entrySet();
		  Iterator<Entry<RandomListNode, RandomListNode>> iterator = entrySet.iterator();
		  while(iterator.hasNext()){
			  Entry<RandomListNode, RandomListNode> next = iterator.next();
			  next.getValue().random = map.get(next.getKey().random);
		  }
		  return temp.next;
	  }
	  
	  static void print(RandomListNode node){
		  while(node!=null){
			  System.out.println(node.label+"\t"+node.random.label);
			  node = node.next;
		  }
	  }
	  
	  public static void main(String[] args) {
		RandomListNode first = new RandomListNode(1);
		RandomListNode sec = new RandomListNode(2);
		RandomListNode third = new RandomListNode(3);
		first.next = sec;
		sec.next = third;
		first.random = third;
		sec.random = first;
		third.random = first;
		
		RandomListNode copy = copyRandomList(first);
		print(first);
		System.out.println();
		print(copy);
		
	}

}
