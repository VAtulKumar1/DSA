package DP.KnapSack.knapsack01;

public class KnapsackParent {
    public static  int knapsack(int[] cost,int[] values,int W,int n){
        if(n == 0 || W == 0){
            return 0;
        }

        if(values[n-1] <= W){
            return Math.max(cost[n-1]+knapsack(cost,values,W-values[n-1],n-1),
                    knapsack(cost,values,W,n-1));
        }
        else if(values[n-1] > W){
            return knapsack(cost,values,W,n-1);
        }

        return 0;
    }

    public static  int knapsackMemoization(int[] cost,int[] values,int W,int n,int[][] t){
        if(n == 0 || W == 0){
            return 0;
        }

        if(t[n-1][W-1] != -1){
            return t[n-1][W-1];
        }

        if(values[n-1] <= W){
            t[n-1][W-1] =  Math.max(cost[n-1]+knapsack(cost,values,W-values[n-1],n-1),
                    knapsack(cost,values,W,n-1));
            return t[n-1][W-1];
        }
        else if(values[n-1] > W){
            t[n-1][W] = knapsack(cost,values,W,n-1);
            return  t[n-1][W];
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] cost = { 1 , 2 , 3 , 5};
        int[] values = {1 , 2 , 5 , 7};
        int W = 7;
        int n = 4;

        int[][] t = new int[n][W];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W ; j++) {
                t[i][j] = -1;

            }

        }
        int res = knapsackMemoization(cost,values,W,n,t);

        System.out.println(res);


    }
}
