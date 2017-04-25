class Counter:

    createdObjects = 0

    def __init__(self):
        Counter.createdObjects += 1

    def displayCreationNumber(cls):
        print("{} objects created.", Counter.createdObjects)

    displayCreationNumber = classmethod(displayCreationNumber)