class Solution {
    // j i
    // A A A C A A A A
    // A A A A 
    //[       ]
    //https://www.youtube.com/watch?v=JoF0Z7nVSrA
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle) || needle.equals("")) return 0;
        int n = needle.length();
        int h = haystack.length();
        int[] lps = new int[n];
        int i = 1;
        int j = 0;
        while(i < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                lps[i++] = ++j;
            }else if(j == 0){
                lps[i++] = 0;
            }else{
                j = lps[j-1];
            }
        }
        i = 0;
        j = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                ++i;++j;
            }else{
                if(j == 0){
                    ++i;
                }else
                    j = lps[j-1];
            }
            if(j == needle.length()) return i - needle.length();
        }
        return -1;
    }
}
