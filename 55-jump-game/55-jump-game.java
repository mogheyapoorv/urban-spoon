class Solution {
    public boolean canJump(int[] nums) {
        return canJumpHelper(0, nums);
    }

    enum Index {
        GOOD, BAD, UNKNOWN;
    }
    private boolean canJumpHelper(int position, int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = Index.UNKNOWN;
        }

        memo[nums.length - 1] = Index.GOOD;
        for (int i = nums.length - 2; i >=0; i--) {
            int nextFurthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= nextFurthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
}