// LC 39 Combination Sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, target - nums[i], i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
