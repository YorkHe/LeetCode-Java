package N253_Meeting_RoomsII;

import java.util.*;


public class Solution {
    public int minMeetingRooms(Interval[] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        int max_room = 0;

        ArrayList<Interval> q = new ArrayList<>();

        for (Interval interval: intervals) {
            System.out.println(interval.start);
            System.out.println(interval.end);
            q.removeIf(a->a.end <= interval.start);
            q.add(interval);

            if (q.size() > max_room) max_room = q.size();
        }
        return max_room;
    }
}
