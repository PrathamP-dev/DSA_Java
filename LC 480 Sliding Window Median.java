// LC 480 Sliding Window Median

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        
        TreeMap<Integer, Integer> left = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> right = new TreeMap<>();
        
        int leftSize = 0, rightSize = 0;

        for (int i = 0; i < n; i++) {
            if (leftSize <= rightSize) {
                right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
                int first = right.firstKey();
                remove(right, first);
                left.put(first, left.getOrDefault(first, 0) + 1);
                leftSize++;
            } else {
                left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
                int last = left.firstKey();
                remove(left, last);
                right.put(last, right.getOrDefault(last, 0) + 1);
                rightSize++;
            }

            if (i >= k) {
                int out = nums[i - k];
                if (left.containsKey(out)) {
                    remove(left, out);
                    leftSize--;
                } else {
                    remove(right, out);
                    rightSize--;
                }
            }

            if (leftSize < rightSize) {
                int first = right.firstKey();
                remove(right, first);
                left.put(first, left.getOrDefault(first, 0) + 1);
                leftSize++; rightSize--;
            } else if (leftSize > rightSize + 1) {
                int last = left.firstKey();
                remove(left, last);
                right.put(last, right.getOrDefault(last, 0) + 1);
                leftSize--; rightSize++;
            }

            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = (double) left.firstKey();
                } else {
                    result[i - k + 1] = ((double) left.firstKey() + right.firstKey()) / 2.0;
                }
            }
        }
        return result;
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) map.remove(val);
        else map.put(val, count - 1);
    }
}
