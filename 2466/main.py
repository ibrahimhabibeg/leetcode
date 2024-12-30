class Solution(object):
  def countGoodStrings(self, low, high, zero, one):
    """
    :type low: int
    :type high: int
    :type zero: int
    :type one: int
    :rtype: int
    """
    MOD = int(1e9 +7)
    dp = [0 for i in range(high+1)]
    dp[0] = 1
    res = 0
    for i in range(1, high+1):
      if i >= zero:
        dp[i] = (dp[i] + dp[i-zero]) % MOD
      if i >= one:
        dp[i] = (dp[i] + dp[i-one]) % MOD
      if i>= low:
        res = (res + dp[i]) % MOD
    return res