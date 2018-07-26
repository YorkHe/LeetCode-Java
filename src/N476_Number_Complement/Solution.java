package N476_Number_Complement;

public class Solution {
    public int findComplement(int num) {
        int leading_zero = Integer.numberOfLeadingZeros(num);
        return ~(num << leading_zero) >> leading_zero;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findComplement(1));
        System.out.println(s.findComplement(5));
    }
}
