class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max=0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
           min=Math.min(min,prices[i]);
           int profit=0;
           profit=prices[i]-min;
           max=Math.max(max,profit);
        }
        return max;
    }
}