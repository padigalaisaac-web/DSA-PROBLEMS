class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 1. Reach the node just before the 'left' position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 2. Reverse sublist in-place
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextTemp = curr.next;
            curr.next = nextTemp.next;
            nextTemp.next = prev.next;
            prev.next = nextTemp;
        }

        return dummy.next;
    }
}