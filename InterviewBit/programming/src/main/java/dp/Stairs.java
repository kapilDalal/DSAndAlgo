package dp;

public class Stairs {
	static int cnt = 0;
	static public int climbStairs(int A) {
		climb(A);
		return cnt;
    }
	static private void climb(int a) {
		// TODO Auto-generated method stub
		if(a<0)
			return;
		if(a==0)
			cnt++;
		climb(a-1);
		climb(a-2);
	}
	public static void main(String[] args) {
		System.out.println(climbStairs(3));
	}

}
