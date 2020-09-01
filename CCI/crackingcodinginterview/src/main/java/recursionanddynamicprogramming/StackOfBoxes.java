package recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StackOfBoxes {

    private static class Box implements Comparable<Box>{
        int w;
        int h;
        int d;

        public Box(int w,int h,int d){
            this.w = w;
            this.d = d;
            this.h = h;
        }
        @Override
        public int compareTo(Box o) {
            if(this.w==o.w && this.h == o.h && this.d == o.d)
                return 0;
            if(this.w>o.w && this.d>o.d && this.h>o.h)
                return 1;
            return -1;
        }
    }

    public void getMaxHeight(ArrayList<Box> boxes){
        Collections.sort(boxes);
        int[] lis = new int[boxes.size()];
    }


}
