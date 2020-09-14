package challenge.monthly.september;

public class CompareVersions_9 {

    public int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int f = 0;
        int s = 0;
        while(f< split1.length && s< split2.length){

            String str1 = split1[f];
            String str2 = split2[s];

            int s1 = 0;
            int s2 = 0;

            while(s1<str1.length() && str1.charAt(s1)=='0')
                s1++;

            while(s2<str2.length() && str2.charAt(s2)=='0')
                s2++;

            while(s1<str1.length() && s2<str2.length()){

                if(str1.charAt(s1)>str2.charAt(s2)) {
                    if(str1.length()==str2.length())
                        return 1;
                }
                if(str1.charAt(s1)<str2.charAt(s2))
                    if(str1.length()==str2.length())
                        return -1;

                s1++;
                s2++;
            }

            if(s1<str1.length())
                return 1;

            if(s2<str2.length())
                return -1;

            f++;
            s++;

        }

        while(f<split1.length){
            String str = split1[f];

            for(int i=0;i<str.length();i++)
                if(str.charAt(i)!='0')
                    return 1;
            f++;
        }
        while(s<split2.length){
            String str = split2[s];

            for(int i=0;i<str.length();i++)
                if(str.charAt(i)!='0')
                    return -1;
            s++;
        }



        return 0;
    }

    public static void main(String[] args) {
        CompareVersions_9 cv = new CompareVersions_9();
        System.out.println(cv.compareVersion("1.2","1.10"));
    }

}
