class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                ans[i]+=nums[j];
            }
        }
        return ans;
    }
}