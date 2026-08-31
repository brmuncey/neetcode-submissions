class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        int product = 1;
        for(int i=0; i<n; i++){
            product *= nums[i];
            left[i] = product;
        }

        product = 1;
        for(int i=n-1; i>=0; i--){
            product *= nums[i];
            right[i] = product;
        }

        for(int i=0; i<n ; i++){
            if(i - 1 < 0){
                result[i] = right[i+1];
            } else if(i+1 == n) {
                result[i] = left[i-1];
            } else {
                result[i] = left[i-1] * right[i+1];
            }
        }

        return result;
    }
}  
