package jav.rev;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class IBRevision {

	

	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		Deque<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < B; i++) {
			while (!q.isEmpty() && A.get(q.getLast()) < A.get(i)) {
				q.removeLast();
			}
			q.add(i);

		}
		res.add(A.get(q.peek()));
		for (int i = B; i < A.size(); i++) {
			if (i - q.peek() >= B)
				q.removeFirst();
			while (!q.isEmpty() && A.get(q.getLast()) < A.get(i)) {
				q.removeLast();
			}
			q.add(i);
			res.add(A.get(q.peek()));
		}

		return res;
	}

	

	int minJumps;

	public int jump(int[] A) {
		minJumps = Integer.MAX_VALUE;
		getJumps(A, 0, 0);
		return minJumps;
	}

	private void getJumps(int[] a, int index, int jumpsTillNow) {
		// TODO Auto-generated method stub
		if (index >= a.length - 1) {
			minJumps = Math.min(jumpsTillNow, minJumps);
			return;
		}
		for (int i = index; i <= a[index] && i < a.length - 1; i++) {
			getJumps(a, i + 1, jumpsTillNow + 1);
		}

	}

	public int diffPossible(final List<Integer> A, int B) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < A.size(); i++) {
			int ele = A.get(i);
			int res = B + ele;
			int res1 = Math.abs(ele - B);
			if (set.contains(res) || set.contains(res1))
				return 1;
			set.add(ele);

		}

		return 0;

	}

	public String minWindow(String A, String B) {
		String minWindow = "";
		int minWindowLength = Integer.MAX_VALUE;
		Deque<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < A.length(); i++) {
			if (B.contains("" + A.charAt(i))) {
				q.add(i);
			}
			if (q.size() == B.length()) {
				if (minWindowLength > (q.peekLast() - q.peekFirst()) && containsAll(B, q, A)) {
					minWindow = A.substring(q.peekFirst(), q.peekLast() + 1);
					minWindowLength = minWindow.length();

				}
				q.remove();
			}
		}
		return minWindow;
	}

	private boolean containsAll(String b, Deque<Integer> q, String a) {
		// TODO Auto-generated method stub
		int[] first = new int[256];
		int[] sec = new int[256];
		Arrays.fill(first, 0);
		Arrays.fill(sec, 0);
		Iterator<Integer> iterator = q.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			first[a.charAt(next)]++;
		}
		for (int i = 0; i < b.length(); i++)
			sec[b.charAt(i)]++;
		for (int i = 0; i < 256; i++) {
			if (first[i] != sec[i])
				return false;
		}
		return true;
	}

	public int coinchange2(int[] A, int B) {

		int[] dp = new int[B + 1];

		dp[0] = 1;

		for (int i = 0; i < A.length; i++) {
			for (int j = 1; j <= B; j++) {
				if (A[i] < j)
					dp[j] = dp[j - 1] + dp[j - A[i]];
				else
					dp[j] = dp[j - 1];
			}
		}
		return dp[B];
	}

	public int removeDuplicates(ArrayList<Integer> a) {
		if (a.size() <= 2)
			return a.size();

		int curr = a.get(0);
		int i = 0;

		int count = 1;
		for (int j = 1; j < a.size(); j++) {
			int val = a.get(j);
			if (val == curr) {
				count++;
				if (count >= 3)
					continue;
			} else {
				count = 1;
				curr = val;
			}

			a.set(++i, val);
		}

		return i + 1;
	}

	public int anytwo(String A) {

		return 0;
	}

	public void subsets(String s, int index, String subset) {

		if (index == s.length()) {
			System.out.println(subset);
			return;
		}
		subsets(s, index + 1, subset + s.charAt(index));
		subsets(s, index + 1, subset);
	}

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public int lca(TreeNode A, int B, int C) {

		getNodeList(A, B, new ArrayList<Integer>());
		getNodeList(A, C, new ArrayList<Integer>());

		int lca = -1;
		ArrayList<Integer> first = res.get(0);
		ArrayList<Integer> sec = res.get(1);
		int firstIndex = 0;
		for (int i = 0; i < first.size(); i++) {
			if (first.get(i) == B) {
				firstIndex = i;
				break;
			}
		}
		while (firstIndex >= 0) {
			if (sec.contains(first.get(firstIndex)))
				return first.get(firstIndex);
			firstIndex--;
		}
		return lca;
	}

	private void getNodeList(TreeNode a, int val, ArrayList<Integer> l) {
		// TODO Auto-generated method stub
		if (a == null)
			return;
		if (a.left == null && a.right == null && l.contains(val)) {
			res.add(l);
			return;
		}
		l.add(a.val);
		getNodeList(a.left, val, new ArrayList<Integer>(l));
		getNodeList(a.right, val, new ArrayList<Integer>(l));

	}

	static public class Code {
		StringBuffer codeStr;

		public Code(StringBuffer c) {
			this.codeStr = c;
		}

		public boolean equals(Object o) {
			Code code = (Code) o;
			if (code.codeStr.length() != this.codeStr.length())
				return false;
			for (int i = 0; i < codeStr.length(); i++) {
				if (this.codeStr.charAt(i) != code.codeStr.charAt(i))
					return false;
			}
			return true;
		}

		public int hashCode() {
			int hash = 3;
			hash = 7 * hash + this.codeStr.hashCode();
			return hash;
		}
	}

	HashSet<Code> set = new HashSet<>();

	public void greyCode(StringBuffer str) {
		set.add(new Code(str));
		System.out.println(str);
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '0') {
				StringBuffer s = new StringBuffer(str);
				s.replace(i, i + 1, String.valueOf('1'));
				if (!set.contains(new Code(s)))
					greyCode(s);
			} else if (str.charAt(i) == '1') {
				StringBuffer s = new StringBuffer(str);
				s.replace(i, i + 1, String.valueOf('0'));
				if (!set.contains(new Code(s)))
					greyCode(s);
			}
		}
	}

	public void permutations(int[] arr, int index) {
		if (index == arr.length) {
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i]);
			System.out.println();
			return;
		}
		for (int i = index; i < arr.length; i++) {
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			permutations(arr, index + 1);
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;

		}
	}

	public int books(int[] A, int B) {
		if (B > A.length)
			return -1;
		int lo = Integer.MIN_VALUE;
		int high = 0;
		for (int i = 0; i < A.length; i++) {
			high += A[i];
			lo = Math.max(A[i], lo);
		}
		while (lo < high) {
			int mid = lo + (high - lo) / 2;
			int readerCount = getCount(mid, A, B);
			if (readerCount <= B)
				high = mid;
			else
				lo = mid + 1;
		}
		return lo;
	}

	private int getCount(int mid, int[] a, int b) {
		// TODO Auto-generated method stub
		int count = 1;
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			total += a[i];
			if (total > mid) {
				count++;
				total = a[i];
			}
		}
		return count;
	}

	public boolean IsInterleave(String A, String B, String C, int i, int j, int k) {
		if (k >= C.length() && i >= A.length() && j >= B.length())
			return true;
		if (k >= C.length() && (!(i >= A.length()) || !(j >= B.length())))
			return false;
		if (i < A.length() && A.charAt(i) == C.charAt(k) && j < B.length() && B.charAt(j) == C.charAt(k))
			return IsInterleave(A, B, C, i + 1, j, k + 1) || IsInterleave(A, B, C, i, j + 1, k + 1);
		if (i < A.length() && A.charAt(i) == C.charAt(k))
			return IsInterleave(A, B, C, i + 1, j, k + 1);
		if (j < B.length() && B.charAt(j) == C.charAt(k))
			return IsInterleave(A, B, C, i, j + 1, k + 1);
		return false;
	}

	int rank = -1;
	int count = 0;

	public int findRank(String A) {
		char[] charArray = A.toCharArray();
		Arrays.sort(charArray);
		String B = new String(charArray);
		if (A.equals(B))
			return 1;
		boolean[] visited = new boolean[A.length() + 1];
		getRank(B, A, "", 0, visited);
		System.out.println(rank);
		return rank;
	}

	private void getRank(String a, String b, String str, int index, boolean[] visited) {
		// TODO Auto-generated method stub
		if (str.length() == a.length()) {
			count++;
			if (str.equals(b)) {
				rank = count;
				return;
			}
		}
		for (int i = 0; i < a.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				getRank(a, b, str + a.charAt(i), i, visited);
				visited[i] = false;
			}
		}
	}

	public int sqrt(int A) {
		long low = 1;
		long high = A;
		while (low <= high) {
			long mid = (low + high) / 2;
			if (mid * mid == A)
				return (int) mid;
			else if (mid * mid > A)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return (int) high;
	}

	public int solve(int A, int B, int C, int D) {

		HashSet<Long> set = new HashSet<>();
		for (long i = 1; A * i < D; i++) {
			set.add(A * i);
		}
		for (long i = 1; B * i < D; i++) {
			set.add(B * i);
		}
		for (long i = 1; C * i < D; i++) {
			set.add(C * i);
		}
		return set.size();
	}

	public int longestSubarrayDiff(ArrayList<Integer> A, int B) {
		int len = 0;
		for (int i = 0; i < A.size() - 1; i++) {
			int max = A.get(i);
			int min = A.get(i);
			int ln = 1;
			for (int j = i + 1; j < A.size(); j++) {
				max = Math.max(max, A.get(j));
				min = Math.min(min, A.get(j));
				if (max - min < B)
					ln = j - i + 1;
			}
			if (len < ln)
				len = ln;

		}

		return len;
	}

	public int minimizeAbsDiff(int[] A, int[] B, int[] C) {
		int minDiff = Integer.MAX_VALUE;
		int i, j, k;
		i = j = k = 0;
		while (i < A.length && j < B.length && k < C.length) {
			int first = A[i];
			int sec = B[j];
			int third = C[k];
			minDiff = Math.min(Math.abs(Math.max(Math.max(first, sec), third) - Math.min(Math.min(first, sec), third)),
					minDiff);
			if (first < sec && first < third)
				i++;
			else if (sec < first && sec < third)
				j++;
			else
				k++;
		}
		return minDiff;
	}

	public ArrayList<Integer> lszero(ArrayList<Integer> A) {
		List<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			sum += A.get(i);
			if (sum == 0) {
				if (i + 1 > res.size()) {
					res = A.subList(0, i + 1);
				}
			} else if (map.containsKey(sum)) {
				if ((i) - (map.get(sum)) > res.size())
					res = A.subList(map.get(sum) + 1, i + 1);
			} else {
				map.put(sum, i);
			}
		}
		return new ArrayList<Integer>(res);
	}

	class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

		@Override
		public int compare(List<T> o1, List<T> o2) {
			for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
				int c = o1.get(i).compareTo(o2.get(i));
				if (c != 0) {
					return c;
				}
			}
			return Integer.compare(o1.size(), o2.size());
		}

	}

	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		getCombinations(A, B, 1, res, new ArrayList<Integer>());
		Collections.sort(res, new ListComparator<>());
		return res;
	}

	private void getCombinations(int a, int b, int index, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
		// TODO Auto-generated method stub

		if (list.size() == b) {
			Collections.sort(list);
			if (!res.contains(list))
				res.add(list);
			return;
		}
		if (index > a)
			return;
		ArrayList<Integer> l1 = new ArrayList<Integer>(list);
		getCombinations(a, b, index + 1, res, l1);
		l1.add(index);
		getCombinations(a, b, index + 1, res, l1);
	}

	public TreeNode sortedArrayToBST(final int[] A) {
		TreeNode node = build(A, 0, A.length);
		return node;
	}

	private TreeNode build(int[] a, int left, int right) {
		if (left == right && left < a.length)
			return new TreeNode(a[left]);
		else if (left < right) {
			int mid = (left + right) / 2;
			TreeNode node = new TreeNode(a[mid]);
			node.left = build(a, left, mid - 1);
			node.right = build(a, mid + 1, right);
			return node;
		}
		return null;
	}

	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + "\t");
		inorder(root.right);
	}

	public static void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + "\t");
		preorder(root.left);
		preorder(root.right);
	}

	public int lengthOfLongestSubstring(String A) {
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		if (A.length() <= 0)
			return 0;
		int len = 1;
		for (int i = 0; i < A.length(); i++) {
			if (set.isEmpty()) {
				set.add(A.charAt(i));
				continue;
			}
			while (set.contains(A.charAt(i))) {
				set.remove(set.iterator().next());
			}
			set.add(A.charAt(i));
			len = Math.max(len, set.size());
		}
		return len;
	}

	int[] x = { -2, -2, -1, -1, 2, 2, 1, 1 };
	int[] y = { -1, 1, -2, 2, -1, 1, -2, 2 };

	public int knight(int A, int B, int C, int D, int E, int F) {
		if (C == E && D == F)
			return 0;
		int[][] dp = new int[A + 1][B + 1];
		for (int i = 0; i < dp.length; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		findPath(A, B, C, D, E, F, dp, 0);
		return dp[E][F] == Integer.MAX_VALUE ? -1 : dp[E][F];

	}

	void findPath(int A, int B, int i, int j, int E, int F, int[][] dp, int step) {
		for (int k = 0; k < x.length; k++) {
			int nextX = i + x[k];
			int nextY = j + y[k];
			if (nextX >= 1 && nextX <= A && nextY >= 1 && nextY <= B
					&& (dp[nextX][nextY] == Integer.MAX_VALUE || step + 1 < dp[nextX][nextY])) {
				dp[nextX][nextY] = Math.min(step + 1, dp[nextX][nextY]);
				findPath(A, B, nextX, nextY, E, F, dp, step + 1);
			}
		}
	}

	public int candy(ArrayList<Integer> A) {
		int res = 0;
		int[] ans = new int[A.size()];
		int def = 1;
		ans[0] = 1;
		for (int i = 1; i < A.size(); i++) {
			if (A.get(i) > A.get(i - 1))
				ans[i] = ans[i - 1] + 1;
			else if (A.get(i) < A.get(i - 1))
				ans[i] = def;
			else
				ans[i] = ans[i - 1];
		}
		for (int i = A.size() - 2; i >= 0; i--) {
			if (A.get(i) > A.get(i + 1))
				ans[i] = ans[i + 1] + 1;
			else if (A.get(i) < A.get(i + 1))
				ans[i] = def;
			else
				ans[i] = ans[i + 1];
		}
		for (int i = 0; i < ans.length; i++)
			res += ans[i];

		return res;
	}

	public TreeNode flatten(TreeNode a) {
		if (a == null)
			return null;
		TreeNode right = flatten(a.right);
		TreeNode left = flatten(a.left);
		if (a.left != null && a.right == null) {
			a.right = a.left;
			a.left = null;
		} else if (a.right != null && a.left != null) {
			a.right = a.left;
			a.left = null;
			while (left.right != null)
				left = left.right;
			left.right = right;
		}
		return a;
	}

	public ArrayList<Integer> equal(ArrayList<Integer> A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < A.size() - 3; i++) {
			for (int j = i + 1; i < A.size() - 2; j++) {
				int sum = A.get(i) + A.get(j);
				List<Integer> sub = new ArrayList<Integer>(A.subList(j + 1, A.size()));
				Collections.sort(sub);
				int start = 0;
				int end = sub.size() - 1;
				while (start < end) {
					if (sub.get(start) + sub.get(end) == sum) {
						res.add(i);
						res.add(j);
						int indexK = A.indexOf(sub.get(start));
						int indexL = A.indexOf(sub.get(end));
						if (indexK < indexL) {
							res.add(indexK);
							res.add(indexL);
						} else {
							res.add(indexL);
							res.add(indexK);
						}
						return res;
					} else if (sub.get(start) + sub.get(end) < sum) {
						start++;
					} else {
						end--;
					}
				}
				res.clear();
			}
		}
		return res;
	}

	void getStart(int[] arr, int target) {
		int s = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				s = mid;
				end = mid - 1;
			} else if (arr[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(s);
	}

	public int minCut(String A) {
		int cuts = 0;
		int i = 0;
		while (i < A.length()) {
			for (int j = A.length(); j > i; j--) {
				if (isPalindrome(A.substring(i, j))) {
					i = j;
					cuts++;
					break;
				}
			}
		}
		return cuts;
	}

	private boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		if(str.length()==0)
			return false;
		int start = 0;
		int end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int index = 0;
		int rowNum = 0;
		boolean reachedEnd = false;
		while (rowNum < A.size()  && index < A.get(0).size()) {
			int tempIndex = index;
			int tempRowNum = rowNum;
			ArrayList<Integer> l = new ArrayList<Integer>();
			while (tempIndex >= 0 && tempRowNum < A.size()) {
				l.add(A.get(tempRowNum).get(tempIndex));
				tempIndex--;
				tempRowNum++;
			}
			res.add(l);
			if (!reachedEnd)
				index++;
			if (reachedEnd)
				rowNum++;
			if (index == A.get(0).size()-1)
				reachedEnd = true;
		}
		return res;
	}

	public int seats(String A) {
		int n = A.length();
		if (n < 2) {
			return 0;
		}
		int[] arr = new int[n];
		int lastIndex = 0;
		for (int i = 0; i < n; i++) {
			if (A.charAt(i) == 'x') {
				arr[lastIndex] = i;
				lastIndex++;
			}
		}
		lastIndex--;
		int medIndex = (lastIndex + 1) / 2;
		int ans = 0, MOD = 10000003;
		for (int i = 0; i < lastIndex + 1; i++) {
			ans = (ans % MOD + (Math.abs(arr[medIndex] - arr[i]) % MOD) - Math.abs(medIndex - i) % MOD) % MOD;
		}
		return ans % MOD;
	}

	public int solve(ArrayList<Integer> A) {
        HashSet<Integer> primes = new HashSet<>();
        for(int i=0;i<A.size();i++){
        	HashSet<Integer> s = new HashSet<Integer>();
        	if(isPrime(A.get(i))) {
        		s.add(A.get(i));
        	}else {
        		s = divisors(A.get(i));
        	}            
            Iterator<Integer> iterator = s.iterator();
            while(iterator.hasNext()) {
            	Integer next = iterator.next();
            	if(isPrime(next)) {
            		primes.add(next);
            	}
            }
        }
        //System.out.println(primes);
        return primes.size();
    }
	private boolean isPrime(int a) {
		if(a<=1)
			return false;		
		double p = Math.sqrt(a);
		for (int i = 2; i <= p; i++)
			if (a % i == 0)
				return false;
		return true;
	}
	HashSet<Integer> divisors(int a){
		HashSet<Integer> s = new HashSet<Integer>();
		if(a<=3) {
			s.add(a);
			return s;
		}
        int p = (int)Math.sqrt(a);
        
        for(int i=2;i<=p;i++){
            if(a%i==0){
                int q = a/i;
                s.add(i);
                s.add(q);
            }                
        }
        return s;
    }
	ArrayList<ArrayList<String>> palindromes;
	public ArrayList<ArrayList<String>> partition(String a) {
		palindromes = new ArrayList<ArrayList<String>>();
		generatePalindromes(a, new ArrayList<String>(),0);
		return palindromes;
		
	}
	private void generatePalindromes(String a,ArrayList<String> set,int index) {
		// TODO Auto-generated method stub
		if(index==a.length()) {
			palindromes.add(set);
		}
		for(int i=index;i<=a.length();i++) {
			if(isPalindrome(a.substring(index, i))) {
				set.add(a.substring(index, i));
				generatePalindromes(a, new ArrayList<String>(set), i);
				set.remove(set.size()-1);
			}
		}
		
	}
	public ArrayList<Integer> findSubstring(String A, final List<String> B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		LinkedHashMap<Integer,String> map = new  LinkedHashMap<Integer, String>();
		for(int i=0;i<=A.length()-B.get(0).length();i++) {
			map.put(i, A.substring(i,i+B.get(0).length()));
		}
		for(int i=0;i<map.size();i++) {
			if(B.contains(map.get(i))){
				ArrayList<String> l = new ArrayList<String>(B);
				if(containsAll(i,map,l))
					res.add(i);
			}
		}
		
		return res;
	}

	private boolean containsAll(int i, LinkedHashMap<Integer, String> map, ArrayList<String> l) {
		// TODO Auto-generated method stub
		
		int size = l.get(0).length();
		
		for(int index = i; index < map.size();index = index+size) {
			if(l.contains(map.get(index)))
				l.remove(map.get(index));
			else
				break;
		}
		
		return l.size()==0?true:false;
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(A);
		while(!s.isEmpty()) {
			TreeNode node = s.pop();
			res.add(node.val);
			if(node.right!=null)
				s.push(node.right);
			if(node.left!=null)
				s.push(node.left);			
		}
		//System.out.println(res);
		return res;
	}
	
	Integer in = -1000000;
    public int maxPathSum(TreeNode A) {
        if(A==null)
            return 0;       
        int max = maxSum(A);
        return Math.max(max,in);
    }
    public int maxSum(TreeNode A) {
        if(A==null)
            return -1000000;
        int l = maxSum(A.left);
        int r = maxSum(A.right);
        in = Math.max(l+r+A.val,in);
        in = Math.max(Math.max(l, r), in);
        return Math.max(Math.max(l,r)+A.val,A.val);
    }

    public int solve(final int[] A) {
    	int max = 2;
    	for(int i=0;i<A.length-1;i++) {
    		for(int j=i+1;j<A.length;j++) {
    			int diff = A[j]-A[i];
    			int count = getAllElementsWithSameDiff(A,j,diff);
    			max = Math.max(count+2,max);
    		}
    	}
    	return max;
    }
    
	private int getAllElementsWithSameDiff(int[] a, int j, int diff) {
		// TODO Auto-generated method stub
		int num = a[j]+diff;
		int count = 0;
		int k = j+1;
		while(true) {
			for(k=j+1;k<a.length;k++) {
				if(a[k]==num) {
					num = a[k]+diff;
					count++;
					j=k;
					break;
				}					
			}
			if(k==a.length)
				break;
		}
		return count;
	}
	public int solve(int[] A, int B) {
        int count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<A.length;i++){
            if(A[i]!=1 && B%A[i]==0){
                if(set.contains(A[i]))
                    count++;
                else if(isPrimeII(A[i])){
                    count++;
                    set.add(A[i]);
                }
            }
        }
        return count;
    }
    private boolean isPrimeII(int a){
        int count = 1;
        int p = (int)Math.sqrt(a);
        for(int i=2;i<=p;i++){
            if(a%i==0)
                count++;
        }
        return count==1?true:false;
    }
    
    //split is causing tle
    public String simplifyPath(String A) {
    	
    	String[] split = A.split("/");
    	
    	Stack<String> s = new Stack<>();
    	for(String str: split) {
    		if(!str.isEmpty() || !str.isBlank())
    		switch(str) {
    			case "..":
    				s.pop();
    				break;
    			case ".":
    				break;
    			default:
    				s.push(str);
    		}
    	}    
    	String res = "";
    	while(!s.isEmpty()) {
    		res = s.pop()+"/" + res;
    	}
    	res = "/" + res;    	
    	return res.substring(0, res.length()-1);
    }
    
    int first = Integer.MIN_VALUE;
    int sec = Integer.MIN_VALUE;
    public int[] recoverTree(TreeNode A) {
        findNodes(A,Integer.MIN_VALUE,Integer.MAX_VALUE);
        int[] res = new int[2];
        res[0] = first;
        res[1] = sec;
        System.out.println(first+"\t"+sec);
        return res;
    }
    private void findNodes(TreeNode node,int min,int max){
        if(node==null)
            return;
        if(node.val>max || node.val<min){
            if(first==Integer.MIN_VALUE){
                first = node.val;
            }else if(sec==Integer.MIN_VALUE){
                sec = node.val;
            }
        }
        findNodes(node.left,min,node.val);
        findNodes(node.right,node.val,max);
        
        
    }
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	Collections.sort(A);
    	for(int i=0;i<A.size();i++) {
    		for(int j=i+1;j<A.size();j++) {
    			int sum = A.get(i)+A.get(j);
    			int k = 0;
    			int l = A.size()-1;
    			while(k<l) {
    				if(k==i || k==j) {
    					k++;
    					continue;
    				}
    				else if(l==i || l==j) {
    					l--;
    					continue;
    				}else if(sum + A.get(k)+A.get(l)==B) {
    					ArrayList<Integer> r = new ArrayList<Integer>();
    					r.add(A.get(i));
    					r.add(A.get(j));
    					r.add(A.get(k));
    					r.add(A.get(l));
    					Collections.sort(r);
    					if(!res.contains(r))
    						res.add(r);
    					break;
    				}else if(sum + A.get(k)+A.get(l)<B) {
    					k++;
    				}else {
    					l--;
    				}
    			}
    		}
    	}
    	Collections.sort(res,new ListComparator<>());
    	return res;
    }

    public ArrayList<Integer> smallestPrimeSeq(int A, int B, int C, int D){
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	ArrayList<Integer> b = new ArrayList<Integer>();
    	ArrayList<Integer> c = new ArrayList<Integer>();
    	int temp = D;
    	while(temp-->=0) {
    		a.add(A*(D-temp));
    		b.add(B*(D-temp));
    		c.add(C*(D-temp));
    	}
    	int i,j,k;
    	i=j=k=0;
    	while(res.size()<D) {
    		int f = a.get(i);
    		int s = b.get(j);
    		int t = c.get(k);
    		int smallest = Math.min(t, Math.min(f, s));
    		if(smallest==f) {
    			if(!res.contains(f)) {
    				res.add(f);
    				i++;
    			}
    		}else if(smallest==s) {
    			if(!res.contains(s)) {
    				res.add(s);
    				j++;
    			}
    		}else {
    			if(!res.contains(t)) {
    				res.add(t);
    				k++;
    			}
    		}
    	}
    	return res;
    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	getSubsets(A,0,new ArrayList<Integer>(),res);
    	return res;
    }
    
	private void getSubsets(ArrayList<Integer> a, int index, ArrayList<Integer> l,
			ArrayList<ArrayList<Integer>> res) {
		
		
		res.add(l);

		for (int i = index; i < a.size(); i++) {
			l.add(a.get(i));
			getSubsets(a, i + 1, new ArrayList<Integer>(l), res);
			l.remove(l.size() - 1);
		} 
		
		
		
	}
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<B;i++) {
			if(map.containsKey(A.get(i))) {
				map.put(A.get(i), map.get(A.get(i))+1);
			}
			else
				map.put(A.get(i),1);
		}
		res.add(map.size());
		int k=0;
		for(int i=B;i<A.size();i++) {
			if(map.containsKey(A.get(i))) {
				map.put(A.get(i), map.get(A.get(i))+1);
			}
			else
				map.put(A.get(i),1);
			
			int ele = A.get(k);
			if(map.get(ele)==1)
				map.remove(ele);
			else
				map.put(ele,map.get(ele)-1);
			res.add(map.size());
			k++;
		}
		
		return res;
	}
	//wrong
	public int longestValidParentheses(String A) {
		int len = 0;
		Stack<Character> s = new Stack<>();
		Stack<Integer> si = new Stack<>();
		for(int i=0;i<A.length();i++) {
			Character ch = A.charAt(i);
			if(ch=='(') {
				s.push(ch);
				si.push(-1);
			}else {
				if(s.isEmpty()) {
					s.push(ch);
					si.push(-1);
					continue;
				}
				if(s.peek()=='(') {
					if(!s.isEmpty())
						s.pop();
					
					if(!si.isEmpty() && si.peek()!=-1) {
						int top = si.pop();
						si.pop();
						while(!si.isEmpty() && si.peek()>0) {
							top += si.pop();
						}
						si.push(top+2);
					}else {
						si.pop();
						si.push(2);
					}
				}else {
					s.push(ch);
					si.push(-1);
				}
			}
		}
		while(!si.isEmpty())
			len = Math.max(len, si.pop());
		
		
		return len;
	}
	
	public int maxProduct(final int[] A) {
		int min = A[0];
        int max = A[0];   
        int res = A[0];
        for(int i=1;i<A.length;i++) {
            if(A[i]<0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(A[i],A[i]*max);
            min = Math.min(A[i],A[i]*min);
            res = Math.max(max,res);
                
        }
        return res;
	}
	public String convert(String A, int B) {
		if(B<=1)
			return A;
		String res = "";
		ArrayList<ArrayList<Character>> lists = new ArrayList<>();
		for(int i=0;i<B;i++) {
			lists.add(new ArrayList<>());
		}
		boolean inc = true;
		int cnt = 0;
		for(int i=0;i<A.length();i++) {			
			lists.get(cnt).add(A.charAt(i));			
			if(inc)
				cnt++;
			else  
				cnt--;
			if(cnt==B-1) {
				inc =false;				
			}else if(cnt==0) {
				inc = true;						
			}
		}
		
		for(int i=0;i<lists.size();i++) {
			ArrayList<Character> l = lists.get(i);
			for(int j=0;j<l.size();j++) {
				res = res + ""+l.get(j);
			}
		}
			
		return res;
	}
	public int lengthOfLastWord(final String A) {
		int len = 0;
		int index = A.length()-1;
		while(index>=0 && A.charAt(index)==' ')
			index--;
		while(index>=0 && A.charAt(index)!=' ') {
			index--;
			len++;
		}
		return len;
	}
	public ArrayList<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(A==null)
			return res;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode node = A;
		s.push(node);
		while(!s.isEmpty()) {
			while(node.left!=null) {
				node = node.left;
				s.push(node);
			}
			node = s.pop();
			res.add(node.val);
			if(node.right!=null) {
				node = node.right;
				s.push(node);
			}
		}
		
		return res;
	}
	public int[] maxset(int[] A) {
		
		int[] res = {};
		long maxSum = 0;
		long currSum = 0;
		int end = -1;
		int start = 0;
		int finalStart = -2;
		int finalEnd = -1;
		int index=0;
		while(index<A.length && A[index]<0)
			index++;
		start = index;
		while(index<A.length) {
			if(A[index]<0) {
				currSum = 0;
				start = index+1;				
			}
			else {
				currSum += A[index];
				if(maxSum<=currSum) {
					
					end = index;
					if(finalStart==-2 || end-start > finalEnd-finalStart || maxSum<currSum){
    					finalEnd = end;
    					finalStart = start;
					}
					maxSum = currSum;
				}
			}
			index++;
		}
		if(finalStart>=0 && finalEnd>=0){
    		res = new int[finalEnd-finalStart+1];
    		for(int i=finalStart;i<=finalEnd;i++) {
    			res[i-finalStart] = A[i];
    		}
		}
		return res;
	}
	
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode reverseStartList(ListNode A, int B) {
		ListNode head=A;		
		ListNode secHead = A;
		while(B>0) {
			secHead = secHead.next;
			B--;
		}		
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = head.next;
		
		while(curr!=secHead) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		head.next = secHead;		
		return prev;
	}
	ListNode rev(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = head.next;
		
		while(curr!=null) {
			curr.next = prev;
			prev = curr;
			curr = next;	
			if(next!=null)
				next = next.next;
		}			
		return prev;
	}
	public ListNode reverseList(ListNode A, int B) {
		int len = 0;
		ListNode temp = A;
		while(temp!=null) {
			temp=temp.next;
			len++;
		}
		ListNode[] list  = new ListNode[len/B];
		for(int i=0;i<list.length;i++) {
			list[i] = new ListNode(-1);
		}
		temp = A;
		int k=0;
		ListNode prev = null;
		for(int i=0;i<len;i++) {
			if(i%B==0) {
				list[k] = temp;
				if(prev!=null)
					prev.next = null;
				k++;
			}
			prev = temp;
			temp = temp.next;
		
		}
		ListNode finalHead = rev(list[0]);
		ListNode tail = finalHead;
		for(int i=1;i<list.length;i++) {
			while(tail.next!=null)
				tail = tail.next;
			tail.next = rev(list[i]);
			tail = tail.next;
		}
		
		return finalHead;
	}
	
	public int compareVersion(String A, String B) {
		int res = 0;
		String[] a = A.split("\\.");
		String[] b = B.split("\\.");		
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(getVersion(a[i],b[j])==1)
				return 1;
			else if(getVersion(a[i],b[j])==-1)
				return -1;
			i++;
			j++;
		}
		if(i!=a.length) {
			for(;i<a.length;i++) {
				String str = a[i];
				for(int k=0;k<str.length();k++) {
					if(str.charAt(k)!='0')
						return 1;
				}
			}			
		}
		if(j!=b.length) {
			for(;j<b.length;j++) {
				String str = b[i];
				for(int k=0;k<str.length();k++) {
					if(str.charAt(k)!='0')
						return -1;
				}
			}
		}
			
		
		return res;
	}
	
	private int getVersion(String a, String b) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		while(i<a.length() && a.charAt(i)=='0')
			i++;
		while(j<b.length() && b.charAt(j)=='0')
			j++;
		while(i<a.length() && j<b.length()) {
			if(a.charAt(i)-'a'>b.charAt(j)-'a')
				return 1;
			else if(a.charAt(i)-'a'<b.charAt(j)-'a')
				return -1;
			i++;
			j++;
		}
		if(i!=a.length())
			return 1;
		if(j!=b.length())
			return -1;
		return 0;
	}
	public int gcd(int A, int B) {
		if(A%B==0)
			return B;
		return gcd(B, A%B);
			
	}
	public String countAndSay(int A) {
		String res = "1";
		if(A==1)
			return res;
		
		int cnt = 1;
		while(cnt<A) {
			String temp = "";
			int i=0;			
			while(i<res.length()) {
				char num = res.charAt(i);
				int c=0;
				while(i<res.length() && res.charAt(i)==num) {
					c++;
					i++;
				}
				temp = temp+String.valueOf(c)+String.valueOf(num);				
			}
			res = temp;
			cnt++;
		}
		return res;
	}
	public ListNode swapPairs(ListNode A) {
		if(A==null || A.next==null)
			return A;
		ListNode temp =A;
		ListNode r = A.next;
		ListNode prev = null;
		while(temp!=null && temp.next!=null) {
			ListNode next = temp.next;
			temp.next = next.next;
			next.next = temp;
			
			if(prev!=null)
				prev.next = next;
			prev = temp;
			temp = temp.next;
		}
		
		return r;
	}
	
	static public class NumComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			String str1 = String.valueOf(o1);
			String str2 = String.valueOf(o2);	
			String ss1 = str1+str2;
			String ss2 = str2+str1;
			return ss2.compareTo(ss1);
		}
		
	}
	
	public String largestNumber(final List<Integer> A) {
		String res = "";
		ArrayList<Integer> l = new ArrayList<>(A);
		Collections.sort(l, new NumComparator());
		
		for(int i=0;i<l.size();i++) {
			res = res + l.get(i);
		}
		
		return res;
	}
	
	public ListNode reorderList(ListNode A) {
		int len = 0;
		ListNode node = A;
		while(node!=null) {
			len++;
			node = node.next;
		}
		if(len<=2)
			return A;
		node = A;
		int cnt = 0;
		while(cnt<len/2) {
			cnt++;
			node = node.next;
		}
		ListNode secHead = node.next;
		node.next = null;
		node = A;
		secHead = rev(secHead);
		while(node!=null && secHead!=null) {
			ListNode firstNext = node.next;
			ListNode secNext = secHead.next;
			node.next = secHead;
			node.next.next = firstNext;
			secHead = secNext;
			node = firstNext;
		}
		
		return A;
	}
	
	public int atoi(final String A) {
		long res = 0;
		if(A.length()==0)
			return 0;
		ArrayList<Character> l = new ArrayList<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
		HashSet<Character> set = new HashSet<Character>();
		set.addAll(l);
		int i=0;
		char c = A.charAt(0);
		boolean neg = false;
		if(c=='-') {
			neg = true;
			i++;
		}
		for(;i<A.length();i++) {
			char ch = A.charAt(i);
			if(!set.contains(ch))
				break;
			int num = ch-'0';			
			res = res*10 + num;
			if(neg && -1*res<=Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			if(res>=Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			
		}
		int ans = (int) res;
		return neg?-1*ans:ans;
	}
	static class Graph {
        int numOfVertices;
        LinkedList<Integer>[] adjList;
 
        public Graph(int v) {
            this.numOfVertices = v;
            this.adjList = new LinkedList[v];
            for (int i = 0; i < v; i++)
                this.adjList[i] = new LinkedList<Integer>();
        }
 
        public void addEdge(int i, int j) {
            this.adjList[i].add(j);           
        }
    }
	int max = -1;
	int secMax = -1;
	public int largestDistBwNodes(int[] a) {
		Graph g = new Graph(a.length);
		
		for(int i=0;i<a.length;i++) {
			if(a[i]!=-1)
				g.adjList[a[i]].add(i);		
		}
		int globalMax = -1;
		for(int i=0;i<a.length;i++) {
			boolean[] v = new boolean[a.length];
			Arrays.fill(v, false);
			max = -1;
			secMax = -1;
			dfs(g,i,v,0);
			if(max!=-1 && secMax!=-1) {
				globalMax = Math.max(globalMax, max+secMax);
			}else {
				globalMax = Math.max(globalMax, Math.max(max, secMax));
			}
		}
		
		return globalMax;
    }
	
	

	private void dfs(Graph g, int i, boolean[] v,int d) {
		// TODO Auto-generated method stub
		v[i] = true;
		
		
		
		Iterator<Integer> iterator = g.adjList[i].iterator();
		
		while(iterator.hasNext()) {
			int next = iterator.next();
			if(!v[next]) {
				dfs(g, next, v, d+1);
			}
		}
		if(d>max) {
			secMax = max;
			max=d;
		}else if(d>secMax) {
			secMax = d;
		}
		
	}
	ArrayList<ArrayList<String>> wordLists;
	public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
		ArrayList<String> lines = new ArrayList<String>();
		wordLists = new ArrayList<>();
		generateSeq(A, B, new ArrayList<String>());
	    for(int i=0;i<wordLists.size();i++) {
	    	ArrayList<String> l = wordLists.get(i);
	    	String res = "";
	    	for(int j=0;j<l.size();j++) {
	    		res = res + l.get(j)+"\t";
	    	}
	    	res = res.trim();
	    	lines.add(res);
	    }
	    return lines;    
	}
    
    void generateSeq(String a,ArrayList<String> b,ArrayList<String> l){
        if(a.length()==0)
        {
        	ArrayList<String> s = new ArrayList<String>(l);
            wordLists.add(s);
            return;
        }    
        for(int i=0;i<=a.length();i++){
            
            if(b.contains(a.substring(0,i))){
            	l.add(a.substring(0, i));
                generateSeq(a.substring(i, a.length()), b, l);
                l.remove(l.size()-1);
            }
            
        }
        
    }
    ArrayList<String> combinations;
    public ArrayList<String> letterCombinations(String A) {
    	combinations = new ArrayList<String>();
    	HashMap<Character,String> map = new HashMap<Character, String>();
    	map.put('0', "0");
    	map.put('1', "1");
    	map.put('2', "abc");
    	map.put('3', "def");
    	map.put('4', "ghi");
    	map.put('5', "jkl");
    	map.put('6', "mno");
    	map.put('7', "pqrs");
    	map.put('8', "tuv");
    	map.put('9', "wxyz");
    	
    	generateCombinations(A,0,map,"");
    	return combinations;
    }

	private void generateCombinations(String a, int index, HashMap<Character, String> map, String str) {
		// TODO Auto-generated method stub
		if(str.length()==a.length()) {
			combinations.add(str);
		}
		
		for(int i=index;i<a.length();i++) {
			Character ch = a.charAt(index);
			String s = map.get(ch);
			for(int j=0;j<s.length();j++) {
				generateCombinations(a, i+1, map, str+s.charAt(j));
			}
		}
		
	}
	
	//wrong
	public int adjacent(int[][] A) {
		int sum  = Integer.MIN_VALUE;
		if(A[0].length<=2) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					max = Math.max(max, A[i][j]);
				}
			}
			return max;
		}
		int[][] dp = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < 2; j++) {
				dp[i][j] = A[i][j];
			}
		}
		dp[0][1] = Math.max(dp[0][0], dp[0][1]);
		dp[1][1] = Math.max(dp[1][0], dp[1][1]);
		for(int j=2;j<A[0].length;j++) {
			for(int i=0;i<2;i++) {
				
				dp[i][j] =  A[i][j] + Math.max(dp[0][j-2], dp[1][j-2]);				
				sum = Math.max(sum, dp[i][j]);
			}
		}
		
		return sum;
	}
	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        int end = A.size()-1;
        int start = 0;
        while(end>0 && A.get(end-1)<=A.get(end))
            end--;
        if(end==0){
            res.add(-1);
            return res;
        }
        while(start<A.size() && A.get(start)<=A.get(start+1))
            start++;
        res.add(start);
        res.add(end);
        return res;
    }
	
	
	static class Trie{
		boolean eow;
		Trie[] children;
		int[] cnt;
		public Trie() {
			children = new Trie[26];
			cnt = new int[26];
			for(int i=0;i<26;i++) {
				children[i] = null;
			}
		}		
	}
	public void insertWord(Trie head,String word) {
		Trie temp = head;
		for(int i=0;i<word.length();i++) {
			if(temp.children[word.charAt(i)-'a']==null) {
				temp.children[word.charAt(i)-'a'] = new Trie();
			}
			temp.cnt[word.charAt(i)-'a']++;
			temp = temp.children[word.charAt(i)-'a'];		
		}
		temp.eow = true;
	}
	public ArrayList<String> prefix(ArrayList<String> A) {
		Trie head = new Trie();
		for(int i=0;i<A.size();i++) {
			insertWord(head, A.get(i));
		}
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0;i<A.size();i++) {
			String s = getPrefix(head,A.get(i));
			res.add(s);
		}		
		return res;
	}

	private String getPrefix(Trie head, String s) {
		// TODO Auto-generated method stub
		String res = "";
		Trie temp = head;
		for(int i=0;i<s.length();i++) {
			if(temp.cnt[s.charAt(i)-'a']<2) {
				res = res+s.charAt(i);
				break;				
			}
			res = res+s.charAt(i);	
			temp = temp.children[s.charAt(i)-'a'];
		}
		return res;
	}

	public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int i=0;
		int j=0;
		while(i<A.size() && j<B.size()) {
			if(A.get(i)==B.get(j)) {
				res.add(A.get(i));
				i++;
				j++;
			}
			else {
				if(A.get(i)<B.get(j)) {
					i++;
				}else {
					j++;
				}
			}
		}
		
		return res;
	}
	
	//wrong
	public void solveSudoku(ArrayList<ArrayList<Character>> a) {		
		
	}
	
	
	
	ArrayList<Integer> low = new ArrayList<Integer>(Arrays.asList(0,0,0,3,3,3,6,6,6));
	ArrayList<Integer> up = new ArrayList<Integer>(Arrays.asList(2,2,2,5,5,5,8,8,8));
	private boolean isValid(ArrayList<ArrayList<Character>> a, int row, int col, int k) {
		// TODO Auto-generated method stub
		char ch = (char)(k+48);
		
		for(int j=0;j<a.get(0).size();j++) {
			if(a.get(row).get(j)==ch)
				return false;
		}
		for(int i=0;i<a.size();i++) {
			if(a.get(i).get(col)==ch)
				return false;
		}
		int lowR = low.get(row);
		int upR = up.get(row);
		int lowC = low.get(col);
		int upC = up.get(col);
		for(int i=lowR;i<=upR;i++) {
			for(int j=lowC;j<=upC;j++) {
				if(a.get(i).get(j)==ch)
					return false;
			}
		}
 		return true;
	}
	public int cpFact(int A, int B) {
        //int x = 1;
        
        /*while (gcd(A, B) != 1) { 
            A = A / gcd(A, B); 
        } 
        return A; */
        
        int p = (int)Math.sqrt(A);
        while(p>=1){
            if(A%p==0 && gcdI(p,B)==1)
                break;
            p--;
        }
        return p;
    }
    private int gcdI(int a, int b) {
        if(a%b==0)
            return b;
        return gcdI(b,a%b);
    }
    public void perm(int[] a,int index) {
    	
    	if(index==a.length)
    	{
    		for(int i=0;i<a.length;i++)
    			System.out.print(a[i]+"\t");
    		System.out.println();
    		 		
    	}
    	
    	for(int i=index;i<a.length;i++) {
    		
    		int temp = a[i];
    		a[i] = a[index];    		
    		a[index] = temp;
    		perm(a, index+1);
    		temp = a[i];
    		a[i] = a[index];    		
    		a[index] = temp;
    	}
    }

    static class Height implements Comparable<Height>{

    	int height;
    	int position;
    	public Height(int height,int position) {
    		this.height = height;
    		this.position = position;
    	}
		@Override
		public int compareTo(Height o) {
			// TODO Auto-generated method stub
			return o.height-this.height;
		}
    	
    }
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	ArrayList<Height> heights = new ArrayList<IBRevision.Height>();
    	for(int i=0;i<A.size();i++) {
    		Height h = new Height(A.get(i), B.get(i));
    		heights.add(h);
    	}
    	Collections.sort(heights);
    	
    	for(int i=0;i<heights.size();i++) {
    		Height h = heights.get(i);
    		res = new ArrayList<>(add(res, h.height, h.position));    		
    	}    	
    	return res;
    }
    List<Integer> add(ArrayList<Integer> l,int ele,int index){
    	if(l.size()>index) {
    		List<Integer> subList = l.subList(0, index);
    		subList.add(ele);
    		subList.addAll(l.subList(index+1, l.size()));
    		return subList;
    	}
    	l.add(ele);
    	return l;
    }
    
    
    //wrong
    public int maxSpecialProduct(ArrayList<Integer> A) {
    	int res = Integer.MIN_VALUE;
    	Stack<Integer> s = new Stack<>();
    	s.push(0);
    	for(int i=1;i<A.size();i++) {
    		if(A.get(s.peek())>A.get(i))
    			s.push(s.peek());
    		else
    			s.push(i);
    	}
    	int[] lmax = new int[A.size()];
    	for(int i=s.size()-1;i>=0;i--) {
    		int ele = s.pop();
    		if(ele==i)
    			lmax[i] = -1;
    		else
    			lmax[i] = ele;
    	}
    	s.clear();
    	s.push(A.size()-1);
    	for(int i=A.size()-2;i>=0;i--) {
    		if(A.get(i)>A.get(s.peek()))
    			s.push(i);
    		else
    			s.push(s.peek());
    	}
    	int[] rmax = new int[A.size()];
    	for(int i=0;i<A.size();i++) {
    		int ele = s.pop();
    		if(ele==i)
    			rmax[i] = -1;
    		else
    			rmax[i] = ele;
    	}
    	int m = 1000000007;
    	for(int i=0;i<lmax.length;i++) {
    		if(lmax[i]!=-1 && rmax[i]!=-1)
    			res = Math.max(res, (lmax[i]%m*rmax[i]%m)%m);
    	}
    	
    	return res;
    }
    
    public int maxProfit(final int[] A) {
    	int max = 0;
    	int[] dp = new int[A.length];
    	Arrays.fill(dp, 0);
    	for(int i=1;i<A.length;i++) {
    		for(int j=0;j<i;j++) {
    			if(A[i]>A[j]) {    				
    				dp[i] = Math.max(dp[i], A[i]-A[j]+dp[j]);    				    				
    			}else {
    				dp[i] = dp[j];
    			}
    			max = Math.max(dp[i], max);;
    		}
    	}
    	
    	return max;
    }
    
    public int hammingDistance(final List<Integer> A) {
    	if(A.size()<=1)
    		return 0;
    	int res = 0;
    	for(int i=0;i<32;i++) {
    		int cntZeros = 0;
	    	for(int j=0;j<A.size();j++) {
	    		int a = A.get(j);
	    		if(((a>>i)&1)==0)
	    			cntZeros++;	    		
	    	}
	    	int cntOne = A.size()-cntZeros;
	    	res = res + (cntZeros)*(cntOne)*2;
	    	res %= 1000000007;
    	}
    	return res;
    }
    public ListNode reverseBetween(ListNode A, int B, int C) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = A;    	
    	ListNode temp = dummy;
    	int cnt = 1;
    	
    	while(cnt<B) {
    		temp=temp.next;
    		cnt++;
    	}
    	
    	ListNode prevHead = temp;
    	ListNode tail = temp.next; 
    	ListNode curr = temp.next;
    	ListNode prev = null;
    	ListNode next = curr.next;  
    	C = C-B;
    	while(C>=0) {
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    		if(next!=null)
    			next = next.next;
    		C--;
    	}
    	prevHead.next = prev;
    	tail.next = curr;
    	
    	return dummy.next;
    }
    
    int nums;
    public int solve(int[] A, int B, int C) {
    	nums = 0;   
    	if(B==1) {
    		for(int i=0;i<A.length;i++) {
    			if(A[i]<C)
    				nums++;
    		}
    		return nums;
    	}
    	generateNums(A,B,C,"");   
    	return nums;
    }
	private void generateNums(int[] a, int b, int c, String str) {
		// TODO Auto-generated method stub
		if(str.length()>b)
			return;
		if(str.length()==b) {
			if(str.length()<c) {
				nums++;
			}
		}
		for(int i=0;i<a.length;i++) {			
				str = str + a[i];
				if(Integer.valueOf(str)>0 && Integer.valueOf(str)<c) {
					generateNums(a, b, c, str);
				}
				str = str.substring(0, str.length()-1);				
		}
	}
	ArrayList<String> pars;
	public ArrayList<String> generateParenthesis(int A) {
		pars = new ArrayList<String>();
		Character[] ch = {'(',')'};
		gp(ch,"",2*A);
		return pars;
	}
	private void gp(Character[] ch, String s, int n) {
		// TODO Auto-generated method stub
		if(s.length()==n) {
			if(isValid(s)) {
				pars.add(s);
			}
		}
		for(int i=0;i<ch.length;i++) {
			if(s.length()<=n) {
				s = s + ch[i];
				gp(ch, s, n);
				s = s.substring(0, s.length()-1);
			}
		}
		
	}

	private boolean isValid(String s) {
		// TODO Auto-generated method stub
		if(s.charAt(0)==')')
			return false;
		Stack<Character> st= new Stack<Character>(); 
		for(int i=0;i<s.length();i++) {
			Character ch = s.charAt(i);
			if(ch=='(')
				st.push(ch);
			else {
				if(st.isEmpty())
					return false;
				st.pop();
			}
		}
		if(!st.isEmpty())
			return false;
		
		return true;
	}
	
	//wrong
	public int maxcoin(int[] A) {
		int i=0;
		int j = A.length-1;
		int amt = 0;
		int f = 0;
		int s = 0;
		for(int k=0;k<A.length;k++) {
			if(k%2==0) {
				f += A[k];
			}else {
				s += A[k];
			}
		}
		return Math.max(f, s);
		/*
		 * boolean turn = true; while(i<j) { if(turn) { if(A[i]>A[j]) { amt += A[i];
		 * i++; }else { amt += A[j]; j--; } turn = false; }else { if(A[i]>A[j]) { i++;
		 * }else { j--; } turn = true; } } return amt;
		 */
    }
	static class Booking implements Comparable<Booking>{
		
		int day;
		boolean staying;
		
		public Booking(int day,boolean staying) {
			this.day = day;
			this.staying = staying;			
		}

		@Override
		public int compareTo(Booking o) {
			// TODO Auto-generated method stub
			return this.day-o.day;
		}
		
	}
	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
				
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		int maxOccupiedRooms = 0;
		for(int i=0;i<depart.size();i++) {			
			Booking d = new Booking(depart.get(i), false);
			bookings.add(d);
		}
		for(int i=0;i<arrive.size();i++) {
			Booking a = new Booking(arrive.get(i), true);
			bookings.add(a);			
		}
		Collections.sort(bookings);
		int currOccupiedRooms = 0;
		for(int i=0;i<bookings.size();i++) {
			Booking b = bookings.get(i);
			if(b.staying) {
				currOccupiedRooms += 1;
			}else {
				currOccupiedRooms -= 1;
			}
			maxOccupiedRooms = Math.max(currOccupiedRooms, maxOccupiedRooms);
		}
		
		return maxOccupiedRooms<=K?true:false;
    }
	int ways;
	ArrayList<ArrayList<Integer>> waysList;
	public int waysToVisitCities(int A, ArrayList<Integer> B) {
		ways = 0;
		waysList = new ArrayList<ArrayList<Integer>>();
		boolean[] v = new boolean[A];
		for(int i=0;i<B.size();i++) {
			int temp = B.get(i);
			B.set(i, temp-1);
		}
		for(int i=0;i<B.size();i++) {
			v[B.get(i)] = true;
		}
		
		findWays(A,B,v);
		return ways;
    }

	private void findWays(int a, ArrayList<Integer> b, boolean[] v) {
		// TODO Auto-generated method stub
		if(b.size()==a-1) {
			if(!res.contains(b)) {
				ArrayList<Integer> k = new ArrayList<Integer>(b);
				res.add(k);
				ways++;
			}
		}
		for(int i=0;i<b.size();i++) {
			int city = b.get(i);
			if(city>0 && !v[city-1]) {
				v[city-1] = true;
				b.add(city-1);
				findWays(a, b, v);
				v[city-1] = false;
				b.remove(b.size()-1);
				
			}
			
			if(city<a-1 && !v[city+1]) {
				v[city+1] = true;
				b.add(city+1);
				findWays(a, b, v);
				v[city+1] = false;
				b.remove(b.size()-1);
			}
		}
	}
	
	public ArrayList<Integer> getMaxScore(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int minA = Integer.MAX_VALUE;
		int maxA = Integer.MIN_VALUE;
		for(int i=0;i<A.size();i++) {
			minA = Math.min(A.get(i), minA);
			maxA = Math.max(A.get(i), maxA);
		}
		minA--;
		for(int i=0;i<B.size();i++) {
			maxA = Math.max(maxA, B.get(i));
		}
		maxA++;
		int aTeamScore = 0;
		int bTeamScore = 0;
		int aTeamFinalScore = 0;
		int bTeamFinalScore = 0;
		int maxGap = 0;
		while(minA<=maxA) {
			aTeamScore = getScore(A,minA);
			bTeamScore = getScore(B,minA);
			if(aTeamFinalScore<=aTeamScore) {
				aTeamFinalScore = aTeamScore;
				bTeamFinalScore = bTeamScore;				
			}
			minA++;
		}
		res.add(aTeamFinalScore);
		res.add(bTeamFinalScore);
		return res;
    }
	

	private int getScore(ArrayList<Integer> a, int minA) {
		// TODO Auto-generated method stub
		int score = 0;
		for(int i=0;i<a.size();i++) {
			int t = a.get(i);
			if(t<=minA)
				score+=2;
			else
				score+=3;
		}
		return score;
	}
	
	public ArrayList<Integer> primesum(int A) {		
		int p1 = A;
		int p2 = -1;
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(p2==-1) {
			
			if(isPrime(p2)) {
				if(p2*2==A) {
					p1=p2;
					break;
				}
				else if(isPrime(A-p1)) {
					p2 = A-p1;
					break;
				}
			}
			p1--;
		}
		res.add(p2);
		res.add(p1);
		return res;
    }
	public int nchoc(int A, ArrayList<Integer> B) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<B.size();i++)
			q.add(B.get(i));
		int res = 0;
		while(A>=0) {
			int c = q.poll();
			res += c;
			q.add((int)Math.floor(c/2));
			A--;
		}
		return res;
	}
	public int[][] solveManhattanDist(int A, int[][] B) {
		int[][] dp = new int[B.length][B[0].length];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {	
				
				for(int k=0;k<B.length;k++) {
					for(int l=0;l<B[0].length;l++) {
						if(Math.abs(k-i)+Math.abs(l-j)<=A) {
							dp[i][j] = Math.max(dp[i][j], B[k][l]);
						}
					}
				}
				
			}
		}
		
		return dp;
    }
	
	//wrong
	public int solveSuperString(String[] A) {				
		String res = A[0];
		
		for(int i=1;i<A.length;i++) {
			String r1 = mergeString(res,A[i]);
			String r2 = mergeString(A[i], res);
			if(r1.length()<r2.length())
				res = r1;
			else
				res = r2;
		}
		System.out.println(res);
		return res.length();
    }
	

	private String mergeString(String res, String s) {
		
		// TODO Auto-generated method stub
		
		int[][] dp = new int[s.length()+1][res.length()+1];
		
		for(int i=0;i<=s.length();i++)
			dp[i][0]=0;
		for(int j=0;j<=res.length();j++)
			dp[0][j]=0;
		
		int maxMatch = 0;
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=res.length();j++) {
				if(s.charAt(i-1)==res.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					maxMatch = Math.max(dp[i][j], maxMatch);
				}
			}
		}
		if(maxMatch==s.length())
			return res;
		
		if(dp[s.length()][res.length()]>0) {
			res = res + s.substring(dp[s.length()][res.length()], s.length());
		}
		
		return res+s;
	}
	public int firstMissingPositive(ArrayList<Integer> A) {
		HashSet<Integer> set = new HashSet<Integer>();
		int minPos = Integer.MAX_VALUE;
		int maxPos = Integer.MIN_VALUE;
		for(int i=0;i<A.size();i++){
			
			int ele = A.get(i);
			set.add(ele);
			if(ele>0) {
				minPos = Math.min(minPos, ele);
				maxPos = Math.max(maxPos, ele);
			}
		}
		
		if(minPos==Integer.MAX_VALUE || minPos>1)
			return 1;
		
		for(int i=minPos;i<maxPos;i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		
		return maxPos+1;		
	}

	//wrong
	public int trap(final int[] A) {
		int water = 0;
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i=0;i<A.length;i++) {
			if(s.isEmpty()) {
				s.push(i);
				continue;
			}
			if(A[s.peek()]>A[i])
				s.push(i);
			else {
				
				int l = 0;
				while(!s.isEmpty() && A[s.peek()]<=A[i]) {
					int index = s.pop();
					int h = A[index];
					int w = i-1-index;
					int trapped = w * (h-l);
					if(trapped>0)
						water += trapped;
					l = h;
				}
				s.push(i);
				
			}
		}
		while(!s.isEmpty() && s.size()>1) {
			int index = s.pop();
			int w = index-1-s.peek();
			int h = A[index];
			water += w*h;
		}
		
		return water;
	}
	
	

	public ListNode detectCycle(ListNode a) {
        ListNode slowRunner = a;
        ListNode fastRunner = a;
        ListNode slowRunner2 = a;
        
        if(a == null)
        {
            return null;
        }
        
        int loopLength = 0;
        while(fastRunner.next != null && fastRunner.next.next != null)
        {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            
            if(slowRunner == fastRunner)
            {
                // loop found.
                loopLength = 1;
                slowRunner = slowRunner.next;
                while(slowRunner != fastRunner)
                {
                    slowRunner = slowRunner.next;
                    loopLength += 1;
                }
                

                slowRunner = a;
                while(true)
                {
                    if(slowRunner == fastRunner)
                    {
                        return slowRunner;
                    }
                    
                    slowRunner = slowRunner.next;
                    fastRunner = fastRunner.next;
                }
            }
        }
        
        return null;
    }
	
	public int[] nextPermutation(int[] A) {
		
		
		int nextLow = -1;
		int index = A.length-1;
		
		while(nextLow==-1 && index>=0) {
			for(int i=A.length-2;i>=0;i--) {
				if(A[i]<A[index]) {
					nextLow = i;
					break;
				}
			}
			if(nextLow!=-1)
				break;
			index--;
		}		
		if(nextLow==-1) {
			Integer[] a = new Integer[A.length];
			for(int i=0;i<A.length;i++) {
				a[i] = A[i];
			}
			Arrays.sort(a,Collections.reverseOrder());
			for(int i=0;i<A.length;i++) {
				A[i] = a[i];
			}
			return A;
		}
		
		int temp = A[nextLow];
		A[nextLow] = A[index];
		A[index] = temp;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=nextLow+1;i<A.length;i++){
            list.add(A[i]);
        }
        if(list.size()>0) {
	        Collections.sort(list);
	        for(int i=nextLow+1;i<A.length;i++){
	            A[i] = list.get(i-(nextLow+1));
	        }
        }
		return A;
		
	}
	public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        ArrayList<Integer> a = new ArrayList<>(A);
        int n=a.size();
        int index = -1;
        for (int i = n-1; i > 0; i--) {
            if (a.get(i) > a.get(i-1)) {
                index = i-1;
                break;
            }
        }
        
        if (index == -1) {
            Collections.sort(a);
        }
        else {
            
            int swapWithIndex = -1;
            for(int j = n-1; j >index; j--) {
                if (a.get(j) > a.get(index)) {
                    swapWithIndex = j;
                    break;
                }
            }
            
            int temp = a.get(index);
            a.set(index, a.get(swapWithIndex));
            a.set(swapWithIndex, temp);
          
            Collections.sort(a.subList(index+1, n));
        }
        return a;
	}
	
	public int solvePartition(int A, int[] B) {
		int cnt = 0;
		for(int i=1;i<=B.length-2;i++) {
			for(int j=1;j<B.length-i;j++) {
				
					
					int sum1 = 0;
					int sum2 = 0;
					int sum3 = 0;
					
					for(int l=0;l<i;l++) {
						sum1+=B[l];
					}
					for(int l=i;l<i+j;l++) {
						sum2+=B[l];
					}
					for(int l=i+j;l<B.length;l++) {
						sum3+=B[l];
					}
					if(sum1==sum2 && sum2==sum3) {
						cnt++;
						//System.out.println(cnt);
					}
				
			}
		}
		return cnt;
	}
	
 	boolean found;
    public int wordBreakDP(String A, ArrayList<String> B) {
        /*boolean[] dp = new boolean[A.length()+1];
        dp[0] = true;
        
        for(int len=1;len<=A.length();len++)
        {
            for(int j=len-1;j>=0;j--){
                
                if(dp[j] && B.contains(A.substring(j,len))){
                    dp[len]=true;
                    break;
                }
                
            }
        }
        return dp[A.length()]==true?1:0;*/
        boolean[] v = new boolean[B.size()];
        found = false;
        util(A,B,v,"");
        return found?1:0;
    }
    private void util(String a,ArrayList<String> b,boolean[] v,String str){
        
        if(str.equals(a)){
            found = true;
            return;
        }
        for(int i=0;i<b.size();i++){
            if(!v[i] && !found){
                v[i] = true;
                str = str + b.get(i);
                util(a,b,v,str);
                str = str.substring(0,str.length()-b.get(i).length());
                v[i] = false;
            }
        }
        
    }
	    
    public ArrayList<String> restoreIpAddresses(String A) {
    	ArrayList<String> res = new ArrayList<String>();
    	generateIPs(A,res,new ArrayList<String>(),0);
    	return res;
    }
	    
	private void generateIPs(String a, ArrayList<String> res,ArrayList<String> l, int index) {
			// TODO Auto-generated method stub
		
		if(l.size()==4 && index==a.length()) {
			String r = "";
			for(String s : l) {
				r = r + s;	
				r = r + ".";
			}
			r = r.substring(0, r.length()-1);
			res.add(r);
		}
		for(int i=index;i<=index+3 && i<=a.length();i++) {
			String str = a.substring(index, i);
			if(isValidIpPart(str) && l.size()<4) {
				l.add(str);
				generateIPs(a, res, l, i);
				l.remove(l.size()-1);
			}
		}
		
	}
	private boolean isValidIpPart(String s) {
		if(s.length()==0)
			return false;
		if(s.length()>1 && s.charAt(0)=='0')
			return false;
		/*
		 * for(int i=0;i<s.length()-1;i++) { if(s.charAt(i)=='0' && s.charAt(i+1)=='0')
		 * return false; }
		 */
		Integer i = Integer.parseInt(s);
		if(i>255)
			return false;				
		return true;
	}
	
	int cnt;
	boolean possible;
    public int cntMatrix(TreeNode A, TreeNode B) {
    	cnt = 0;
    	possible = true;
        check(A,B);
        return possible?cnt:-1;
    }
    private void check(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) {
            return;
        }
        if(t1==null && t2!=null) {
        	ArrayList<Integer> a = new ArrayList<Integer>();
        	cntNodes(t2,a);
        	cnt += a.size();
        	a.clear();
        	return;
        }
        if(t1!=null && t2==null) {
        	possible = false;
            return;
        }
        if(possible) {
	        check(t1.left,t2.left);
	        check(t1.right,t2.right);
        }
    }

	private void cntNodes(TreeNode node,ArrayList<Integer> a) {
		// TODO Auto-generated method stub
		if(node==null)
			return;		
		cntNodes(node.left, a);
		a.add(node.val);
		cntNodes(node.right, a);
	}
	
	public int[] getMode(int[] A, int[][] B) {
		int[] res = new int[B.length];
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		init(A,map);
		
		for(int i=0;i<B.length;i++) {
			int index = B[i][0]-1;
			int val = B[i][1];
			removeKey(A[index],map);
			A[index] = val;
			addKey(val,map);
			res[i] = getMode(map);
		}
		
		return res;
    }

	private int getMode(HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
		/*
		 * int max = Integer.MIN_VALUE; int maxVal = Integer.MAX_VALUE;
		 * Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		 * while(iterator.hasNext()) { Entry<Integer, Integer> next = iterator.next();
		 * if(next.getValue()>=max) {
		 * 
		 * 
		 * if(next.getValue()==max) { if(next.getKey()<maxVal) { maxVal = next.getKey();
		 * } } else maxVal = next.getKey();
		 * 
		 * 
		 * max = next.getValue(); } }
		 * 
		 * return maxVal;
		 */
	}

	private void addKey(int key, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if(map.containsKey(key)) {
			map.put(key, map.get(key)+1);
		}else {
			map.put(key, 1);
		}
	}

	private void removeKey(int key, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if(map.get(key)==1) {
			map.remove(key);
		}else {
			map.put(key,map.get(key)-1);
		}
	}

	private void init(int[] a, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++) {
			if(map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i])+1);
			}else {
				map.put(a[i], 1);
			}			
		}
	}

	public static void main(String[] args) {
		IBRevision t = new IBRevision();		
		int[] A = new int[] {2,2,2,3,3};
		int[][] B = new int[][] {{1,3},{5,4},{2,4}};
		int[] res = t.getMode(A, B);
		for(int i=0;i<res.length;i++)
			System.out.print(res[i]+"\t");
		
		/*
		 * ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('5','3','.','.','7','.','.','.','.')));
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('6','.','.','1','9','5','.','.','.')));
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('.','9','8','.','.','.','.','6','.')));
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('8','.','.','.','6','.','.','.','3')));
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('4','.','.','8','.','3','.','.','1')));
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('7','.','.','.','2','.','.','.','6')));
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('.','6','.','.','.','.','2','8','.')));
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('.','.','.','4','1','9','.','.','5')));
		 * a.add(new
		 * ArrayList<Character>(Arrays.asList('.','.','.','.','8','.','.','7','9')));
		 * t.solveSudoku(a);
		 */		
	}

}
