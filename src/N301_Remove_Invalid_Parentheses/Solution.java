package N301_Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();

        if (s.length() == 0) {
            ret.add(s);
            return ret;
        }

        dfs(s, ret, 0, 0, '(', ')');
        return ret;
    }

    private void dfs(String s, List<String> ret, int delStart, int scanStart, char lp, char rp) {

        int cnt = 0;

        for (int i = scanStart; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == lp) {
                cnt ++;
            } else if (c == rp) {
                cnt --;
            }

            if (cnt == -1) {
                for (int j = delStart; j <= i; j++) {
                    if (s.charAt(j) == rp && (j == delStart || s.charAt(j - 1) != rp)) {
                        dfs(s.substring(0, j) + s.substring(j+1), ret, j, i, lp, rp);
                    }
                }
                return;
            }
        }

        if (lp == '(') {
            dfs(new StringBuilder(s).reverse().toString(), ret, 0, 0,  rp, lp);
        } else {
            ret.add(new StringBuilder(s).reverse().toString());
        }
    }
}
