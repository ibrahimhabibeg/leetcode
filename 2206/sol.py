class Solution(object):
  def divideArray(self, nums):
    """
    :type nums: List[int]
    :rtype: bool
    """
    count = {}
    for num in nums:
      count[num] = 1 + count.get(num, 0)
    for v in count.values():
      if v%2==1:
        return False
    return True
        