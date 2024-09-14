package BinarySearch.BinarySearchOnAnswer;

public class PeakElement {


    public static int findPeakElement(int[] nums,int start,int end){
        while(start <= end){
            // find the middle elemnent
            int mid = start + ( end - start ) / 2;
            //exclude the edge cases
            if(mid > 0 && mid < nums.length -1 ){
                // if nums[mid] is the peak element
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[ mid + 1]){
                    return mid;
                }
                // if peak element can be at mid -1
                else if (nums[mid-1] > nums[mid]){
                    end = mid - 1;
                }
                // if peak element can be at mid + 1
                else if (nums[mid + 1] > nums[mid]){
                    start = mid + 1;
                }

            }
            // if nums[0] is the peak element
            else if( mid == 0){
                if(nums[1] > nums[0]){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            // if nums[nums.length -1] is the peak element
            else if( mid == nums.length -1 )
            {
                if(nums[mid - 1] > nums[mid]){
                    return mid - 1;
                }
                else{
                    return mid;
                }
            }
        }
        // if there are no peak element
        return -1;
    }




    public static void main(String[] args){
        int[] nums = {5,10,14,19,16,17};
        int len = nums.length;
        int res = findPeakElement(nums,0,len-1);
        System.out.println(res);
    }


}
