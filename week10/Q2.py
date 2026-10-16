from functools import reduce

salaries = [25000, 35000, 40000, 50000, 30000]
revised = list(map(
    lambda s: s * 1.10 if s < 40000 else s,
    salaries
))
print("Revised salaries:", revised)

eligible = list(filter(lambda s: s < 40000, salaries))
print("Eligible salaries:", eligible)

total = reduce(lambda x, y: x + y, revised)
print("Total revised expenditure:", total)