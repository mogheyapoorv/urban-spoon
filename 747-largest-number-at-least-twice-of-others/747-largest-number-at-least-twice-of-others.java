class Solution {
     public int dominantIndex(int[] nums) {
      if (nums.length == 1) {
            return 0;
        }
        int maxElement = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxElement < nums[i]) {
                maxElement = nums[i];
                maxIndex = i;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != maxElement && nums[i] * 2 > maxElement) {
                return -1;
            }
        }
        return maxIndex;
    
    }
}