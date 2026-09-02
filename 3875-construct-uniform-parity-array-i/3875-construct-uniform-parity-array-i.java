class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean hasOdd = false;
        boolean hasEven = false;

        for (int num : nums1) {
            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }

        // Already uniform
        if (!hasOdd || !hasEven) {
            return true;
        }

        // Mixed odd/even: an odd element can help convert parity
        return true;
    }
}