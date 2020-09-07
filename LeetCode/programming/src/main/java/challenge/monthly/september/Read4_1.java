package challenge.monthly.september;

public class Read4_1 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    //read4 was given by leet code
    int read4(char[] arr){
        return 0;
    }

    public int read(char[] buf, int n) {
        int t = n;
        int cnt = 0;
        int i=0;
        int num = 1;
        int toRead = 0;
        while(n>0 && num>0){

            char[] temp = new char[4];
            num = read4(temp);


            if(n>=4 && num==4)
                toRead = 4;
            else
                toRead = Math.min(n,num);

            for(int k=0;k<toRead;k++){
                buf[i++] = temp[k];
            }

            n = n-num;
            if(num!=0)
                cnt += toRead;
        }

        return cnt;
    }
}
