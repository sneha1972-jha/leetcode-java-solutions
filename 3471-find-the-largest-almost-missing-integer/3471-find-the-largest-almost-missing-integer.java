import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> windows = new HashMap<>();

        // First window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int x : freq.keySet()) {
            windows.put(x, 1);
        }

        // Slide the window
        for (int i = k; i < n; i++) {

            // Remove left element
            int left = nums[i - k];
            freq.put(left, freq.get(left) - 1);

            if (freq.get(left) == 0) {
                freq.remove(left);
            }

            // Add right element
            int right = nums[i];
            freq.put(right, freq.getOrDefault(right, 0) + 1);

            // Every number currently in this window appears
            // in one more subarray
            for (int x : freq.keySet()) {
                windows.put(x, windows.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        for (int x : windows.keySet()) {
            if (windows.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}