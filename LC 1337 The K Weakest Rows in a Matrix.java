// LC 1337 The K Weakest Rows in a Matrix

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        
        int[][] strength = new int[m][2]; 
        
        for (int i = 0; i < m; i++) {
            int count = countOnes(mat[i]);
            strength[i][0] = count;
            strength[i][1] = i;
        }
        
        Arrays.sort(strength, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = strength[i][1];
        }
        
        return res;
    }
    
    private int countOnes(int[] row) {
        int left = 0, right = row.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}
