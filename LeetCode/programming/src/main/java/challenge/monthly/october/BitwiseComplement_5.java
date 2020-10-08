package challenge.monthly.october;

public class BitwiseComplement_5 {

    public int bitwiseComplement(int N) {
        String s = Integer.toBinaryString(N);
        String res = "";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                res = res + "1";
            }else{
                res = res + "0";
            }
        }
        int r = Integer.parseInt(res,2);
        return r;
    }

}
