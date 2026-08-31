class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, product = 1;
        int[] left = new int[n];
        for(int i=0 ; i<n ; i++){
            product = nums[i] * product;
            left[i] = product;
        }

        product = 1;
        int[] right = new int[n];
        for(int i=n-1 ; i >= 0 ; i--){
            product = nums[i] * product;
            right[i] = product;
        }


        int[] result = new int[n];
        for(int i=0 ; i<n ; i++){
            if(i > 0 && i < n - 1){
                result[i] = left[i-1] * right[i+1];
            } else if(i ==0 ) {
                result[i] = right[i+1];
            } else if(i == n - 1){
                result[i] = left[i-1];
            }
        }

        return result;
    }
}  
