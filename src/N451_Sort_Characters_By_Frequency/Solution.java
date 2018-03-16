package N451_Sort_Characters_By_Frequency;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return -1 * ((Comparable) ((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o2)).getValue());
            }
        });

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.get(i).getValue(); j++) {
                result.append(list.get(i).getKey());
            }
        }

        return result.toString();
    }
}
