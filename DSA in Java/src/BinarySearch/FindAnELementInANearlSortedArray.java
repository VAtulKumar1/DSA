package BinarySearch;

// input array is nearly sorted and if an element was supposed to be at position
// i then it can be at either i-1 or at i + 1
public class FindAnELementInANearlSortedArray {

    public static int findPosition(int[] nums , int start,int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }else if( target == nums[mid - 1]
                    ){
                return mid -1;
            }
            else if(target == nums[mid + 1]){
                return mid + 1;
            }
            else if( target < nums[mid]){
                end = mid -2;
            }
            else {
                start = mid + 2;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,2,4,3,5,7,10};
        int len = nums.length;
        int target = 4;

        int res = findPosition(nums,0,len-1,target);
        System.out.println(res);


    }
}
