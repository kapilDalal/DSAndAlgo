package challenge.monthly.september;

public class LargestTimeForGivenDigits_1 {
    public String largestTimeFromDigits(int[] A) {
        if(!isValid(A))
            return "";

        boolean[] visited = new boolean[4];
        String hour = getHour(A,visited);
        System.out.println(hour);
        if(hour.length()<2)
            return "";
        String minutes = getMinutes(A,visited);
        System.out.println(minutes);
        if(minutes.length()<2)
            return "";
        return hour+":"+ minutes;
    }

    private String getMinutes(int[] a, boolean[] visited) {
        String first = "";
        String second = "";


        if(first.isEmpty())
            for(int i=0;i<a.length;i++){
                if(a[i]==5 && !visited[i]){
                    first = "5";
                    visited[i] = true;
                    break;
                }
            }
        if(first.isEmpty())
            for(int i=0;i<a.length;i++){
                if(a[i]==4 && !visited[i]){
                    first = "4";
                    visited[i] = true;
                    break;
                }
            }
        if(first.isEmpty())
            for(int i=0;i<a.length;i++){
                if(a[i]==3 && !visited[i]){
                    first = "3";
                    visited[i] = true;
                    break;
                }
            }
        if(first.isEmpty())
            for(int i=0;i<a.length;i++){
                if(a[i]==2 && !visited[i]){
                    first = "2";
                    visited[i] = true;
                    break;
                }
            }
        if(first.isEmpty())
            for(int i=0;i<a.length;i++){
                if(a[i]==1 && !visited[i]){
                    first = "1";
                    visited[i] = true;
                    break;
                }
            }
        if(first.isEmpty())
            for(int i=0;i<a.length;i++){
                if(a[i]==0 && !visited[i]){
                    first = "0";
                    visited[i] = true;
                    break;
                }
            }
        for(int i=0;i<a.length;i++){
            if(!visited[i]){
                second = String.valueOf(a[i]);
                visited[i] = true;
                break;
            }
        }

        return first+second;
    }

    //hour can not be greater than 23
    private String getHour(int[] a, boolean[] visited) {
        String first = "";
        String second = "";
        String third = "";
        for(int i=0;i<a.length;i++){
            if(a[i]==2) {
                first = "2";
                visited[i] = true;
                break;
            }
        }
        if(first.isBlank() || first.isEmpty()){
            for(int i=0;i<a.length;i++){
                if(a[i]==1) {
                    first = "1";
                    visited[i] = true;
                    break;
                }
            }
            if(!first.isEmpty()){
            int max = 0;
            int maxIndex = 0;
            for(int i=0;i<a.length;i++){
                if(max<a[i] && !visited[i]){
                    maxIndex = i;
                    max = a[i];
                }
            }
            visited[maxIndex] = true;
            second = String.valueOf(a[maxIndex]);
            }
        }
        if(first.isBlank() || first.isEmpty()) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) {
                    first = "0";
                    visited[i] = true;
                    break;
                }
            }
            int max = 0;
            int maxIndex = 0;
            for(int i=0;i<a.length;i++){
                if(max<a[i] && !visited[i]){
                    maxIndex = i;
                    max = a[i];
                }
            }
            visited[maxIndex] = true;
            second = String.valueOf(a[maxIndex]);
        }
        else {
            if(second.isEmpty())
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 3) {
                    second = "3";
                    visited[i] = true;
                    break;
                }
            }
            if (second.isEmpty() || second.isBlank())
                for (int i = 0; i < a.length; i++) {
                    if (a[i] == 2 && !visited[i]) {
                        second = "2";
                        visited[i] = true;
                        break;
                    }
                }
            if (second.isEmpty() || second.isBlank())
                for (int i = 0; i < a.length; i++) {
                    if (a[i] == 1 && !visited[i]) {
                        second = "1";
                        visited[i] = true;
                        break;
                    }
                }
            if (second.isEmpty() || second.isBlank())
                for (int i = 0; i < a.length; i++) {
                    if (a[i] == 0 && !visited[i]) {
                        second = "0";
                        visited[i] = true;
                        break;
                    }
                }
        }
        return first+second;
    }

    private boolean isValid(int[] A){
        for(int i=0;i<A.length;i++){
            if(A[i]==0 || A[i]==1 || A[i]==2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LargestTimeForGivenDigits_1 t = new LargestTimeForGivenDigits_1();
        System.out.println(t.largestTimeFromDigits(new int[]{2,0,6,6}));
    }
}
