package strings;

public class AddBinaryStrings {
	
	public String addBinary(String A, String B) {
		String res = "";
        int i=A.length()-1;
        int j=B.length()-1;
        int carry = 0;
        while(i>=0 && j>=0){
            int d1 = A.charAt(i) - '0';
            int d2 = B.charAt(j) - '0';
            if(d1+d2+carry==0){
                res="0"+res;
            } else if(d1+d2+carry==1){
                res="1"+res;
            } else if(d1+d2+carry==2){
                res="0"+res;
            } else if(d1+d2+carry==3){
                res="1"+res;
            }
            carry = (d1+d2+carry)/2;
            i--;
            j--;
        }
        
        while(i>=0){
            int d1 = A.charAt(i) - '0';
            if(d1+carry==0){
                res="0"+res;
            } else if(d1+carry==1){
                res="1"+res;
            } else if(d1+carry==2){
                res="0"+res;
            }
            carry = (d1+carry)/2;
            i--;
        }
        
        while(j>=0){
            int d2 = B.charAt(j) - '0';
            if(d2+carry==0){
                res="0"+res;
            } else if(d2+carry==1){
                res="1"+res;
            } else if(d2+carry==2){
                res="0"+res;
            }
            carry = (d2+carry)/2;
            j--;
        }
        
        if(carry==1){
            res="1"+res;
        }
        return res;
    }
	public static void main(String[] args) {
		AddBinaryStrings bs = new AddBinaryStrings();
		System.out.println(bs.addBinary("1010110111001101101000", "1000011011000000111100110"));
	}

}
