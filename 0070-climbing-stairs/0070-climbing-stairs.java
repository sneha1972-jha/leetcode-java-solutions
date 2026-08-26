class Solution {

    HashMap<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        int i = 0;
        return fun(i, n);
    }

    public int fun(int i, int n) {

        if (i == n) {
            return 1;
        }

        if (i > n) {
            return 0;
        }

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        dp.put(i, fun(i + 1, n) + fun(i + 2, n));

        return dp.get(i);
    }
}