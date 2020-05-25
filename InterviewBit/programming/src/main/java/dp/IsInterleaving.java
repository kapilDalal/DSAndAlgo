package dp;

public class IsInterleaving {

	public int isInterleave(String A, String B, String C) {
        int res = solve(A,B,C,0,0,0);
        return res;
    }
    int solve(String a, String b,String c,int i,int j,int k)
    {
        int res = 0;
        if(k==c.length())
        {
            if(i!=a.length() || j!=b.length())
                return 0;
            return 1;
        }
        if(i!=a.length() && a.charAt(i)==c.charAt(k))
        {
            res |= solve(a,b,c,i+1,j,k+1);
        }    
        if(j!=b.length() && b.charAt(j)==c.charAt(k))
        {
            res |= solve(a,b,c,i,j+1,k+1);
        }        
        return res;
        
    }

	public static void main(String[] args) {
		IsInterleaving in = new IsInterleaving();
		int res = in.isInterleave("kQMi2G2DP4lDVycU2kraW49wnJ5oNQ5szn7tZ7aMA8sM", "J2qof422vinqzNsJIylQEZllxeSD", "Jk2qof4Q2M2vi2Gi2nDqP4zNsJlDIyVylQEcUZ2llkrxaWe49SwDnJ5oNQ5szn7tZ7aMA8sM");
		System.out.println(res);
	}

}
