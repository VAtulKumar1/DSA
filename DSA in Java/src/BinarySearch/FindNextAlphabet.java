package BinarySearch;

public class FindNextAlphabet {

    public static char findNextElement(char[] chars,int start,int end,int target){
        char res = Character.MIN_VALUE;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == chars[mid]){
                res = chars[mid];
                return res;
            }
            else if(target < chars[mid]){
                res = chars[mid];
                end = mid - 1;

            }
            else{
                start = mid + 1;
            }
        }
        return res;
    }



    public static void main(String[] args){
        char[] chars = {'a','b','e','f','i'};
        int len = chars.length;
        char target = 'g';

        char res = findNextElement(chars,0,len-1,target);
        System.out.println(res);
    }
}
