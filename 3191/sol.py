class Solution(object):
  def minOperations(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    res = 0
    for i in range(len(nums)-2):
      if nums[i] == 0:
        res += 1
        for j in range(3):
          nums[i+j] = 1 - nums[i+j]
    return -1 if 0 in nums else res
        