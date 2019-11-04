package dp;

public class EditDistance {
	
	static int distUsingRec(String str1,String str2,int m,int n){
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(str1.charAt(m-1)==str2.charAt(n-1))
			return distUsingRec(str1, str2, m-1, n-1);
		else
			return 1 + min(distUsingRec(str1, str2, m-1, n),distUsingRec(str1, str2, m, n-1),
							distUsingRec(str1, str2, m-1, n-1));
	}

	private static int min(int x, int y, int z) {
		// TODO Auto-generated method stub
		if(x<=y && x <=z)
			return x;
		else if(y<=x && y<=z)
			return y;
		else
			return z;
		
	}
	static void distUsingDp(String str1,String str2,int m,int n){
		int[][] dist = new int[m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0)
					dist[i][j] = j;
				else if(j==0)
					dist[i][j]=i;
				else if(str1.charAt(i)==str2.charAt(j))
					dist[i][j] = dist[i-1][j-1];
				else
					dist[i][j] = 1+min(dist[i-1][j],dist[i][j-1],dist[i-1][j-1]);
			}
		}
		System.out.println(dist[m-1][n-1]);
	}
	
	
	public static void main(String[] args) {
		String str1 = "geek"; 
        String str2 = "gesek"; 
   
        System.out.println( distUsingRec( str1 , str2 , str1.length(), str2.length()) );
        distUsingDp(str1, str2,str1.length(), str2.length());
	}
	

}
