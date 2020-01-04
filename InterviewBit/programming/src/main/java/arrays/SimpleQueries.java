/*
You are given an array A having N integers.
You have to perform the following steps in a given order.

generate all subarrays of A.
take the maximum element from each subarray of A and insert it into a new array G.
replace every element of G with the product of their divisors mod 1e9 + 7.
sort G in descending order
perform Q queries
In each query, you are given an integer K, where you have to find the Kth element in G.

Note: Your solution will run on multiple test cases so do clear global variables after using them.


Input Format

The first argument given is an Array A, having N integers.
The second argument given is an Array B, where B[i] is the ith query.
Output Format

Return an Array X, where X[i] will have the answer for the ith query.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e5
1 <= Q <= 1e5
1 <= k <= (N * (N + 1))/2 
For Example

Input:
    A = [1, 2, 4]
    B = [1, 2, 3, 4, 5, 6]
Output:
    X = [8, 8, 8, 2, 2, 1]
   
Explanation:
    subarrays of A	  maximum element
    ------------------------------------
    1. [1]							1
    2. [1, 2]						2
    3. [1, 2, 4]					4
    4. [2]							2
    5. [2, 4]						4
    6. [4]							4

	original
	G = [1, 2, 4, 2, 4, 4]
	
	after changing every element of G with product of their divisors
	G = [1, 2, 8, 2, 8, 8]
	after sorting G in descending order
	G = [8, 8, 8, 2, 2, 1]
*/

package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleQueries {
	
	static public ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<Integer> res1 = new ArrayList<>();
		for(int i=0;i<A.size();i++){
			for(int j=i;j<A.size();j++){
				List<Integer> l = new ArrayList<Integer>(A.subList(i, j+1));
				Collections.sort(l);
				res.add(l.get(l.size()-1));
			}
			
		}
		System.out.println(res);
		for(int i=0;i<res.size();i++){
			res.set(i, productOfDivisors(res.get(i)));
		}
		System.out.println(res);
		Collections.sort(res,Collections.reverseOrder());
		System.out.println(res);
		for(int i=0;i<B.size();i++){
			res1.add(res.get(B.get(i)-1));
		}
		//System.out.println(res1);
		return res1;
    }
	
	private static Integer productOfDivisors(Integer num) {
		// TODO Auto-generated method stub
		//ArrayList<Integer> div = new ArrayList<>();
		long div = 1;
		for(int i=1;i<=num;i++){
			//float res = (float)num % i;
			if(num%i==0)
				div = (1L*div*i)%1000000007;			                  
		}
		return (int)div;
	}

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(39, 99, 70, 24, 49, 13, 86, 43, 88, 74, 45, 92, 72, 71, 90, 32, 19, 76, 84, 46, 63, 15, 87, 1, 39, 58, 17, 65, 99, 43, 83, 29, 64, 67, 100, 14, 17, 100, 81, 26, 45, 40, 95, 94, 86, 2, 89, 57, 52, 91, 45);
		List<Integer> B = Arrays.asList(1221, 360, 459, 651, 958, 584, 345, 181, 536, 116, 1310, 403, 669, 1044, 1281, 711, 222, 280, 1255, 257, 811, 409, 698, 74, 838);
		//System.out.println(A.size()+"\t"+B.size());
		List<Integer> c = Arrays.asList(300,100,200);
		List<Integer> d = Arrays.asList(6,5,4,3,2,1);
		System.out.println(solve(c,d));
		//System.out.println(productOfDivisors(9));
	}

}
