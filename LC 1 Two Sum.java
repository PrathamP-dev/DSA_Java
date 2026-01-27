// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i =0; i < nums.length; i++){
                int num = nums[i];
                int needed = target -num;

                if (map.containsKey(needed)) {
                    return new int[] { map.get(needed), i };
            }
                map.put(num, i);
            }
            return new int [] {};
        }
    }
