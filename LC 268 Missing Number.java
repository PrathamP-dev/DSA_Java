// LC 268 Missing Number
class Solution {
    public int missingNumber(int[] nums) {
         int n = nums.length;
        int xor = 0;

        // XOR all indices and array values
        for (int i = 0; i < n; i++) {
            xor ^= i;
            xor ^= nums[i];
        }

        // XOR with n
        xor ^= n;

        return xor;
    }
}
