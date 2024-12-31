class Solution(object):
  def mincostTickets(self, days, costs):
    """
    :type days: List[int]
    :type costs: List[int]
    :rtype: int
    """
    dp = [0] * 366
    a = [False] * 366
    for day in days:
      a[day] = True
    for i in range(1, 366):
      dp[i] = min(dp[i-1] + costs[0], dp[max(0, i-7)] + costs[1], dp[max(0, i-30)] + costs[2]) if a[i] else dp[i-1]
    return dp[365]