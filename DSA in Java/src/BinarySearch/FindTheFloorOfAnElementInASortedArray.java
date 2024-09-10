package BinarySearch;
// find the floor of the target element if element is present then return the element
// return the greatest element that is smaller than the  target element
public class FindTheFloorOfAnElementInASortedArray {

    public static int findFloor (int[] nums, int start, int end , int target){
        int res = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target  == nums[mid])
                res = nums[mid];
            else if(target < nums[mid]){
                end = mid -1;
            }
            else {
                res = nums[mid];
                start = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,9,12,15};
        int len = nums.length;
        int target = 10;
        int res = findFloor(nums,0,len -1 ,target);
        System.out.println(res);

    }
}
