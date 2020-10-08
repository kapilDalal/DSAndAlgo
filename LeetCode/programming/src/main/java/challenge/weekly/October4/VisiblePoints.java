package challenge.weekly.October4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VisiblePoints {


    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int max = 0;
        int x1 = location.get(0);
        int y1 = location.get(1);
        for(int d=0;d<=360;d++){
            float f = (float) d + angle/2f;
            float s = (float) d - angle/2f;
            int currMax = 0;
            for(int i=0;i<points.size();i++){

                int x2 = points.get(i).get(0);
                int y2 = points.get(i).get(1);

                    if(x1==x2 && y1==y2){
                        currMax++;
                    }
                    else if(x1==x2){
                        if((90<=f && 90>=s)|| (270<=f && 270>=s)){
                            currMax++;
                        }
                    }
                    else{
                        float slope = (y2-y1)/(x2-x1);
                        if(slope==0){

                        }
                        if(slope<=f && slope>=s)
                            currMax++;
                    }




            }
            max = Math.max(currMax,max);

        }

        return max;
    }

    public static void main(String[] args) {
        VisiblePoints vp = new VisiblePoints();
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(0,1));
        points.add(Arrays.asList(2,1));
     //   points.add(Arrays.asList(3,4));
      //  points.add(Arrays.asList(1,1));
        int angle = 13;
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);

        System.out.println(vp.visiblePoints(points,angle,location));
    }

}
