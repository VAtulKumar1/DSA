package heap;

import java.net.Inet4Address;
import java.util.*;

public class TopK_FrequentElements {

    public static List<Integer> find(int[] nums,int k){
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b)-> a.getValue()==b.getValue()
                        ?a.getValue():a.getValue()-b.getValue());

        for (int num : nums){
            if(map.containsKey(num)){
                map.put(num , map.get(num) + 1);
            }else{
                map.put(num,1);
            }

        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }

        }

        while(!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }



        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6,6,6,6,6,5,5,5,5,5,1,1,1,1,1,1,3,2,2,2,2,2,2,2,2,2,2,8,10,9};
        int k = 3;
        List<Integer> res = find(nums,k);
        System.out.println(res);
    }
}
