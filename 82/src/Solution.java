import java.util.HashMap;
import java.util.Map;

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
        int[] arrays = {1, 1, 1, 2, 3};
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
        head = new Solution().deleteDuplicates(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        Map<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            map.put(p.val, map.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            int key = cur.val;
            int value = map.get(key);
            if (value != 1) { // 出现重复
                if (pre != null)
                    pre.next = cur.next;
                cur = cur.next;
            } else { // 没有重复
                if (pre == null) {
                    head = cur;
                }
                pre = cur;
                cur = cur.next;
            }
        }
        if (pre == null) // [1,1]用例的情况，说明用例中全是重复。
            return null;
        return head;
    }

}
