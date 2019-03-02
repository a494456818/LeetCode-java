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
        int[] arrays1 = {1, 2, 4};
        int[] arrays2 = {1, 3, 4};

        ListNode l1 = Solution.createLinkedList(arrays1), l2 = Solution.createLinkedList(arrays2);

        ListNode head = new Solution().mergeTwoLists(l1, l2);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode createLinkedList(int[] arrays) {
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
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = l1;
        ListNode cur = dummyHead;
        while (l2 != null) {
            ListNode p = l2.next;
            if (cur.next == null) { // 不比大小，直接往后插入
                l2.next = null;
                cur.next = l2;
                l2 = p;
            } else {
                if (cur.next.val >= l2.val) {
                    l2.next = cur.next;
                    cur.next = l2;
                    l2 = p;
                }
            }
            cur = cur.next;
        }
        ListNode head = dummyHead.next;
        dummyHead = null;
        return head;
    }
}
