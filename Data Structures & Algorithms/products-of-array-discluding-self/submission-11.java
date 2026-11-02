class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] right=new int[n], left = new int[n];

        int prod=1;
        for(int i=0; i<n; i++){
            prod *= nums[i];
            left[i] = prod;
        }

        prod = 1;
        for(int i=n-1; i>=0; i--){
            prod *= nums[i];
            right[i] = prod;
        }

        for(int i=0; i<n; i++){
            if(i==0){
                nums[i] = right[i+1];
            } else if(i + 1 == n){
                nums[i] = left[i-1];
            } else {
                nums[i] = left[i-1] * right[i+1];
            }
        }
        
        return nums;
    }
}  
