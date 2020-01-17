package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ContainerWithMostWater {

	public class Container implements Comparable<Container>{
		int base;
		int height;
		
		
		public Container(int base,int height){
			this.base = base;
			this.height = height;
		}

		@Override
		public int compareTo(Container o) {
			// TODO Auto-generated method stub
			return this.height-o.height;
		}

		@Override
		public String toString() {
			return "Container [base=" + base + ", height=" + height + "]";
		}
		
	}
	
	
	
	public int maxArea(ArrayList<Integer> A) {
		int res = Integer.MIN_VALUE;
		
		ArrayList<Container> containers = new ArrayList<>();
		
		for(int i=0;i<A.size();i++){
			Container c = new Container(i,A.get(i));
			containers.add(c);			
		}
		Collections.sort(containers);
				
		
		for(int i=0;i<containers.size();i++){
			int h = containers.get(i).height;
			
			for(int j=i+1;j<containers.size();j++){
				int area = h* Math.abs(containers.get(j).base-containers.get(i).base);
				res = Math.max(res, area);
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		System.out.println(c.maxArea(new ArrayList<Integer>(Arrays.asList(1, 5))));
	}
	
}
