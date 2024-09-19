package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int findElement(int[] nums,int k){
        // k and smallest design a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums){
            // add elements to heap
            pq.add(num);
            // if size of the heap is greater than k then remove top element
            if(pq.size()>k){
                pq.poll();
            }

        }
        int res = -1;

        if(!pq.isEmpty()){
            res = pq.peek();
        }
        return res;

    }

    public static void main(String[] args){
        int[] nums = {7,10,2,4,6,20};
        int k = 3;
        int res = findElement(nums,k);
        System.out.println(res);
    }
}
