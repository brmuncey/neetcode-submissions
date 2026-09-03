class Solution {
    public int minimumRecolors(String blocks, int k) {
        int w=0,l=0, min=blocks.length() + 1;
        for(int r=0; r<blocks.length(); r++){
            if(blocks.charAt(r) == 'W') w++;

            if(r - l + 1 == k){
                min = Math.min(min, w);
                if(blocks.charAt(l) == 'W') w--;
                l++;
            }
        }
        return min;
    }
}