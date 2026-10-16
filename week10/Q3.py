prices = [500, 1200, 2500, 800, 1500]

def discount(price):
    if price > 1000:
        return price * 0.80
    return price

discounted = list(map(discount, prices))
print("Discounted prices:", discounted)

eligible = list(filter(lambda p: p > 1000, prices))
print("Eligible product prices:", eligible)

print("Original prices:", prices)