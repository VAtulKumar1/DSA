package DP.KnapSack.knapsack01;

public class CountAllSubsetWithGivenSum {

    public static int count(int[] arr,int sum,int n){
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i ++) {
            for (int j = 1; j < sum + 1; j ++) {
                if( arr[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }
                else{
                    t[i][j] = t[i-1][j];
                }

            }

        }

        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2 , 3 , 5 , 6 , 8 , 10};
        int len = arr.length;
        int sum = 35;

        int res = count(arr,sum,len);
        System.out.println(res);
    }
}
