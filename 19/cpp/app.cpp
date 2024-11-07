#include <stdio.h>
#include <iostream>

using namespace std;

struct ListNode
{
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
      ListNode* p = head;
      ListNode* q = head;
      int c = 0;
      while(p->next) {
        p = p->next;
        if(c>=n) q = q->next;
        c++;
      }
      if(c<n) return head->next;
      q->next = q->next->next;
      return head;
    }
};

