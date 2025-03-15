class Solution(object):
  def minCapability(self, nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: int
    """
    l = nums[0]
    h = nums[0]
    for num in nums:
      l = min(l, num)
      h = max(h, num)
    while l < h:
      m = (l+h)//2
      if(self.maxHouses(nums, m)>=k):
        h = m
      else:
        l = m + 1
    return l
    
  def maxHouses(self, nums, v):
    i = 0
    res = 0
    while i < len(nums):
      if nums[i]<=v:
        res+=1
        i+=2
      else:
        i+=1
    return res
