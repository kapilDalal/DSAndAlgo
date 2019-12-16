/*You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 
*/


package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NbyThree {

	//first approach : using map
	static public int repeatedNumber(final List<Integer> a) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = (int) Math.floor(a.size() / 3);
        int res = -1;
        for (int i = 0; i < a.size(); i++) {
            if (map.isEmpty()) {
                map.put(a.get(i), 1);
                if(count==0){
                    res = a.get(i);
                    break;
                }
                    
                continue;
            }
            if (map.containsKey(a.get(i))) {
                int val = map.get(a.get(i));
                if (val + 1 > count) {
                    res = a.get(i);
                    break;
                }

                map.put(a.get(i), val+1);
            } else{
                map.put(a.get(i), 1);
                 if(count==0){
                    res = a.get(i);
                    break;
                }
            }
        }
        return res;
	}
	//Using Boyer-Moore Majority Vote Algorithm in constant space
	static public int repeatedNumberConstantSpace(final List<Integer> a){
		int res=-1;
		int e1=a.get(0),e2=a.get(0); //need to take some element which is not in a
		int cnt1=0,cnt2=0;
		
		for(int i=1;i<a.size();i++){
			int ele = a.get(i);
			if(cnt1==0 || ele==e1){
				cnt1++;
				e1 = ele;
			}
			else if(cnt2==0 || ele==e2){
				cnt2++;
				e2=ele;
			}else{
				cnt1--;
				cnt2--;
			}
		}
		cnt1=cnt2=0;
		for(int i=1;i<a.size();i++){
			int ele=a.get(i);
			if(ele==e1)
				cnt1++;
			if(ele==e2)
				cnt2++;
		}
		if(cnt1>(int) Math.floor(a.size() / 3))
			res = e1;
		if(cnt2>(int) Math.floor(a.size() / 3))
			res = e2;
		
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1, 1, 1, 2, 3, 5, 7);
		System.out.println(repeatedNumber(a));
	}

}
