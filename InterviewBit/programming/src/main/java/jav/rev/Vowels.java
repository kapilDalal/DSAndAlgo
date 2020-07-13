package jav.rev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Vowels {

	HashMap<Character, ArrayList<Character>> map = new HashMap<>();
	{
		map.put('a', new ArrayList<Character>(Arrays.asList('e', 'i')));
		map.put('e', new ArrayList<Character>(Arrays.asList('i')));
		map.put('i', new ArrayList<Character>(Arrays.asList('a', 'e', 'o', 'u')));
		map.put('o', new ArrayList<Character>(Arrays.asList('a', 'u')));
		map.put('u', new ArrayList<Character>(Arrays.asList('o', 'e')));
	}

	public int solve(int A) {
		Queue<String> q = new LinkedList<String>();
		q.add("a");
		q.add("e");
		q.add("i");
		q.add("o");
		q.add("u");
		while(q.peek().length()!=A) {
			String str = q.poll();
			Character c = str.charAt(str.length()-1);
			ArrayList<Character> l = map.get(c);
			Iterator<Character> itr = l.iterator();
			while(itr.hasNext()) {
				q.add(str + itr.next());
			}
		}
		return q.size()%1000000007;
	}
	public static void main(String[] args) {
		Vowels v = new Vowels();
		System.out.println(v.solve(100000));
	}

}
