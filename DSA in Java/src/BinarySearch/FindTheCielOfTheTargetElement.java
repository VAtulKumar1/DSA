package BinarySearch;
// find the ciel of the target element if element is present then return the element
// return the smallest element that is greater than the target element
public class FindTheCielOfTheTargetElement {

    public static int findCiel(int[] nums,int start,int end,int target){
        int res = -1;
        while (start <= end) {
            int mid = start + (end -start) / 2;
            if( target == nums[mid]){
                res = nums[mid];
                return res;

            }
            else if( target < nums[mid]){
                res = nums[mid];
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }



        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,10,20,21,25,29};
        int len = nums.length;
        int target = 23;

        int res = findCiel(nums,0,len-1,target);
        System.out.println(res);

    }
}
