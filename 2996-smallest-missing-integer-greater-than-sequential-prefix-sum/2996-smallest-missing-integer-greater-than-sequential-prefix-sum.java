class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];

        // Find sum of longest sequential prefix
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Check which numbers exist in nums
        boolean[] present = new boolean[51];

        for (int num : nums) {
            present[num] = true;
        }

        // Find smallest missing number >= sum
        while (sum < present.length && present[sum]) {
            sum++;
        }

        return sum;
    }
}