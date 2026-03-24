// LC 2906 Construct Product Matrix
// This is the POD for 24th March, 2026

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int MOD = 12345;
        int size = m * n;

        int[] flat = new int[size];
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flat[idx++] = val % MOD;
            }
        }

        int[] prefix = new int[size];
        int[] suffix = new int[size];

        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * flat[i - 1]) % MOD;
        }

        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * flat[i + 1]) % MOD;
        }

        int[][] res = new int[m][n];
        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = (prefix[idx] * suffix[idx]) % MOD;
                idx++;
            }
        }

        return res;
    }
}
