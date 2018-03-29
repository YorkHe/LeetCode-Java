package N231_Power_of_Two;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n > 0 && n % 2 == 0) {
            n = n / 2;
        }

        return n == 1;
    }
}
