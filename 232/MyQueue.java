import java.util.Stack;

class MyQueue {
  Stack<Integer> S1;
  Stack<Integer> S2;
  public MyQueue() {
    this.S1 = new Stack<Integer>();
    this.S2 = new Stack<Integer>();
  }
  
  public void push(int x) {
    if(S1.empty()){
      S1.push(x);
      return;
    }
    while (S1.isEmpty()==false) {
      S2.push(S1.pop());
    }
    S1.push(x);
    while (S2.isEmpty()==false) {
      S1.push(S2.pop());
    }
  }
  
  public int pop() {
    return S1.pop();
  }
  
  public int peek() {
    return S1.peek();
  }
  
  public boolean empty() {
    return S1.isEmpty();
  }
}

/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/