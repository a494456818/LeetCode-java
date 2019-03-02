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
        int[] arrays = {2, 2, 2, 2};
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
        boolean flag = new Solution().isPalindrome(head);
        System.out.println(flag);
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
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

        while (leftNode != null) {
            if (leftNode.val == rightNode.val) {
                leftNode = leftNode.next;
                rightNode = rightNode.next;
            } else
                return false;
        }
        return true;
    }
}
