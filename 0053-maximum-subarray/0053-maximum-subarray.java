class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int curr=0;
        for(int i=0;i<n;i++){
          curr+=nums[i];
          if(curr>max){
            max=curr;
          }
          if(curr<0){
            curr=0;
          }
        }
        return max;
    }
}