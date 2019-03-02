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
        p = head;
        new Solution().deleteNode(p);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null)
            node = null;
        else {
            node.val = node.next.val;
            ListNode deleteNode = node.next;
            node.next = deleteNode.next;
            deleteNode.next = null;
        }
        return ;
    }

}
