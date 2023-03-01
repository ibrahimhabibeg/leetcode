class Bank {
  long[] balance;
  int n;

  public Bank(long[] balance) {
    this.balance = balance;
    this.n = balance.length;
  }

  public boolean transfer(int account1, int account2, long money) {
    if (account1 < 1 || account1 > n || account2 < 1 || account2 > n || balance[account1 - 1] < money)
      return false;
    balance[account1 - 1] -= money;
    balance[account2 - 1] += money;
    return true;
  }

  public boolean deposit(int account, long money) {
    if (account < 1 || account > n)
      return false;
    balance[account - 1] += money;
    return true;
  }

  public boolean withdraw(int account, long money) {
    if (account < 1 || account > n || balance[account - 1] < money)
      return false;
    balance[account - 1] -= money;
    return true;
  }
}