// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0)
            return null;
        if (len == 1)
            return lists[0];

        while (len > 1) {
            // 经过下面一次循环后，lists还应剩余多少个元素
            len = len % 2 == 0 ? len / 2 : len / 2 + 1;
            ListNode[] listTemp = new ListNode[len];
            int j = 0;
            for (int i = 0; i < lists.length; i += 2) {
                ListNode header = new ListNode(-1);
                ListNode temp = header;
                if (i + 1 < lists.length) {
                    ListNode p = lists[i];
                    ListNode q = lists[i + 1];
                    while (p!=null && q!=null) {
                        if (p.val <= q.val) {
                            temp.next = p;
                            p = p.next;
                        } else {
                            temp.next = q;
                            q = q.next;
                        }
                        temp = temp.next;
                    }
                    while (p!=null) {
                        temp.next = p;
                        p = p.next;
                        temp = temp.next;
                    }
                    while (q!=null) {
                        temp.next = q;
                        q = q.next;
                        temp = temp.next;
                    }
                    listTemp[j++] = header.next;
                } else { // 剩余最后一个为奇数
                    listTemp[j++] = lists[i];
                }
            }
            lists = listTemp;
        }
        return lists[0];
    }
}
