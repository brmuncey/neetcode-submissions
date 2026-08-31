class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        int j=n-1, cur=-1;
        for(int i=n-2; i>=0; i--){
            if(cur < arr[j]) cur = arr[j];
            res[i] = cur;
            j--;
        }
        return res;
    }
}