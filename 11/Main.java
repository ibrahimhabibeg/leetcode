import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        
    }
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = -1;
        while (start<end) {
            int area = Math.min(height[start], height[end])*(end-start);
            maxArea = Math.max(area, maxArea);
            if (height[end]<height[start]) {
                end--;
            }else{
                start++;
            }
        }
        return maxArea;
    }
}