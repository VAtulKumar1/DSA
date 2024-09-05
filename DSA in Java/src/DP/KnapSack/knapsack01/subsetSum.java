package DP.KnapSack.knapsack01;

import java.util.Arrays;

public class subsetSum {
    public static boolean subsetExists(int[] arr,int n,int sum,boolean[][] t){

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < sum; j++) {
                if(j >= arr[i-1]) {
                    t[i][j] = (t[i-1][j - arr[i-1]]) ||  t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }

        }



        return t[n-1][sum-1];

    }

    public static void main(String[] args) {

        int[] arr= {1,3,5,7,2};
        int sum = 27;
        boolean[][] t = new boolean[arr.length+1][sum+1];

        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i == 0){
                    t[i][j] = false;
                }
                if(j == 0){
                    t[i][j] = true;
                }

            }

        }

        System.out.println(Arrays.deepToString(t));

        boolean res = subsetExists(arr,arr.length+1,sum+1,t);
        System.out.println(res);



    }
}
