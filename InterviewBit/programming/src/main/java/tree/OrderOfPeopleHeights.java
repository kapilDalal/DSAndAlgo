package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderOfPeopleHeights {
	
	static public class HeightData implements Comparable<HeightData>{
		int height;
		int numberOfBiggerPeople;
		public HeightData(int h,int nbp) {
			this.height = h;
			this.numberOfBiggerPeople = nbp;
		}
		@Override
		public int compareTo(HeightData arg0) {
			// TODO Auto-generated method stub					
			return this.height-arg0.height;
		}
		
	}
	
	static public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
		Integer[] res = new Integer[A.size()];
		for(int i=0;i<res.length;i++)
			res[i] = -1;
		ArrayList<HeightData> heightInfo = new ArrayList<>();
		for(int i=0;i<A.size();i++){
			int h = A.get(i);;
			int nbp = B.get(i);
			HeightData hd = new HeightData(h, nbp);
			heightInfo.add(hd);			
		}
		Collections.sort(heightInfo);
		for(int i=0;i<heightInfo.size();i++){
			put(res,heightInfo.get(i));
		}
		List<Integer> asList = Arrays.asList(res);
		return new ArrayList<Integer>(asList);
    }

	private static void put(Integer[] res, HeightData heightData) {
		// TODO Auto-generated method stub
		int i=0;
		int numOfEmptySlots = heightData.numberOfBiggerPeople;
		int cnt = 0;
		if(cnt==numOfEmptySlots){
			if(res[i]==-1){
				res[i] = heightData.height;				
			}
			else{
				for(int j=0;j<res.length;j++){
					if(res[j]==-1)
					{
						res[j] = heightData.height;
						break;
					}
				}
			}
			return;
		}
		for(;i<res.length;i++){
			if(cnt==numOfEmptySlots && res[i]==-1)
				break;
			if(res[i]==-1)
				cnt++;
		}
		res[i] = heightData.height;
	}

	public static void main(String[] args) {
		System.out.println(order(new ArrayList<Integer>(Arrays.asList(86, 92, 49, 21, 62, 27, 90, 59)), new ArrayList<Integer>(Arrays.asList(2, 0, 0, 2, 0, 2, 1, 3))));
		
	}
}
