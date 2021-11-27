class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int r = 0;
        int x = 0 ; 
        int y = 0 ;
        for(int i = 0 ; i < s.length()*2 - 1; ++i){
            x = i/2;
            y = (i+1)/2;
            while(x >= 0 && y < s.length() && s.charAt(x) == s.charAt(y)){
                --x;
                ++y;
                ++r;
            }
        }
        return r;
    }
}
