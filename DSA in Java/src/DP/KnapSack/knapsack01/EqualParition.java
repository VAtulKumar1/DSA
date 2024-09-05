package DP.KnapSack.knapsack01;

public class EqualParition {

    public static boolean partition(int[] arr,int sum, int n){

        boolean[][] t = new boolean[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i == 0){
                    t[i][j] = false;
                }
                if(j == 0){
                    t[i][j] = true;
                }



            }

        }

        for (int i = 1; i < n + 1; i ++) {
            for (int j = 0; j < sum + 1; j ++) {
                if(j >= arr[i-1]) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }

        }


        return t[n][sum];
    }

    public static void main(String[] args) {

        int[] arr = {2,5,9,15};
        int len = arr.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum += arr[i];
        }

        System.out.println(sum/2);

        if(sum % 2 != 0 ){
            System.out.println("false");
        }else{
            boolean res = partition(arr,sum/2,len);
            System.out.println(res);
        }




    }
}
