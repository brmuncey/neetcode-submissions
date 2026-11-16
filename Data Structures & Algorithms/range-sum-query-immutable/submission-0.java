class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            sums[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        int rv = this.sums[right];
        int lv = left == 0 ? 0 : this.sums[left - 1];
        return rv - lv;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */