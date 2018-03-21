package N357_Count_Numbers_with_Unique_Digits;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {

        if (n > 10) return 0;
        if (n == 0) return 1;

        int ans = 10;
        int t = 9;

        for (int i = 2; i <= n; i ++) {
            t = t * (11 - i);
            ans += t;
        }

        return ans;
    }
}
