package arrays;

import java.util.Arrays;
import java.util.List;

/*
Explanation from stack overflow

first try to think if you were already given the minimum value MIN and maximum value MAX in the array of size N, under what circumstances would the max gap be minimum and maximum ?
Obviously, maximum gap will be maximum when all elements are either MIN or MAX making maxgap = MAX - MIN.
Maximum gap will be minimum when all the elements are equally spaced apart between MIN and MAX. Lets say the spacing between them is gap.
So, they are arranged as
MIN, MIN + gap, MIN + 2*gap, MIN + 3*gap, ... MIN + (N-1)*gap 
where
MIN + (N-1)*gap = MAX .
gap = (MAX - MIN) / (N - 1). 

So, we know now that our answer will lie in the range [gap, MAX - MIN]. Now, if we know the answer is more than gap, what we do is create buckets of size gap for ranges .

[MIN, MIN + gap), [Min + gap, `MIN` + 2* gap) ... and so on
There will only be (N-1) such buckets. We place the numbers in these buckets based on their value.

If you pick any 2 numbers from a single bucket, their difference will be less than gap, and hence they would never contribute to maxgap ( Remember maxgap >= gap ).

We only need to store the largest number and the smallest number in each bucket, and we only look at the numbers across bucket.
Now, we just need to go through the bucket sequentially ( they are already sorted by value ), 
and get the difference of min_value with max_value of previous bucket with at least one value. We take maximum of all such values. 
*/


