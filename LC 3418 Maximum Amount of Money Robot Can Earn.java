// LC 3418 Maximum Amount of Money Robot Can Earn
// This is the POD for 02 April, 2026

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // start
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) dp[0][0][1] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    // move right
                    if (j + 1 < n) {
                        int val = coins[i][j + 1];

                        // take normally
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k],
                                dp[i][j][k] + val);

                        // neutralize if negative
                        if (val < 0 && k < 2) {
                            dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1],
                                    dp[i][j][k]);
                        }
                    }

                    // move down
                    if (i + 1 < m) {
                        int val = coins[i + 1][j];

                        // take normally
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k],
                                dp[i][j][k] + val);

                        // neutralize if negative
                        if (val < 0 && k < 2) {
                            dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1],
                                    dp[i][j][k]);
                        }
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int k = 0; k < 3; k++) {
            res = Math.max(res, dp[m - 1][n - 1][k]);
        }
        return res;
    }
}
