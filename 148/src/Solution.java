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
        int[] arrays = {5, -1, 3, 4, 0};
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
        head = new Solution().sortList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null) // 只有一个元素，不需要排序了
            return head;
        ListNode left = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode p = head;
        // 执行while后，cur指向中间节点，pre指向cur的前一个节点
        while (p != null && p.next != null) {
            pre = cur;
            cur = cur.next;
            p = p.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(left);
        ListNode r = mergeSort(cur);
        return merge(l, r);

    }

    // 合并左边和右边
    ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(-100);
        ListNode cur = dummyHead;
        while(l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null)
            cur.next = l;
        if (r != null)
            cur.next = r;

        return dummyHead.next;
    }
}
