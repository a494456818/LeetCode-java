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
        head = new Solution().reverseKGroup(head, 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 时间复杂度：O(n*k)
    // 空间复杂度：O(n)
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLinkedListLen(head);
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode[] listNodes = new ListNode[k];
        while (len >= k) {
            ListNode q = p.next;
            // 遍历要交换顺序的结点
            for (int i = 0; i < k; i++) {
                listNodes[i] = q;
                q = q.next;
            }
            // 交换顺序
            for (int i = 0; i < k; i++) {
                if (i == 0) { // 为最后一个
                    listNodes[i].next = q;
                } else {
                    listNodes[i].next = p.next;
                    p.next = listNodes[i];
                }
            }
            p = listNodes[0]; // 为0时是翻转到最后一个元素
            len -= k;
        }
        ListNode resNode = dummyHead.next;
        dummyHead.next = null;
        return resNode;
    }

    public int getLinkedListLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
