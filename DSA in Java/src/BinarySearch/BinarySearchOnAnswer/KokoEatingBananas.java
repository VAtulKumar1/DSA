package BinarySearch.BinarySearchOnAnswer;

public class KokoEatingBananas {
    public static  boolean isValid(int[] piles,int max,int h){
        int currentH = 0;

        for (int pile : piles) {
            currentH += pile / max;;
            if (pile % max != 0) currentH++;
            if (currentH > h) {
                return false;
            }
        }

        return true;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int start = Integer.MAX_VALUE;
        int end = 0;
        int res = -1;
        for(int i =0;i<piles.length;i++){
            start = Math.min(start,piles[i]);
            end += piles[i];
        }

        while(start <= end){
            int mid = start + (end - start ) / 2;
            if(isValid(piles,mid,h)){
                res = mid;
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }


        return res;



    }

    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int h = 8;
        int res = minEatingSpeed(piles,h);
        System.out.println(res);
    }
}
