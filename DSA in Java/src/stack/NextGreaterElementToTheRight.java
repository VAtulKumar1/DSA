package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementToTheRight {

    public static int[] findNextGreater(int[] nums,int n){
        Stack<Integer> stack = new Stack<>();
        // traverse over nums from end to find the next greater
        for (int j = n-1; j>=0;j--){
            // because we are changing the original array storing the value for further uses
            int num = nums[j];
            if(stack.isEmpty()){
                nums[j] = -1;
            }
            else if( nums[j] < stack.peek()
            ){
                nums[j] = stack.peek();
            }
            else if( nums[j] >= stack.peek()
            ){
                while(!stack.isEmpty()
                        && nums[j] >= stack.peek()){
                    stack.pop();

                }

                if(stack.isEmpty()){
                    nums[j] = -1;
                }
                else{
                    nums[j] = stack.peek();
                }
            }

            stack.push(num);


        }

        return nums;

    }

    public static void main(String[] args){
        int[] nums = {1,3,0,0,1,2,4};
        int len = nums.length;
        int[] res = findNextGreater(nums,len);
        System.out.println(Arrays.toString(res));
    }
}
