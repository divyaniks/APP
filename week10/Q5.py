students = {
    "arun": (True, True),
    "bala": (True, False),
    "charan": (True, True),
    "divya": (False, True)
}

def eligible(name):
    python_pass, data_pass = students[name]
    return python_pass and data_pass

for name in students:
    if eligible(name):
        print(name, "is eligible")