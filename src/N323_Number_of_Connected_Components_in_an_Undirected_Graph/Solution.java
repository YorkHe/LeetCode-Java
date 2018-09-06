package N323_Number_of_Connected_Components_in_an_Undirected_Graph;

import java.util.*;

public class Solution {

    Integer[] colors = new Integer[65536];
    void dfs(int n, int color, int[][] edges) {
        colors[n] = color;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == n && colors[edges[i][1]] != color) {
                dfs(edges[i][1], color, edges);
            } else if (edges[i][1] == n && colors[edges[i][0]] != color) {
                dfs(edges[i][0], color, edges);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        Arrays.fill(colors, -1);

        int colorCount = 0;

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                colorCount += 1;
                dfs(i, colorCount, edges);
            }
        }

        return colorCount;
    }
}
