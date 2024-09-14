package BinarySearch.BinarySearchOnAnswer;

public class FindMaximumInBiotonicArray {

    public static int findMax(int[] nums,int start,int end){
        while(start <= end){
            int mid = start = (end - start)/2;

            if(mid > 0 && mid < nums.length-1 ){
                if(nums[mid] > nums[mid-1]
                        && nums[mid] > nums[mid+1]) {
                    return nums[mid];
                }
                else if (nums[mid - 1] > nums[mid]) {
                    end = mid - 1;

                }
                else if(nums[mid + 1] > nums[mid]){
                    start = mid + 1;
                }
            }
            else if ( mid == 0){
                if(nums[0] > nums[1]){
                    return nums[0];
                }
                else{
                    return nums[1];
                }
            }else if( mid == nums.length -1){
                if(nums[mid] > nums[mid - 1]){
                    return nums[mid];
                }else{
                    return nums[mid - 1];
                }
            }
        }

        return -1;

    }



    public static void main(String[] args){
        int[] nums = {1,5,7,9,6,4,2};
        int len = nums.length;

        int res = findMax(nums,0,len-1);
        System.out.println(res);
    }
}