public class MaxConsecutiveGap {
	static public int maximumGap(final List<Integer> A) {
		
		Integer[] arr = new Integer[A.size()];
		int n = arr.length;
		//System.out.println(n);
		for(int i=0;i<A.size();i++)
			arr[i] = A.get(i);
		int maxVal = arr[0]; 
        int minVal = arr[0]; 
        for (int i = 1; i < n; i++) { 
            maxVal = Math.max(maxVal, arr[i]); 
            minVal = Math.min(minVal, arr[i]); 
        } 
  
        // Arrays to store maximum and minimum values  
        // in n-1 buckets of differences.  
        int maxBucket[] = new int[n - 1]; 
        int minBucket[] = new int[n - 1]; 
        Arrays.fill(maxBucket, 0, n - 1, Integer.MIN_VALUE); 
        Arrays.fill(minBucket, 0, n - 1, Integer.MAX_VALUE); 
  
        // Expected gap for every bucket.  
        float delta = (float) (maxVal - minVal) / (float) (n - 1); 
  
        // Traversing through array elements and  
        // filling in appropriate bucket if bucket  
        // is empty. Else updating bucket values.  
        for (int i = 0; i < n; i++) { 
            if (arr[i] == maxVal || arr[i] == minVal) { 
                continue; 
            } 
  
            // Finding index of bucket.  
            // approach MIN + (N-1)*gap = MAX. (see above explanation)
            // if MAX = MIN + 2*gap 
            // MIN + (N-1)*gap = MIN + 2*gap
            // N = 3
            
            int index = (int) (Math.floor((arr[i] - minVal) / delta));   
            
  
            // Filling/Updating maximum value of bucket  
            if (maxBucket[index] == Integer.MIN_VALUE) { 
                maxBucket[index] = arr[i]; 
            } else { 
                maxBucket[index] = Math.max(maxBucket[index], arr[i]); 
            } 
  
            // Filling/Updating minimum value of bucket  
            if (minBucket[index] == Integer.MAX_VALUE) { 
                minBucket[index] = arr[i]; 
            } else { 
                minBucket[index] = Math.min(minBucket[index], arr[i]); 
            } 
        } 
  
        // Finding maximum difference between maximum value  
        // of previous bucket minus minimum of current bucket.  
        int prev_val = minVal; 
        int max_gap = 0; 
        for (int i = 0; i < n - 1; i++) { 
            if (minBucket[i] == Integer.MAX_VALUE) { 
                continue; 
            } 
            max_gap = Math.max(max_gap, minBucket[i] - prev_val); 
            prev_val = maxBucket[i]; 
        } 
        max_gap = Math.max(max_gap, maxVal - prev_val); 
  
        return max_gap; 
		
		
		
		
		/*int max = 0;
		int size = Integer.MIN_VALUE;
		for(int i=0;i<A.size();i++){
			size = Math.max(size, A.get(i));
		}
		
		Integer[] arr = new Integer[size+1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<A.size();i++){
			arr[A.get(i)]=1;
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null)
				list.add(i);
		}
		for(int i=list.size()-1;i>0;i--)
			max = Math.max(max, list.get(i)-list.get(i-1));
		//System.out.println(max);
		return max;*/
		
    }
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(83564666, 2976674, 46591497, 24720696, 16376995, 63209921, 25486800, 49369261, 20465079, 64068560, 7453256, 14180682, 65396173, 45808477, 10172062, 28790225, 82942061, 88180229, 62446590, 77573854, 79342753, 2472968, 74250054, 17223599, 47790265, 24757250, 40512339, 24505824, 30067250, 82972321, 32482714, 76111054, 74399050, 65518880, 94248755, 76948016, 76621901, 46454881, 40376566, 13867770, 76060951, 71404732, 21608002, 26893621, 27370182, 35088766, 64827587, 67610608, 90182899, 66469061, 67277958, 92926221, 58156218, 44648845, 37817595, 46518269, 44972058, 27607545, 99404748, 39262620, 98825772, 89950732, 69937719, 78068362, 78924300, 91679939, 52530444, 71773429, 57678430, 75699274, 5835797, 74160501, 51193131, 47950620, 4572042, 85251576, 49493188, 77502342, 3244395, 51211050, 44229120, 2135351, 47258209, 77312779, 37416880, 59038338, 96069936, 20766025, 35497532, 67316276, 38312269, 38357645, 41600875, 58590177, 99257528, 99136750, 4796996, 84369137, 54237155, 64368327, 94789440, 40718847, 12226041, 80504660, 8177227, 85151842, 36165763, 72764013, 36326808, 80969323, 22947547, 76322099, 7536094, 18346503, 65759149, 45879388, 53114170, 92521723, 15492250, 42479923, 20668783, 64053151, 68778592, 3669297, 73903133, 28973293, 73195487, 64588362, 62227726, 17909010, 70683505, 86982984, 64191987, 71505285, 45949516, 28244755, 33863602, 18256044, 25110337, 23997763, 81020611, 10135495, 925679, 98158797, 73400633, 27282156, 45863518, 49288993, 52471826, 30553639, 76174500, 28828417, 41628693, 80019078, 64260962, 5577578, 50920883, 16864714, 54950300, 9267396, 56454292, 40872286, 33819401, 75369837, 6552946, 26963596, 22368984, 43723768, 39227673, 98188566, 1054037, 28292455, 18763814, 72776850, 47192134, 58393410, 14487674, 4852891, 44100801, 9755253, 37231060, 42836447, 38104756, 77865902, 67635663, 43494238, 76484257, 80555820, 8632145, 3925993, 81317956, 12645616, 23438120, 48241610, 20578077, 75133501, 46214776, 35621790, 15258257, 20145132, 32680983, 94521866, 43456056, 19341117, 29693292, 38935734, 62721977, 31340268, 91841822, 22303667, 96935307, 29160182, 61869130, 33436979, 32438444, 87945655, 43629909, 88918708, 85650550, 4201421, 11958347, 74203607, 37964292, 56174257, 20894491, 33858970, 45292153, 22249182, 77695201, 34240048, 36320401, 64890030, 81514017, 58983774, 88785054, 93832841, 12338671, 46297822, 26489779, 85959340);
		//List<Integer> A = Arrays.asList(1,10,5);
		System.out.println(maximumGap(A));
	}
	
}
