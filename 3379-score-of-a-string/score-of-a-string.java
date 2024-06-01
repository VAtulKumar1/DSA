class Solution {
    public int scoreOfString(String s) {
        int first = s.charAt(0)-'a';
        int sum = 0;
        for(int i=1;i<s.length();i++){
            int second = s.charAt(i)-'a';

            sum += Math.abs(first-second);
            first = second;

        }

        return sum;
        
    }
}