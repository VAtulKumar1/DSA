class Solution {
    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;

        int[] output = new int[n*2];

        for(int i=0;i<n;i++){
            output[i] = nums[i];

        }
        int index = n;
        for(int num: nums){
            int reversedInt = 0;
            while(num>0){
                int rem = num%10;
                reversedInt =reversedInt*10 + rem ;

                num /= 10;
                
            }

            output[index] = reversedInt;
            index++;



        }

        HashSet<Integer> set = new HashSet<>();

        for(int num: output){
            set.add(num);
        }


        return set.size();



        
    }
}