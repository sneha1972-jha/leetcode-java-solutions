class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        for(int i=0;i<m;i++){
            nums1[i]=nums1[i];
        }
        for(int j=0;j<n;j++){
            nums1[m++]=nums2[j];
        }
        Arrays.sort(nums1);
    }
}