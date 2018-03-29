package N141_Linked_List_Cycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == head) return true;
        ListNode next = head.next;
        head.next = head;
        return hasCycle(next);
    }
}
