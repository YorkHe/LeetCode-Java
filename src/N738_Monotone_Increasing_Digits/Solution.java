package N738_Monotone_Increasing_Digits;

public class Solution{

    public int monotoneIncreasingDigits(int N) {
        String SN = String.valueOf(N);

        int i;
        for (i = 1; i < SN.length(); i++) {
            char a = SN.charAt(i-1);
            char b = SN.charAt(i);

            if (a > b) {
                break;
            }

            if (i == SN.length() - 1) {
                return N;
            }
        }

        i--;
        while (i > 0 && SN.charAt(i-1) == SN.charAt(i)) {
            i--;
        }

        String result;
        result =  SN.substring(0, i);
        char c = SN.charAt(i);
        result = result + (--c);
        while (result.length() < SN.length()) {
            result = result.concat("9");
        }

        if (result.charAt(0) == '0') {
            result = result.substring(1);
        }

        return Integer.valueOf(result);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.monotoneIncreasingDigits(332));
        System.out.println(s.monotoneIncreasingDigits(1234));
    }
}
