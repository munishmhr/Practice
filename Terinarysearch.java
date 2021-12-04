/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return ternary(1 , n);
    }
    
    private int ternary(int l , int r){
        int m1 = l + (r-l)/3;
        int m2 = m1 + (r-l)/3;
        if(guess(m1) == 0) return m1;
        if(guess(m2) == 0) return m2;
        if(guess(m1) == -1) return ternary(l , m1-1);
        if(guess(m2) == 1) return ternary(m2+1 , r);
        return ternary(m1+1 , m2-1);
    }
}
