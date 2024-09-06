package DP.KnapSack.knapsack01;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetsSumDiff {

    public static int minDiff(int[] arr,int range,int n){
        boolean [][] t = new boolean [n+1][range+1];

        for (int i = 0; i < n + 1; i++) {
            t[i][0] = true;
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < range + 1; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }

            }

        }

        List<Integer> subsetSum = new ArrayList<>();
        for (int i = 0; i < range+1; i++) {
            if(t[n][i]){
               subsetSum.add(i);
            }
        }


        int res = Integer.MAX_VALUE;
        for (int i = 0; i < subsetSum.size()/2; i++) {
            res = Math.min(res,Math.abs(range-2*subsetSum.get(i)));

        }




        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,5,9};
        int n = arr.length;

        int range = 0;

        for(int i = 0; i < n; i ++){
            range += arr[i];
        }

        int res = minDiff(arr , range , n);
        System.out.println(res);
    }


}
