class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> map=new HashMap<>();
        HashSet <Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
               if(map.get(ch) != t.charAt(i)){
                      return false;
              }
            }else{
                if(set.contains(t.charAt(i))){
                    return false;
                }
                map.put(ch,t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}