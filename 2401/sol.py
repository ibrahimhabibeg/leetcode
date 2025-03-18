class Solution(object):
  def longestNiceSubarray(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    start, maxLength, mask = 0, 0, 0
    for i in range(len(nums)):
      while mask & nums[i] != 0:
        mask ^= nums[start]
        start += 1
      mask |= nums[i]
      maxLength = max(maxLength, i-start+1)
    return maxLength
        