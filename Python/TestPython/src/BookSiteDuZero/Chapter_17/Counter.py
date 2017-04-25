class Counter:

    createdObjects = 0

    def __init__(self):
        Counter.createdObjects += 1

    def displayCreationNumber():
        print("{} objects created.", Counter.createdObjects)

    displayCreationNumber = staticmethod(displayCreationNumber)