class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int al=0, ar=abbr.length(), wl=0, wr=word.length();

        while(wl < wr && al < ar){
            if(Character.isLetter(abbr.charAt(al))){
                if(word.charAt(wl) == abbr.charAt(al)){
                    wl++;
                    al++;
                } else {
                    return false;
                }
            } else {
                if(abbr.charAt(al) == '0') return false;
                int sub = 0;
                while(al < ar && Character.isDigit(abbr.charAt(al))){
                    sub = sub * 10 + (abbr.charAt(al) - '0');
                    al++;
                }
                wl += sub;
            }
        }

        return wl == wr && al == ar;
    }
}