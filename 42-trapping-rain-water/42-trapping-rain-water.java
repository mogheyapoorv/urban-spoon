class Solution {
    public int trap(int[] height) {
         int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int i = 0;
        int j = height.length - 1;

        int ans = 0;
        while (i <= j) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[i]);
                ans += leftMax - height[i];
                i++;
                continue;
            }

            rightMax = Math.max(rightMax, height[j]);
            ans += rightMax - height[j];
            j--;
        }
        return ans;
    }
}