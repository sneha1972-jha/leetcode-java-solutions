import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort according to ending point
        Arrays.sort(arr, (a, b) -> {
            if (a.r != b.r)
                return Integer.compare(a.r, b.r);
            return Integer.compare(a.idx, b.idx);
        });

        // Find previous non-overlapping interval
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(arr, i);
        }

        /*
         * dp[i][k] = best answer using first i intervals
         *            and choosing at most k intervals.
         */
        State[][] dp = new State[n + 1][5];

        // IMPORTANT:
        // Initialize every state to an empty selection.
        // This prevents NullPointerException.
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new int[0]);
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: Don't take current interval
                State notTake = dp[i - 1][k];

                // Option 2: Take current interval
                State before = dp[prev[i - 1] + 1][k - 1];

                int[] newIndices = Arrays.copyOf(
                    before.indices,
                    before.indices.length + 1
                );

                newIndices[newIndices.length - 1] = arr[i - 1].idx;

                // Answer must contain indices in sorted order
                Arrays.sort(newIndices);

                State take = new State(
                    before.score + arr[i - 1].w,
                    newIndices
                );

                dp[i][k] = better(notTake, take);
            }
        }

        return dp[n][4].indices;
    }

    // Find the last interval whose end < current interval's start
    private int findPrevious(Interval[] arr, int i) {

        int lo = 0;
        int hi = i - 1;
        int ans = -1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid].r < arr[i].l) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    // Compare two states
    private State better(State a, State b) {

        // Higher score is better
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller indices
        return lexicographicallySmaller(a.indices, b.indices) <= 0
                ? a
                : b;
    }

    private int lexicographicallySmaller(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        // If one is a prefix of the other,
        // shorter array is lexicographically smaller.
        return Integer.compare(a.length, b.length);
    }
}
