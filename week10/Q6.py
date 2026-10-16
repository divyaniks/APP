employees = {
    "ravi": (6, True, 5),
    "priya": (3, True, 4),
    "kumar": (8, False, 5),
    "meena": (7, True, 4)
}

def eligible(employee):
    experience, training, rating = employees[employee]
    return experience >= 5 and training and rating >= 4

for employee in employees:
    if eligible(employee):
        print(employee, "is eligible for promotion")