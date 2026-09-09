class Solution {
    public long countCommas(long n) {
        long commas = 0;
        long start = 1;
        int digits = 0;

        while (start <= n) {
            long end = start * 10 - 1;
            if (end > n) end = n;

            digits++;

            long numbersInRange = end - start + 1;
            long commasPerNumber = (digits - 1) / 3;

            commas += numbersInRange * commasPerNumber;

            start *= 10;
        }

        return commas;
    }
}