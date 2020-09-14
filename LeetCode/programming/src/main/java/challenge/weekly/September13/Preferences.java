package challenge.weekly.September13;

public class Preferences {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int cnt = 0;

        for(int i=0;i< pairs.length;i++){

            int f = pairs[i][0];
            int s = pairs[i][1];

            if(notHappy(f,s,preferences))
                cnt++;
            if(notHappy(s,f,preferences))
                cnt++;


        }


        return cnt;
    }

    private boolean notHappy(int f, int s, int[][] preferences) {

        if(preferences[f][0]==s)
            return false;

        return true;
    }

    public static void main(String[] args) {

    }
}
