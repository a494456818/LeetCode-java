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
        int[] arrays = {5, 4, 3, 2, 1};
        ListNode head = null;
        for (int i = 0; i < arrays.length; i++) {
            if (head == null) {
                head = new ListNode(arrays[i]);
            } else {
                ListNode p = new ListNode(arrays[i]);
                p.next = head;
                head = p;
            }
        }
        Solution solution = new Solution();
        head = solution.reverseList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
