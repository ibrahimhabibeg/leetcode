class Solution(object):
  def findAllRecipes(self, recipes, ingredients, supplies):
    """
    :type recipes: List[str]
    :type ingredients: List[List[str]]
    :type supplies: List[str]
    :rtype: List[str]
    """
    requires = {}
    required_by = {}
    for item in recipes + supplies + [ingredient for recipe in ingredients for ingredient in recipe]:
      requires[item] = []
      required_by[item] = []
    for recipe, requirements in zip(recipes, ingredients):
      for ingredient in requirements:
        requires[recipe].append(ingredient)
        required_by[ingredient].append(recipe)
    final_inventory = []
    while len(supplies) > 0:
      supply = supplies[0]
      final_inventory.append(supply)
      for recipe in required_by[supply]:
        requires[recipe].remove(supply)
        if len(requires[recipe]) == 0:
          supplies.append(recipe)
      supplies.pop(0)
    return [recipe for recipe in final_inventory if recipe in recipes]
         