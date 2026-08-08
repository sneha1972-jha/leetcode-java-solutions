class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        StringBuilder clean =new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                clean.append(Character.toLowerCase(ch));
            }
        }
        int left=0;
        int right=clean.length()-1;
        while(left<=right){
            if(clean.charAt(left)!=clean.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}