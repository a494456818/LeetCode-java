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
        int[] arrays = {-1, 5, 3, 4, 0};
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
        head = new Solution().insertionSortList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public ListNode insertionSortList(ListNode head) {
        ListNode header = new ListNode(-1);
        while (head != null) {
            ListNode insertNode = head;
            head = head.next;
            if (header.next == null) { // 当前序列是空
                insertNode.next = null;
                header.next = insertNode;
            } else {
                ListNode p = header;
                // 查找应该插入的位置
                while (p.next != null && p.next.val < insertNode.val)
                    p = p.next;
                insertNode.next = p.next;
                p.next = insertNode;
            }
        }
        ListNode resNode = header.next;
        header.next = null;
        return resNode;
    }
}
