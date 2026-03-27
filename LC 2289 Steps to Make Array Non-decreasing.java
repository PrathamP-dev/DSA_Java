// LC 2289 Steps to Make Array Non-decreasing

class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = n - 1; i >= 0; i--) {
            int steps = 0;

            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                steps = Math.max(steps + 1, dp[stack.peek()]);
                stack.pop();
            }

            dp[i] = steps;
            res = Math.max(res, dp[i]);
            stack.push(i);
        }

        return res;
    }
}
