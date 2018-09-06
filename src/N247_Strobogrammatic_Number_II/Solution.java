package N247_Strobogrammatic_Number_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> output = new ArrayList<>();

    char[] strobo_numbers = {'0', '1', '6', '8', '9'};
    char[] strobo_number_revert = {'0','1', '9', '8', '6'};

    StringBuffer number;

    public void dfs(int n, int index) {

        if (index == n/2) {
            if (n % 2 == 0) {
                output.add(number.toString());
                return;
            } else {

                number.setCharAt(index, '0');
                output.add(number.toString());

                number.setCharAt(index, '1');
                output.add(number.toString());

                number.setCharAt(index, '8');
                output.add(number.toString());
                return;

            }
        }

        for (int j = 0; j < 5; j++) {
            if (index == 0 && j == 0) continue;
            number.setCharAt(index, strobo_numbers[j]);
            number.setCharAt(n - 1 - index, strobo_number_revert[j]);

            dfs(n, index+1);
        }
    }

    public List<String> findStrobogrammatic(int n) {
        number = new StringBuffer(n);

        number.setLength(n);

        dfs(n, 0);

        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.findStrobogrammatic(2);
    }
}
