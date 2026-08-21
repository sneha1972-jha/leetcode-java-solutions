class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long total = 0;

        // Inclusion-Exclusion
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long g = gcd(lcm, coins[i]);

                    // Avoid overflow
                    long value = lcm / g;

                    if (value > x / coins[i]) {
                        valid = false;
                        break;
                    }

                    lcm = value * coins[i];
                }
            }

            if (!valid || lcm > x) {
                continue;
            }

            long cnt = x / lcm;

            if (bits % 2 == 1) {
                total += cnt;
            } else {
                total -= cnt;
            }

            // We only care whether count >= k
            if (total >= Long.MAX_VALUE / 2) {
                return total;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}