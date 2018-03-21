package N66_Plus_One;

public class Solution {
    public int[] plusOne(int[] digits) {

        digits[digits.length-1] += 1;

        int lastCarry = 0;

        for (int i = digits.length -1; i >=0; i--) {
            if (digits[i] >= 10) {
                digits[i] -= 10;
                if (i > 0) {
                    digits[i-1] += 1;
                } else {
                    lastCarry = 1;
                }
            }
        }

        if (lastCarry == 1) {
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                ans[i+1] = digits[i];
            }
            return ans;
        }

        return digits;
    }
}
