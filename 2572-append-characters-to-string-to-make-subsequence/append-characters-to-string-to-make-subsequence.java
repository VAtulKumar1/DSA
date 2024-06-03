class Solution {
    public int appendCharacters(String s, String t) {


        int index = 0;
        int start = 0;
        while(index < t.length() && start < s.length()){
            
            if(t.charAt(index) == s.charAt(start)){
                start++;
                index++;
            }
            else{
                start++;
            }
           
        }

        return t.length()-index;
        
    }
}