class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;

        Set<Integer> set = new HashSet<>();
        set.add(0);

        int target = sum / 2;

        for(int i=nums.length - 1; i>= 0; i--){
            Set<Integer> next = new HashSet<>();
            for(int n : set){
                if(n + nums[i] == target) return true;
                next.add(n + nums[i]);
                next.add(n);
            }
            set = next;
        }

        return false;
    }
}
