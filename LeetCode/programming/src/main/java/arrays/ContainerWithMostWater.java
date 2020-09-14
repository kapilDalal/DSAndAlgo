package arrays;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max = 0;
        for(int i=0;i< height.length-1;i++){
            for(int j=i+1;j< height.length;j++){
                int h = Math.min(height[i],height[j]);
                int w = j-i;
                max = Math.max(max,w*h);
            }
        }
        return max;
    }

    public static int maxAreaOptimised(int[] height){
        int area = 0;
        int start = 0;
        int end = height.length-1;
        while(start<end){
            if(height[start]>height[end]){
                area = Math.max(area,height[end]*(end-start));
                end--;
            }else{
                area = Math.max(area,height[start]*(end-start));
                start++;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOptimised(new int[]{1}));
    }


}
