package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PointsOnStraightLine {
	
	static public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		if(a.size()<=2)
			return a.size();
		int max = 2;
		
		HashMap<Float,Integer> map = new HashMap<>();
		for(int i=0;i<a.size();i++){
			int overLapping=0,vertical=0,currMax=0;			
			for(int j=i+1;j<a.size();j++){
				if(a.get(j)==a.get(i) && b.get(j)==b.get(i))
					overLapping++;
				else if(a.get(j)==a.get(i))
					vertical++;
				else{
					float xIntercept = a.get(j)-a.get(i);
					float yIntercept = b.get(j)-b.get(i);
					float slope = (float)(1.0) * (yIntercept / xIntercept);
					if(map.containsKey(slope)){
						map.put(slope, map.get(slope)+1);
						currMax = Math.max(currMax, map.get(slope));
					}else{
						map.put(slope, 1);
					}
				}
				
				currMax = Math.max(currMax, vertical);
			}
			max = Math.max(max, currMax+overLapping+1);
			map.clear();
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		System.out.println(maxPoints(new ArrayList<Integer>(Arrays.asList(-2,-9,4,-7,5,10,1)), new ArrayList<Integer>(Arrays.asList(-17,-19,-12,-15,-3,11,4))));
	}

}
