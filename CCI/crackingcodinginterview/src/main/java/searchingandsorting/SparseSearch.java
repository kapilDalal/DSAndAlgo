package searchingandsorting;

public class SparseSearch {

    public int getIndex(String[] arr,String target){

        int start= 0;
        int end = arr.length-1;

        int prevS=-1;
        int prevE=-1;

        while(start<end){
            int mid = (start+end)/2;
            while(arr[mid].length()==0)
                mid--;
            int res = compare(arr[mid],target);
            if(res==0)
                return mid;
            else if(res>0){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            if(prevS==-1){
                prevS=start;
                prevE=end;
            }
            else{
                if(prevS==start && prevE==end)
                    break;
                prevS = start;
                prevE = end;
            }

        }
        return -1;
    }

    private int compare(String s, String target) {

        for(int i=0;i<Math.min(s.length(),target.length());i++){
            if(s.charAt(i)==target.charAt(i))
                continue;
            else if(s.charAt(i)>target.charAt(i))
                return 1;
            else
                return -1;
        }
        if(s.length()==target.length())
            return 0;
        if(s.length()>target.length())
            return 1;
        return -1;
    }

    public static void main(String[] args) {
        SparseSearch ss = new SparseSearch();
        String[] arr = {"at","","","","ball","","","car","","","dad","",""};
        System.out.println(ss.getIndex(arr,"dad"));

    }

}
