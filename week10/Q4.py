from functools import reduce

consumption = [8, 12, 15, 6, 20, 9]

high = list(filter(lambda x: x > 10, consumption))
print("Consumption above 10 units:", high)

cost = list(map(lambda x: x * 6, consumption))
print("Daily electricity cost:", cost)

total = reduce(lambda x, y: x + y, consumption)
print("Total consumption:", total, "units")

def electricity_bill(units):
    return units * 6

bill = electricity_bill(total)
print("Total electricity bill: Rs.", bill)

print("Original consumption:", consumption)