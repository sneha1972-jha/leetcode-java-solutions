class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int sum1 = 0, sum2 = 0;
        int q1 = 0, q2 = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                q1++;
            } else {
                sum1 += num.charAt(i) - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                q2++;
            } else {
                sum2 += num.charAt(i) - '0';
            }
        }

        // If total '?' is odd, Alice gets one extra move
        if ((q1 + q2) % 2 == 1) {
            return true;
        }

        // Bob can balance the game only in this condition
        return 2 * (sum1 - sum2) != 9 * (q2 - q1);
    }
}