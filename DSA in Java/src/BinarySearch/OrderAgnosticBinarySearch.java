package BinarySearch;

public class OrderAgnosticBinarySearch {

    public static int descendingBinarySearch(
            int[] nums ,
            int start,
            int  end ,
            int target
    ){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                end = mid - 1 ;

            }
            else{
                start = mid + 1;
            }
        }

        return -1;

    }

    public static int ascendingOrderBinarySearch(
            int[] nums ,
            int start,
            int  end ,
            int target
    ){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;

            }
            else{
                start = mid + 1;
            }
        }

        return -1;

    }


    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50,60,69,70};
        int res = -1;
        int target = 69;
        int len = nums.length;
        if(len == 1 && nums[0] == target){
            res = 0;
        }
        else{
            if(nums[0] > nums[len-1]){
                res = descendingBinarySearch(nums,0,len-1,target);
            }else{
                res = ascendingOrderBinarySearch(nums,0,len-1,target);
            }
        }
        System.out.println(res);
    }
}
