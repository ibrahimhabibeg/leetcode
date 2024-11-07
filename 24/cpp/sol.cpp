#include <bits/stdc++.h>

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
  ListNode *swapPairs(ListNode *head)
  {
    if (!head || !head->next)
      return head;
    ListNode *p = NULL, *f = head, *s = head->next, *r = head->next;
    while (s)
    {
      if (p)
        p->next = s;
      f->next = s->next;
      s->next = f;
      p = f;
      f = f->next;
      s = f ? f->next : NULL;
    }
    return r;
  }
};