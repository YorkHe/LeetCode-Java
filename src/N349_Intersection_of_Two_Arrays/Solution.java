package N349_Intersection_of_Two_Arrays;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map1 = new HashMap<>();
        HashMap<Integer, Boolean> map2 = new HashMap<>();

        if (nums1.length == 0 || nums2.length == 0) return new int[0];

        for (int i = 0; i < nums1.length; i++) {
            map1.putIfAbsent(nums1[i], true);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            boolean v = map1.getOrDefault(nums2[i], false);
            if (v) {
                map2.putIfAbsent(nums2[i], true);
            }
        }

        for (Map.Entry<Integer, Boolean> e: map2.entrySet()) {
            if (e.getValue()) {
                result.add(e.getKey());
            }
        }

        int[] returnArray = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            returnArray[i] = result.get(i);
        }

        return returnArray;
    }
}
