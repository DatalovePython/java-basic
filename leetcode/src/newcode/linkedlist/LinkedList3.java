package newcode.linkedlist;

import node.ListNode;

/**
 * @author luzc
 * @date 2020/10/20 10:23
 * @desc
 */
public class LinkedList3 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
