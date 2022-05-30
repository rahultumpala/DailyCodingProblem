/*
---------Question---------
Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

--------End Question--------
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
  
    // Time Complexity - O(N) (where N = length of list, since single pass is required)
    // Space Complexity - O(1) Constant space
    // Uses a sliding window type approach
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head == nullptr) return nullptr;
        if(head->next == nullptr && n ==1) return nullptr;
        
        ListNode *first = head, *second=head, *prev=head;
        int k = 0;
        while(k++ < n-1 && second->next != nullptr)
            second = second->next;
        
        if(k == n && second->next == nullptr) // just remove the first element
            return head->next;
        
        while(second->next != nullptr){
            prev= first;
            first = first->next;
            second = second->next;
        }
        
        prev->next = first->next;
        return head;   
    }
};
