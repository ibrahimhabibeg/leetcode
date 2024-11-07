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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int c = 0;
        ListNode* p = l1;
        ListNode* q = l2;
        ListNode* resHead = new ListNode();
        ListNode* r = resHead;

        while(p || q) {
          int v1 = p ? p->val : 0;
          int v2 = q ? q->val : 0;

          r->next = new ListNode((v1+v2+c)%10);
          c = (v1+v2+c) / 10;
          r = r->next;
          p = p ? p->next : p;
          q = q ? q->next : q;
        }

        if(c) {
          r->next = new ListNode(c);
        }
        return resHead->next;
    }
};

int main () {
  ListNode* l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
  ListNode* l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
  Solution sol;
  ListNode* res = sol.addTwoNumbers(l1, l2);
  while(res) {
    cout << res->val << " ";
    res = res->next;
  }
  return 0;
}