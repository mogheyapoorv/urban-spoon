class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));

        int start = 0;
        int end = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            priorityQueue.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        while (nums.size() == priorityQueue.size()) {
            int[] bucket = priorityQueue.poll();
            int row = bucket[0];
            int col = bucket[1];
            if (end - start > max - nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = max;
            }

            if (col + 1 < nums.get(row).size()) {
                priorityQueue.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }

        return new int[] {start, end};
    }
}