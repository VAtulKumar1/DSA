package BinarySearch;

public class FindTheMinimumElementInSortedRotatedArray {

    public static int findMinimum(int[] nums,int start,int end,int n){
        while(start<=end){
            int mid = start + (end - start) / 2;
            int next = (mid+1) % n;
            int prev = (mid + n -1 ) % n;

            if(nums[mid] < nums[next] && nums[mid] < nums[prev]){
                return mid;
            }
            else if ( nums[start] <= nums[mid]){
                start = mid + 1;
            }
            else if(nums[mid] <= nums[end]){
                end = mid -1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {80,70,20,30,40,50};
        int res = -1;
        int len = nums.length;

        res = findMinimum(nums,0,len-1,len);
        System.out.println(res);
    }
}
