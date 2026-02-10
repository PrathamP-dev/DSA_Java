// LC 3719 Longest Balanced Subarray I

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> evens = new HashSet<>();
            Set<Integer> odds = new HashSet<>();

            for (int j = i; j < n; j++) {
                int val = nums[j];

                if (val % 2 == 0) {
                    evens.add(val);
                } else {
                    odds.add(val);
                }

                if (evens.size() == odds.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
