package BinarySearch;

public class FirstAndLastOccuranceOfAnElement {

    public static int findFirstOccurance(int[] nums,
                                         int start,
                                         int end ,
                                         int target){
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }



        return end + 1;

    }

    public static int findLastOccurance(int[] nums,
                                        int start,
                                        int end,
                                        int target
    ){
        while(start <= end){
            int mid = start + (end - start) / 2 ;

            if( nums[mid] <= target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }

        }
        return end;
    }


    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50,60,60,60,60,70};
        int res = -1;
        int target = 60;
        int len = nums.length;

//        res = findFirstOccurance(nums,
//                0,
//                len-1,
//                target);
        res = findLastOccurance(nums,
                0,
                len-1,
                target);

        System.out.println(res);
    }
}
