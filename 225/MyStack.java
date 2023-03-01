import java.util.LinkedList;
import java.util.Queue;

class MyStack {
  Queue<Integer> Q1;
  Queue<Integer> Q2;

  public MyStack() {
    this.Q1 = new LinkedList<>();
    this.Q2 = new LinkedList<>();
  }
  
  public void push(int x) {
    Q1.add(x);
  }
  
  public int pop() {
    while (Q1.size()!=1) {
      Q2.add(Q1.remove());
    }
    int x = Q1.remove();
    while (!Q2.isEmpty()) {
      Q1.add(Q2.remove());
    }
    return x;
  }
  
  public int top() {
    while (Q1.size()!=1) {
      Q2.add(Q1.remove());
    }
    int x = Q1.peek();
    Q2.add(Q1.remove());
    while (!Q2.isEmpty()) {
      Q1.add(Q2.remove());
    }
    return x;
  }
  
  public boolean empty() {
    return Q1.isEmpty();
  }
}

/**
* Your MyStack object will be instantiated and called as such:
* MyStack obj = new MyStack();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.top();
* boolean param_4 = obj.empty();
*/