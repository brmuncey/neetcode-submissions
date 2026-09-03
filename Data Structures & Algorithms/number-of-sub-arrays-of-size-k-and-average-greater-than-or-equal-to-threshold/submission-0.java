class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0, l=0, avg=0, count=0;
        for(int r=0; r<arr.length; r++){
            sum += arr[r];
            if(r >= k - 1){
                avg = sum / k;
                if(avg >= threshold) count++;
                sum -= arr[l++];
            }
        }
        return count;
    }
}