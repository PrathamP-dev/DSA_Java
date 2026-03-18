// LC 667 Beautiful Arrangement II

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        
        int idx = 0;

        for (int i = 1; i <= n - k - 1; i++) {
            res[idx++] = i;
        }
        int left = n - k;
        int right = n;
        
        while (left <= right) {
            res[idx++] = left++;
            if (left <= right) {
                res[idx++] = right--;
            }
        }
        
        return res;
    }
}
