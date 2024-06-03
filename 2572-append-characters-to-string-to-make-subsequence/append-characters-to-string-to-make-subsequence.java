class Solution {
    public int appendCharacters(String s, String t) {


        int index = 0;
        int start = 0;
        int sLength = s.length();
        int tLength = t.length();
        while(index < tLength && start < sLength){
            
            if(t.charAt(index) == s.charAt(start)){
                index++;
            }
            
            start++;
           
        }

        return tLength-index;
        
    }
}