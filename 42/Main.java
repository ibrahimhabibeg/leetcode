class Main {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        Main main = new Main();
        System.out.println(main.trap(heights));
    }

    public int trap(int[] height) {
        int ans = 0, l = 0, maxL = 0, r = height.length - 1, maxR = 0;
        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] >= maxL)
                    maxL = height[l];
                else
                    ans += maxL - height[l];
                l++;
            }else{
                if (height[r] >= maxR)
                    maxR = height[r];
                else
                    ans += maxR - height[r];
                r--;
            }
        }
        return ans;
    }
}