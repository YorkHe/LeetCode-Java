package N120_Triangle;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                int element = triangle.get(i).get(j);
                int up = Integer.MAX_VALUE;
                int up_left = Integer.MAX_VALUE;
                if (j > 0) {
                    up_left = triangle.get(i-1).get(j-1);
                }

                if (j < i-1) {
                    up = triangle.get(i-1).get(j);
                }

                element += Math.min(up, up_left);
                System.out.printf("%d %d %d\n", up, up_left, element);

                triangle.get(i).set(j, element);
            }
        }

        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < triangle.size(); i++) {
            int v = triangle.get(triangle.size()-1).get(i);
            minValue = Math.min(minValue, v);
        }

        return minValue;
    }
}
