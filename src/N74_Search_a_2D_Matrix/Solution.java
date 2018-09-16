package N74_Search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) return false;
        int width = matrix[0].length;
        if (width == 0) return false;

        if (matrix[0][0] > target) return false;
        if (matrix[height - 1][width - 1] < target) return false;

        int line = 0;
        for (line = 0; line < height; line ++) {
            if (matrix[line][0] <= target  && matrix[line][width - 1] >= target) break;
        }

        if (line == height) return  false;

        int row = 0;

        for (int i = 0; i < width; i++) {
            if (matrix[line][i] == target) return true;
        }

        return false;
    }
}
