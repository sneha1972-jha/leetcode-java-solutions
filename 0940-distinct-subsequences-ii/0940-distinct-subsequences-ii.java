class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        // dp[i] = number of distinct subsequences (including empty)
        // using first i characters
        long[] dp = new long[n + 1];
        dp[0] = 1;

        // Last position where each character occurred
        int[] last = new int[26];

        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';

            // Add all subsequences by either taking or not taking s[i-1]
            dp[i] = (2 * dp[i - 1]) % MOD;

            // Remove duplicates created by previous occurrence
            if (last[c] != 0) {
                dp[i] = (dp[i] - dp[last[c] - 1] + MOD) % MOD;
            }

            last[c] = i;
        }

        // Remove the empty subsequence
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}