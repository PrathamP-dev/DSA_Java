// LC 1140 Stone Game II

class Solution {
    int[] suffix;
    int[][] memo;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n + 1];

        // build suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        memo = new int[n][n + 1];
        return dfs(0, 1);
    }

    private int dfs(int i, int M) {
        if (i >= n) return 0;

        if (2 * M >= n - i) {
            return suffix[i]; // take all remaining
        }

        if (memo[i][M] != 0) return memo[i][M];

        int best = 0;

        for (int x = 1; x <= 2 * M; x++) {
            int opponent = dfs(i + x, Math.max(M, x));
            int current = suffix[i] - opponent;
            best = Math.max(best, current);
        }

        return memo[i][M] = best;
    }
}
