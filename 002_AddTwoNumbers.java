class Solution {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     * 时间复杂度：O(max(m, n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m,n) 次。
     * 空间复杂度：O(max(m,n))， 新列表的长度最多为 max(m,n) + 1。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHeader = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, pre = preHeader;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            pre.next = new ListNode(sum % 10);
            pre = pre.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }
        return preHeader.next;
    }
}
