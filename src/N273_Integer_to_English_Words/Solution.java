package N273_Integer_to_English_Words;

public class Solution {


    String words[] = {
            "",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };

    String tens[] = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety",
    };


    public String ThousandNumberToWords(int num) {

        String ret = "";

        if (num >= 100) {
            int hundred = num / 100;
            ret += words[hundred] + " Hundred ";
            num = num % 100;
        }

        if (num >= 20) {
            int ten = num / 10;
            ret += tens[ten] + " ";
            num = num % 10;
            if (num != 0) {
                ret += words[num] + " ";
            }
            return ret;
        }

        if (num != 0)
        ret += words[num] + " ";

        return ret;
    }

    public String numberToWords(int num) {

        if (num == 0) return "Zero";

        String ret = "";

        if (num >= 1000000000) {
            ret += ThousandNumberToWords(num / 1000000000) + "Billion ";
            num = num % 1000000000;
        }

        if (num >= 1000000) {
            ret += ThousandNumberToWords(num / 1000000) + "Million ";
            num = num % 1000000;
        }

        if (num >= 1000) {
            ret += ThousandNumberToWords(num / 1000) + "Thousand ";
            num = num % 1000;
        }

        ret += ThousandNumberToWords(num);
        return ret.trim();
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.numberToWords(123));
        System.out.println(s.numberToWords(12345));
        System.out.println(s.numberToWords(1234567));
        System.out.println(s.numberToWords(1234567891));
    }
}
