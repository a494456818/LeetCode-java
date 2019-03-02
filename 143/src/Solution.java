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
        new Solution().reorderList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // 以下情况head结点的数量>=3
        ListNode dummyList = new ListNode(-1);
        dummyList.next = head;
        ListNode p = dummyList;
        ListNode q = dummyList;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        ListNode leftNode = dummyList.next;
        ListNode midNode = null;
        ListNode rightNode = null;
        if (q.next == null) { // 偶数
            rightNode = p.next;
            p.next = null;
        } else if (q.next.next == null) { // 奇数个
            midNode = p.next;
            rightNode = midNode.next;
            midNode.next = null;
            p.next = null;
        }
        // 翻转右边
        ListNode dummyRightHead = new ListNode(-1);
        while (rightNode != null) {
            ListNode temp = rightNode;
            rightNode = rightNode.next;
            temp.next = dummyRightHead.next;
            dummyRightHead.next = temp;
        }
        rightNode = dummyRightHead.next;
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (leftNode != null) {
            ListNode node1 = leftNode;
            ListNode node2 = rightNode;
            leftNode = leftNode.next;
            rightNode = rightNode.next;
            node2.next = midNode;
            node1.next = node2;
            temp.next = node1;
            temp = node2;
        }
        head = dummyHead.next;
    }
}
