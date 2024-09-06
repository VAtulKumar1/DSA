package DP.KnapSack.unboundedKnapsack;

public class RodCuttingProlem {

    public static int maxProfit(int[] length,int[] price,int n){
        int[] t = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                if(j >= length[i-1])
                    t[i] = Math.max(price[j]+t[i],t[i-j-1]);

            }

        }

        return t[n];
    }


    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {2,2,3,7,9,10,11,12};
        int n = length.length;
        int L = 8;
        int res = maxProfit(length,price,L);
        System.out.println(res);
    }
}
