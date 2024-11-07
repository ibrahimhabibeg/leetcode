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
  ListNode *mergeKLists(vector<ListNode *> &lists)
  {
    set<pair<int, ListNode *>> s;

    for (ListNode *p : lists)
      if (p)
        s.insert(make_pair(p->val, p));

    ListNode *resHead = new ListNode();
    ListNode *r = resHead;
    while (!s.empty())
    {
      auto [v, p] = *s.begin();
      s.erase(make_pair(v, p));
      if (p->next)
        s.insert(make_pair(p->next->val, p->next));
      r->next = p;
      r = r->next;
    }
    return resHead->next;
  }
};