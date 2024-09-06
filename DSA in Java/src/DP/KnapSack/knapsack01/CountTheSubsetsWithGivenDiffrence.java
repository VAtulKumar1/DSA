package DP.KnapSack.knapsack01;

public class CountTheSubsetsWithGivenDiffrence {

    public static int count(int[] arr,int n,int sum){
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[ i - 1] <= j ){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }

            }

        }

        return t[n][sum];
    }

    public static void main(String[] args){
        int[] arr = {1 , 1, 2 ,3};
        int n = arr.length;
        int diff = 1;

        int range = 0;

        for(int i = 0;i < n; i ++){
            range += arr[i];
        }

        int sum = (diff + range) / 2;

        int res = count(arr, sum , n );
        System.out.println(res);




    }
}
