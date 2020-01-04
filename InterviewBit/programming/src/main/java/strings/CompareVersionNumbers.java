package strings;

import java.math.BigInteger;

public class CompareVersionNumbers {

	public int compareVersion(String A, String B) {
		int res = 0;
		String[] splitA = A.split("\\.");
		String[] splitB = B.split("\\.");
		int i = 0;
		int j = 0;
		while (i < splitA.length && j < splitB.length) {
			BigInteger a = new BigInteger(splitA[i]);
			BigInteger b = new BigInteger(splitB[j]);
			if (a.compareTo(b) == 1)
				return 1;
			else if (a.compareTo(b) == -1)
				return -1;
			i++;
			j++;
		}
		
		if (i < splitA.length){
			for(;i<splitA.length;i++){
				if(Integer.parseInt(splitA[i])!=0)
					return 1;
			}
			return res;
		}
		if (j < splitB.length){
			for(;j<splitB.length;j++){
				if(Integer.parseInt(splitB[j])!=0)
					return -1;
			}
			return res;
		}
		return res;
	}

	public static void main(String[] args) {
		CompareVersionNumbers cvn = new CompareVersionNumbers();

		System.out.println(cvn.compareVersion("1.0", "1"));		
	}

}
