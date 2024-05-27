package Top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TowSum {
    public static int[] findPairBruteforce(int[] arr,int n, int target){
        int[] res = new int[2];

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] + arr[j] == target ){
                    res[0] = arr[i];
                    res[1] = arr[j];
                    break;
                }
            }
        }



        return res;
    }


    public static int[] twoSumSorting(int[] arr, int n, int target){
        int[] res = new int[2];
        Arrays.sort(arr);
        int low = 0;
        int high = n-1;

        while(low <= high){
            if(arr[low] + arr[high] == target ){
                res[0] = arr[low];
                res[1] = arr[high];
                break;
            }else if (arr[low] + arr[high] > target){
                high--;
            }
            else{
                low++;
            }
        }


        return res;
    }


    public static int[] findPairHashmap(int[] arr,int n,int target){
        int[] res = new int[2];

        Map<Integer,Integer> map = new HashMap<>();

        for(int num: arr){
            int val = target - num;
            if(map.containsKey(num)){
                res[0] = num;
                res[1] = map.get(num);
                break;
            }
            else{
                map.put(val,num);
            }
        }



        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {8,7,2,5,3,1};
        int target = 9;

        System.out.println(Arrays.toString(findPairBruteforce(arr, n, target)));
        System.out.println(Arrays.toString(twoSumSorting(arr,n,target)));
        System.out.println(Arrays.toString(findPairHashmap(arr,n,target)));
    }
}
