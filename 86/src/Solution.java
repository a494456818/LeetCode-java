// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public static void main(String[] args) {
        int[] arrays = {1, 4, 3, 2, 5, 2};
        ListNode head = null;
        ListNode p = null;
        for (int i = 0; i < arrays.length; i++) {
            if (head == null) {
                p = new ListNode(arrays[i]);
                head = p;
            } else {
                p.next = new ListNode(arrays[i]);
                p = p.next;
            }
        }
        head = new Solution().partition(head,3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);;
        ListNode right = new ListNode(-1);
        ListNode p = head, l = left, r = right;
        while(p != null) {
            if (p.val < x) {
                l.next = new ListNode(p.val);
                l = l.next;
            } else {
                r.next = new ListNode(p.val);
                r = r.next;
            }
            p = p.next;
        }
        l.next = right.next;
        return left.next;
    }
}
