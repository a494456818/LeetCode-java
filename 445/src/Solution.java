import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        int[] arrays1 = {3, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] arrays2 = {7};

        ListNode l1 = Solution.createLinkedList(arrays1);
        ListNode l2 = Solution.createLinkedList(arrays2);

        ListNode head = new Solution().addTwoNumbers(l1, l2);

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

    // 时间复杂度
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 分析：考虑到案例使用大数，无法将l1和l2链表中的数据直接求和
         * 将链表更改为使用栈进行存储
         */
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode header = new ListNode(-1);
        ListNode p = null;

        // 将链表中的数据压入栈中
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int add = 0; // 求和时的进位，[0 or 1]
        // 栈不为空时进行计算
        while (!(stack1.empty() || stack2.empty())) {
            int sum = stack1.pop() + stack2.pop() + add;
            if (add == 1)
                add = 0;
            if (sum >= 10) {
                sum = sum % 10;
                add = 1;
            }
            p = header.next;
            header.next = new ListNode(sum);
            header.next.next = p;
        }
        while (!stack1.empty()) {
            int sum = stack1.pop() + add;
            if (add == 1)
                add = 0;
            if (sum >= 10) {
                sum = sum % 10;
                add = 1;
            }
            p = header.next;
            header.next = new ListNode(sum);
            header.next.next = p;
        }
        while (!stack2.empty()) {
            int sum = stack2.pop() + add;
            if (add == 1)
                add = 0;
            if (sum >= 10) {
                sum = sum % 10;
                add = 1;
            }
            p = header.next;
            header.next = new ListNode(sum);
            header.next.next = p;
        }
        if (add == 1) {
            p = header.next;
            header.next = new ListNode(1);
            header.next.next = p;
        }
        return header.next;
    }

}
