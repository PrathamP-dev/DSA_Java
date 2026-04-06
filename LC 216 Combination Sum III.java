// LC 216 Combination Sum III

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int k, int target, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k && target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if (curr.size() > k || target < 0) return;

        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(i + 1, k, target - i, curr, res);
            curr.remove(curr.size() - 1);
        } 
    }
}
