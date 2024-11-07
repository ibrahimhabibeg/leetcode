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

class Solution
{
public:
  ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
  {
    if (!list1)
      return list2;
    if (!list2)
      return list1;
    ListNode *resHead = new ListNode();
    ListNode *r = resHead;
    ListNode *p = list1;
    ListNode *q = list2;

    while (p && q)
    {
      if (p->val < q->val)
        r->next = p, p = p->next;
      else
        r->next = q, q = q->next;
      r = r->next;
    }

    if (p)
      r->next = p;
    if (q)
      r->next = q;

    return resHead->next;
  }
};