package N88_Merge_Sorted_Array;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] t = new int[m + n];

        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                t[i] = nums1[p1];
                i++; p1++;
            } else {
                t[i] = nums2[p2];
                i++; p2++;
            }
        }

        while (p1 < m) t[i++] = nums1[p1++];
        while (p2 < n) t[i++] = nums2[p2++];

        for (i = 0; i < t.length; i++) {
            nums1[i] = t[i];
        }
    }
}
