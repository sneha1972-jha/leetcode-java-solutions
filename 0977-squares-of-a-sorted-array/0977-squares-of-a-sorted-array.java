class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int left=0;
        int right=n-1;
        int pos=n-1;
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                ans[pos]=nums[left]*nums[left];
                left++;
            }else{
                ans[pos]=nums[right]*nums[right];
                right--;
            }
pos--;
        }
        return ans;
    }
}