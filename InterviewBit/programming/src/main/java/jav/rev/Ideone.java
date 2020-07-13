package jav.rev;

class Ideone
{   String ans="";
    int count=0;
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone o=new Ideone();
		System.out.println(o.getPermutation(7,64));
 
	}
	public String getPermutation(int n, int k){
		if(n==1 && k==1) return "1";
		if(n==0 || k==0) return "0";
		int index=0;
		for(int i=1;i<=n;i++){
			if(fact(i)>=k){
				index=i;
				break;
			}
		}
		String result="";
		for(int i=1;i<=n-index;i++){
			result+=i;
		}
		boolean v[]=new boolean[n+1];
		int bias=n-index;
		int start=n-index+1;
		if(start>n) return "";
		backTrack(v,"",bias,start,k,n);
		if(ans.length()>0)
		return result+ans;
		return "";
	}
	private void backTrack(boolean v[],String str,int bias,int s,int k,int n){
		if(n-bias==str.length()){
			count++;			
			if(k==count){
				ans=str;
			}
		}
		
		
		for(int i=bias+1;i<=n;i++){
			if(!v[i]){
				v[i]=true;
				backTrack(v,str+i,bias,i,k,n);
			}
		}
		v[s]=false;
	}
	public int fact(int n) {
        int f = 1;
        for( int i = 1; i <= n;i++) {
            f *= i;
        }
        return f;
    }
}
