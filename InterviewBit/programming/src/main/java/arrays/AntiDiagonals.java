package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AntiDiagonals {
	
	
	static public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>>  res = new ArrayList<ArrayList<Integer>>();
		int k=0;
		int listNum =0;
		int num;
		boolean flag = false;
		while(true){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=listNum;i<=k;i++){
				list.add(A.get(i).get(0));
				A.get(i).remove(0);
				
			}				
			res.add(list);
			/*if(k!=0 && (k%A.size()==0 || (k+1)%A.size()==0))
				k++;
			k = (k+1) % A.size();*/
			if(k==A.size()-1)
				flag=true;
			if(flag==false)
				k++;
			/*else{
				k--;
			}*/
			listNum = 0;
			for(int i=0;i<A.size();i++){
				if(A.get(i).size()==0)
					listNum++;
				else
					break;
			}			
			if(listNum == A.size())
				break;
		}
		
		
		return res;
	
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(new ArrayList<Integer>(Arrays.asList(1,2)));
		A.add(new ArrayList<Integer>(Arrays.asList(5,6)));
		/*A.add(new ArrayList<Integer>(Arrays.asList(9,10,11,12)));
		A.add(new ArrayList<Integer>(Arrays.asList(13,14,15,16)));*/
		System.out.println(diagonal(A));
		
	}

}
