class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int zeroCount = 0;

        for (int num : nums) {
            xor ^= num;

            if (num == 0) {
                zeroCount++;
            }
        }

        // Case 1: Whole array already has non-zero XOR
        if (xor != 0) {
            return n;
        }

        // Case 2: All elements are zero
        if (zeroCount == n) {
            return 0;
        }

        // Case 3: Total XOR is 0, but there is at least one non-zero
        return n - 1;
    }
}