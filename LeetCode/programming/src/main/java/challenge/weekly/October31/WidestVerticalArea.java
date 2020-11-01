package challenge.weekly.October31;

import java.util.Arrays;

/*
Given n points on a 2D plane where points[i] = [xi, yi],
Return the widest vertical area between two points such that no points are inside the area.

A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.

Note that points on the edge of a vertical area are not considered included in the area.

Input: points = [[8,7],[9,9],[7,4],[9,7]]
Output: 1
Explanation: Both the red and the blue area are optimal.
* */
public class WidestVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        for(int i=0;i<points.length;i++){
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int max = 0;
        for(int i=1;i<x.length;i++){
            max=Math.max(max,x[i]-x[i-1]);
        }
        return max;
    }
}
