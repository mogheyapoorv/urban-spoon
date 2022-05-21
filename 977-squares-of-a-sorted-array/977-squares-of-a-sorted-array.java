class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int n = nums.length;
        int[] result = new int[n];

        for (int i = end; i >= 0; i--) {
            int square = 0;
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                square = nums[end];
                end--;
            } else {
                square = nums[start];
                start++;
            }
            result[i] = square * square;
        }

        return result;
    }
}