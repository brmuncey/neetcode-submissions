class Solution {
    public int[] productExceptSelf(int[] nums) {
        int k = nums.length;
        int[] left = new int[k], right = new int[k], res = new int[k];

        int prod = 1;
        for(int i=0; i<k; i++){
            prod *= nums[i];
            left[i] = prod;
        }

        prod = 1;
        for(int i=k-1; i>=0; i--){
            prod *= nums[i];
            right[i] = prod;
        }

        for(int i=0; i<k; i++){
            if(i==0) {
                res[i] = right[i+1];
            } else if(i == k - 1){
                res[i] = left[i-1];
            } else {
                res[i] = left[i-1] * right[i+1];
            }
        }

        return res;
    }
}  
