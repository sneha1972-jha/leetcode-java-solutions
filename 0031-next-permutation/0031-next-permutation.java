class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        boolean found=false;
        for(int i=n-2;i>=0;i--){
           if(nums[i]<nums[i+1]){
           int j = n - 1;
           found=true;
           while(nums[j] <= nums[i]){
                  j--;
              }
            swap(nums, i, j);
            reverse(nums,i+1,n-1);
            break;
           }
           
        }
        if(!found){
            reverse(nums,0,n-1);
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void reverse(int[] nums,int low,int high){
        while(low<high){
            int temp=nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }
}