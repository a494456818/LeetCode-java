import java.util.List;

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
        head = new Solution().oddEvenList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddNodes = head; // 奇结点
        ListNode evenNodes = head.next; // 偶结点
        ListNode evenHeader = head.next; // 偶结点的头结点
        ListNode p = evenNodes.next; // 从第三个结点开始遍历
        int i = 3; // 从第三个结点开始
        while (p != null) {
            if (i % 2 != 0) { // 奇数结点
                oddNodes.next = p;
                oddNodes = oddNodes.next;
            } else { // 偶数结点
                evenNodes.next = p;
                evenNodes = evenNodes.next;
            }
            p = p.next;
            i ++;
        }
        oddNodes.next = evenHeader;
        evenNodes.next = null;
        return head;
    }
}
