class Solution {
    int[][]dp;
        public int rob(int[] nums) {
        int n=nums.length;
        int i=0;
        int free=1;
        dp=new int[n+1][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fun(nums,n,i,free);
    }
    public int fun(int[] nums,int n,int i,int free){
        if(i==n){
            return 0;
        }
        if(dp[i][free]!=-1){
            return dp[i][free];
        }
        if(free==0){
            return dp[i][free]=fun(nums,n,i+1,1);
        }
        int c1=nums[i]+fun(nums,n,i+1,0);
        int c2=fun(nums,n,i+1,1);
        return dp[i][free]=Math.max(c1,c2);
    }
}