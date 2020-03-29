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
        int[] arrays = {1, 2, 3, 4, 5};
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
        head = new Solution().rotateRight(head, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) // 不翻转
            return head;
        // 求head的长度
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        k = k % len;
        if (k == 0)
            return head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        // q 向右边移动k位
        for (int i = 0; i < k; i++)
            q = q.next;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        temp = p.next;
        p.next = null;
        q.next = dummyHead.next;
        dummyHead.next = temp;
        return dummyHead.next;
    }
}
