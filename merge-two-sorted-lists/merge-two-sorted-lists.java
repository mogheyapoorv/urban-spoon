/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        return helper(list1, list2, result, null);
    }

    public ListNode helper(ListNode list1, ListNode list2, ListNode result, ListNode head) {
         if (list1 == null && list2 == null) {
            return head;
        }
       
        int v1 = list1 == null ? Integer.MAX_VALUE : list1.val;
        int v2 = list2 == null ? Integer.MAX_VALUE : list2.val;

        if (v1 < v2) {
            result.val = v1;
            if (list1 != null)
                list1 = list1.next;
        } else {
            result.val = v2;
            if (list2 != null)
                list2 = list2.next;
        }

        if (head == null) {
            head = result;
        }

        if (list1 != null || list2 != null)
            result.next = new ListNode();
        
        return helper(list1, list2, result.next, head);
    }
}