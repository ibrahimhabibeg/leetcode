import math

class Solution(object):
  def repairCars(self, ranks, cars):
    """
    :type ranks: List[int]
    :type cars: int
    :rtype: int
    """
    l = 1
    h = min(ranks) * cars * cars
    while l < h:
      t = (l+h) // 2
      if self.maxCarsRepairedInTime(ranks, t) >= cars:
        h = t
      else:
        l = t + 1
    return l
    
  def maxCarsRepairedInTime(self, ranks, time):
    max_cars_per_mechanic = [math.floor(math.sqrt(time/r)) for r in ranks]
    return sum(max_cars_per_mechanic)
        