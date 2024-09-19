package heap;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class K_LargestElementsInAHeap {

    public static PriorityQueue<Integer> findLargestElements(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq;
    }

    public static void main(String[] args) {
        int[] nums = {7,10,2,4,6,20};
        int k = 3;
        PriorityQueue<Integer> q = findLargestElements(nums,k);
        List<Integer> res = q.stream().toList();
        System.out.println(res);

    }
}
