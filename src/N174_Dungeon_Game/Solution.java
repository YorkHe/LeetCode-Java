package N174_Dungeon_Game;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;

        int[][] score = new int[M][N];
        int[][] peak = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int score_up = 0;
                int peak_up = 0;
                int score_left = 0;
                int peak_left = 0;

                if (i == 0 && j == 0) {
                    score[i][j] = dungeon[i][j];
                    peak[i][j] = dungeon[i][j];
                    continue;
                }

                if (i == 0) {
                    score_up = Integer.MIN_VALUE;
                    peak_up = Integer.MIN_VALUE;
                } else {
                    score_up = score[i-1][j];
                    peak_up = peak[i-1][j];
                }

                if (j == 0) {
                    score_left = Integer.MIN_VALUE;
                    peak_left = Integer.MIN_VALUE;
                } else {
                    score_left = score[i][j-1];
                    peak_left = peak[i][j-1];
                }

                if (peak_left > peak_up) {
                    score[i][j] = dungeon[i][j] + score_left;
                    peak[i][j] = Integer.min(score[i][j], peak_left);
                } else {
                    score[i][j] = dungeon[i][j] + score_up;
                    peak[i][j] = Integer.min(score[i][j], peak_up);
                }
                System.out.printf("%d %d %d %d\n", score_up, score_left, peak[i][j], score[i][j]);
            }
        }

        System.out.println();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%d ",peak[i][j]);
            }
            System.out.println();
        }

        int result = peak[M-1][N-1];

        if (result < 0) {
            return -result + 1;
        } else {
            return 1;
        }
    }

    static public void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.calculateMinimumHP(new int[][] {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }
}
