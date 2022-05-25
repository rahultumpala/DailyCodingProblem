package DCP;

 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

/*
        --------- Question: ---------
Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

        --------- End Question ---------
*/


public class DCP20 {

        // Time complexity - O(M+N)
        // Space Complexity - O(1) - Constant, since only lengths are stored for any list
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int l1 =0, l2= 0;
            l1 = getLength(headA);
            l2 = getLength(headB);
            if(l1 > l2){
                while(l1 > l2){
                    headA = headA.next;
                    l1--;
                }
            }
            if(l1 < l2){
                while(l1 < l2){
                    headB = headB.next;
                    l2--;
                }
            }
            while(headA != headB){
                headA = headA.next;
                headB = headB.next;
            }
            if(headA == headB) return headA;
            else return null;
        }

        public int getLength(ListNode head){
            int l = 0;
            while(head != null){
                l++;
                head = head.next;
            }
            return l;
        }

}
