slots = {
    "S1": ("car", "available"),
    "S2": ("bike", "occupied"),
    "S3": ("car", "available"),
    "S4": ("bike", "available"),
    "S5": ("car", "occupied")
}

def available_slots(vehicle):
    return [
        slot for slot, (kind, status) in slots.items()
        if kind == vehicle and status == "available"
    ]

print("Available car slots:", available_slots("car"))
print("Available bike slots:", available_slots("bike"))