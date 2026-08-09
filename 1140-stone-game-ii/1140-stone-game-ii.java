class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    private int solve(int i, int m) {

        if (i >= n) {
            return 0;
        }

        if (2 * m >= n - i) {
            return suffix[i];
        }

        if (dp[i][m] != 0) {
            return dp[i][m];
        }

        int best = 0;

        for (int x = 1; x <= 2 * m && i + x <= n; x++) {

            int nextM = Math.max(m, x);

            // Stones left after taking x piles
            int opponent = solve(i + x, nextM);

            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        dp[i][m] = best;

        return best;
    }
}