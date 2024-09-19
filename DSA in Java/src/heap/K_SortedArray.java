package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_SortedArray {
    public static int[] sort(int[] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[nums.length];
        int index = 0;
        for (int num : nums){
            pq.add(num);
            if(pq.size() > k){
                res[index++] = pq.poll();
            }
        }

        for(int num : pq){
            res[index++] = num;
        }

        return res;
    }

    public static void main(String[] args){
        int[] nums = {6,5,3,2,8,10,9};
        int k = 3;
        int[] res = sort(nums,k);
        System.out.println(Arrays.toString(res));
    }
}
