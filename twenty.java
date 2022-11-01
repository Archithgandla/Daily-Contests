//2095. Delete the Middle Node of a Linked List

  //Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        
        if(head == null || head.next == null)
            return null;
        
        ListNode fast = head,slow = head,prev = null;
        
        //Finding the middle node
        //slow pointer obtains the middle node
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = prev.next.next;
        return head;
    }
}
