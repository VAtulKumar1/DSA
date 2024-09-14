package BinarySearch.BinarySearchOnAnswer;

import java.util.Arrays;

public class SearchInASortedMatrix {


    public static int[] findTarget(int[][] matrix,int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = {-1,-1};
        int r = 0;
        int c = n-1;
        // r and c are pointing to the last element of the first row
        while((r >= 0 && r < matrix.length)
                && (c >= 0 && c < matrix[0].length))
        {
            // check target is found
            if(matrix[r][c] == target){
                res[0] = r;
                res[1] = c;
                return res;

            }
            // if target is greater than the current value;
            else if(matrix[r][c] < target){
                r++;
            }
            // if the target is less than the current element
            else {
                c--;
            }

        }

        return res;
    }



    public static void main(String[] args){
        int[][] matrix = {{10,20,30,40},
                {13,21,33,41},
                {15,23,35,45},
                {19,25,37,50}

        };
        int c =matrix[0].length;
        int target = 23;
        int[] res = findTarget(matrix,target);
        System.out.println(Arrays.toString(res));
    }
}
