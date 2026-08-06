class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        String[] words = s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            }else{
                if(set.contains(words[i])){
                    return false;
                }else{
                    map.put(pattern.charAt(i),words[i]);
                    set.add(words[i]);
                }
            }
        }
        return true;
    }
}