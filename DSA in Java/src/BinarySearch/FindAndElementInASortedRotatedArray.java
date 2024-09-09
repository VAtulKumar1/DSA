package BinarySearch;

public class FindAndElementInASortedRotatedArray {

    public static int findTarget(int[] nums, int start,int end,int target){
        while(start <= end){
            int mid = start + (end - start ) / 2;
            if( target == nums[mid] )
                return mid;
            else if( nums[start] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[start] ){
                    end = mid -1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(nums[mid] <= nums[end]){
                if(target > nums[mid] && target < nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid -1;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {80,70,20,30,40,50};
        int res = -1;
        int len = nums.length;

        res = findTarget(nums,0,len-1,80);
        System.out.println(res);
    }
}
